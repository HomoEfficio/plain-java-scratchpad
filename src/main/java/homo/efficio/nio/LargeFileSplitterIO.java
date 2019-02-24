package homo.efficio.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-02-24.
 */
public class LargeFileSplitterIO {

    public static List<File> splitFileIntoDir(File file, int sizeOfFileInMB, File destDir) throws IOException {
        int counter = 1;
        List<File> files = new ArrayList<>();
        int sizeOfChunk = 1024 * 1024 * sizeOfFileInMB;
        String eof = System.lineSeparator();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                File newFile = new File(destDir, String.format("%04d", counter++));
                try (OutputStream out = new BufferedOutputStream(new FileOutputStream(newFile))) {
                    int fileSize = 0;
                    while (line != null) {
                        byte[] bytes = (line + eof).getBytes(Charset.defaultCharset());
                        if (fileSize + bytes.length > sizeOfChunk)
                            break;
                        out.write(bytes);
                        fileSize += bytes.length;
                        line = br.readLine();
                    }
                }
                files.add(newFile);
            }
        }
        return files;
    }

    public static void splitFileIntoDirChannel(String srcFileAbsPath,
                                               String destDirAbsPath,
                                               String splittedFileNameFormat,
                                               ByteBuffer buffer) throws IOException {

        final Path path = Paths.get(srcFileAbsPath);
        final FileChannel srcFileChannel = FileChannel.open(path, StandardOpenOption.READ);
        final byte[] NEWLINE_BYTES = {0x0A, 0x0D};

        int fileCounter = 0;
        int totalReadBytes = 0;
        int totalWriteBytes = 0;
        int readBytes = 0;
        while ((readBytes = srcFileChannel.read(buffer)) >= 0) {
            totalReadBytes += readBytes;


//            int position = buffer.position();
//            buffer.position(--position);
//            System.out.println(buffer.get());
//
//            buffer.flip();
//            while (buffer.hasRemaining()) {
//                System.out.print(buffer.get() + " ");
//            }
//            System.out.println("\n\n");





            final FileChannel splittedFileChannel =
                    FileChannel.open(Paths.get(destDirAbsPath, String.format(splittedFileNameFormat, ++fileCounter)),
                            StandardOpenOption.TRUNCATE_EXISTING,
                            StandardOpenOption.CREATE,
                            StandardOpenOption.WRITE);

            int contentLength = buffer.position();
            int newLinePosition = buffer.position();

            byte b;
            int writeBytes = 0;
            for (int i = 1; newLinePosition > 0;) {
                b = buffer.get(newLinePosition -= i);  // 1 byte 씩 뒤로 가면서 줄바꿈 탐색
                if (b == NEWLINE_BYTES[0]) {  // System.lineSeparator() == 0x0A 인 시스템(리눅스)
//                if (b == NEWLINE_BYTES[1]) {
                    buffer.limit(++newLinePosition);
                    buffer.position(0);
                    // 버퍼의 [0, limit)의 내용을 splittedFileChannel이 바인딩된 파일에 write
                    writeBytes = splittedFileChannel.write(buffer);
                    splittedFileChannel.close();
                    totalWriteBytes += writeBytes;
                    break;
                }
            }

            // compact()를 위해 원래 읽었던 내용의 마지막 바이트 + 1(==contentLength) 로 limit 설정
            buffer.limit(contentLength);

            // CRLR 인 시스템에서는 아래 코드 필요
//            int newPosition = buffer.position();
//            buffer.position(++newPosition);

            // [position, limit) 의 내용을 [0, limit - position) 으로 복사
            buffer.compact();
            // 복사 후 position은 limit에 위치하며 다음에 파일에서 읽어오는 내용이 position 부터 이어짐
        }

        srcFileChannel.close();

        System.out.println("Total Read  Bytes: " + totalReadBytes);
        System.out.println("Total Write Bytes: " + totalWriteBytes);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

//        String s = System.lineSeparator();
//        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
//        System.out.print("[");
//        for (int i = 0, len = bytes.length ; i < len ; i++) {
//            System.out.print(bytes[i]);
//            System.out.print(" ");
//        }
//        System.out.println("]");

//        Thread.sleep(8000L);

        runSplitterChannel(
//                "./out/production/resources/file-split/test-data.csv",
                "./src/main/resources/file-split/test-short",
                "./src/main/resources/file-split/splitted",
                "1%04d",
//                ByteBuffer.allocateDirect(10 * 1024 * 1024)
                ByteBuffer.allocateDirect(65)
        );


//        Thread.sleep(5000L);
//
//
//        runSplitterChannel(
//                "./out/production/resources/file-split/test-data.csv",
//                "./out/production/resources/file-split/splitted",
//                "2%04d",
//                ByteBuffer.allocate(10 * 1024 * 1024)
//        );
//
//
//        Thread.sleep(5000L);
//
//
//        System.out.println("==============");
//        System.out.println("파일 나누기 시작");
//        long startTime = System.nanoTime();
//        final File srcFile = new File("./out/production/resources/file-split/test-data.csv");
//
//        splitFileIntoDir(srcFile, 10, new File("./out/production/resources/file-split/splitted"));
//
//        long endTime = System.nanoTime();
//        System.out.println("파일 나누기 완료");
//        System.out.println("소요 시간(초): " + (endTime - startTime));
//
//
//        Thread.sleep(8000L);
    }

    private static void runSplitterChannel(String srcFilePath,
                                           String destDir,
                                           String splittedFileNameFormat,
                                           ByteBuffer buffer) throws IOException {
        System.out.println("==============");
        System.out.println("파일 나누기 시작");
        long startTime = System.nanoTime();

        splitFileIntoDirChannel(
                srcFilePath,
                destDir,
                splittedFileNameFormat,
                buffer
        );

        long endTime = System.nanoTime();
        System.out.println("파일 나누기 완료");
        System.out.println("소요 시간(초): " + (endTime - startTime));
    }
}
