package homo.efficio.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
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
                                               String destDir,
                                               String splittedFileNameFormat,
                                               ByteBuffer buffer) throws IOException {

        final Path path = Paths.get(srcFileAbsPath);
        final FileChannel srcFileChannel = FileChannel.open(path, StandardOpenOption.READ);
        final byte[] NEWLINE_BYTES = {0x0A, 0x0D};

        int counter = 1;
        int totalReadBytes = 0;
        int totalWriteBytes = 0;
        int readBytes = 0;
        while ((readBytes = srcFileChannel.read(buffer)) >= 0) {
            totalReadBytes += readBytes;
            final FileChannel splittedFileChannel =
                    FileChannel.open(Paths.get(destDir, String.format(splittedFileNameFormat, counter++)),
                            StandardOpenOption.TRUNCATE_EXISTING,
                            StandardOpenOption.CREATE,
                            StandardOpenOption.WRITE);

            int contentLength = buffer.position();
            int newLinePosition = buffer.position();

            byte b;
            int writeBytes = 0;
            for (int i = 1; newLinePosition > 0;) {
                b = buffer.get(newLinePosition -= i);
//                if (b == NEWLINE_BYTES[0]) {
                if (b == NEWLINE_BYTES[1]) {
                    buffer.limit(++newLinePosition);
                    buffer.position(0);
                    writeBytes = splittedFileChannel.write(buffer);
                    splittedFileChannel.close();
                    totalWriteBytes += writeBytes;
                    break;
                }
            }

            int newPosition = buffer.position();
            buffer.limit(contentLength);
            buffer.position(++newPosition);
            buffer.compact();
        }

        srcFileChannel.close();

        System.out.println("Total Read  Bytes: " + totalReadBytes);
        System.out.println("Total Write Bytes: " + totalWriteBytes);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread.sleep(8000L);

        runSplitterChannel(
                "./out/production/resources/file-split/test-data.csv",
//                "./out/production/resources/file-split/test-short",
                "./out/production/resources/file-split/splitted",
                "1%04d",
                ByteBuffer.allocateDirect(10 * 1024 * 1024)
//                ByteBuffer.allocateDirect(65)
        );


        Thread.sleep(5000L);


        runSplitterChannel(
                "./out/production/resources/file-split/test-data.csv",
                "./out/production/resources/file-split/splitted",
                "2%04d",
                ByteBuffer.allocate(10 * 1024 * 1024)
        );


        Thread.sleep(5000L);


        System.out.println("==============");
        System.out.println("파일 나누기 시작");
        long startTime = System.nanoTime();
        final File srcFile = new File("./out/production/resources/file-split/test-data.csv");

        splitFileIntoDir(srcFile, 10, new File("./out/production/resources/file-split/splitted"));

        long endTime = System.nanoTime();
        System.out.println("파일 나누기 완료");
        System.out.println("소요 시간(초): " + (endTime - startTime));


        Thread.sleep(8000L);
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
