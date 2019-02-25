package homo.efficio.nio;

import java.io.*;
import java.nio.ByteBuffer;
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

    public static void splitFileIntoDirChannel(String srcFilePath,
                                               String destDirPath,
                                               String splittedFileNameFormat,
                                               ByteBuffer buffer) throws IOException {

        final Path path = Paths.get(srcFilePath);
        final FileChannel srcFileChannel = FileChannel.open(path, StandardOpenOption.READ);
        final byte LINE_FEED = 0x0A;
        final byte CARRIAGE_RETURN = 0x0D;

        int fileCounter = 0;
        int totalReadBytes = 0;
        int totalWriteBytes = 0;
        int readBytes;

        while ((readBytes = srcFileChannel.read(buffer)) >= 0) {
            totalReadBytes += readBytes;

            final int contentLength = buffer.position();
            int newLinePosition = buffer.position();

            if (fileCounter == 0
                && (buffer.get(contentLength - 1) == LINE_FEED
                    || buffer.get(contentLength - 1) == CARRIAGE_RETURN)) {
                if (srcFileChannel.isOpen()) srcFileChannel.close();
                throw new IllegalArgumentException(
                        String.format(
                                "Buffer 사이즈가 한 행의 길이보다 커야 합니다. BuffeSize: [%d], LineLength: [%d]",
                                buffer.capacity(), contentLength));
            }

            final FileChannel splittedFileChannel =
                    FileChannel.open(Paths.get(destDirPath, String.format(splittedFileNameFormat, ++fileCounter)),
                            StandardOpenOption.TRUNCATE_EXISTING,
                            StandardOpenOption.CREATE,
                            StandardOpenOption.WRITE);

            boolean hasLineFeed = false;
            while (newLinePosition > 0) {
                if (buffer.get(--newLinePosition) == LINE_FEED) {  // 1 byte 씩 뒤로 가면서 줄바꿈 탐색
                    buffer.position(0);  // buffer의 처음부터
                    buffer.limit(++newLinePosition);  // LINE_FEED 까지 포함해서 write 되도록 limit 조정
                    // 버퍼의 [0, limit)의 내용을 splittedFileChannel이 바인딩된 파일에 write
                    totalWriteBytes += splittedFileChannel.write(buffer);
                    splittedFileChannel.close();
                    hasLineFeed = true;
                    break;
                }
            }

            if (!hasLineFeed) {
                if (splittedFileChannel.isOpen()) splittedFileChannel.close();
                if (srcFileChannel.isOpen()) srcFileChannel.close();
                throw new IllegalArgumentException("줄바꿈이 하나도 없습니다. 최소 하나 이상 줄바꿈이 있어야 합니다.");
            }

            // compact()를 위해 원래 읽었던 내용의 마지막 바이트 위치+1(==contentLength) 로 limit 설정
            buffer.limit(contentLength);

            // 버퍼의 [position, limit) 의 내용을 [0, limit - position) 으로 복사
            buffer.compact();
            // 복사 후 position은 limit에 위치하며 다음에 파일에서 읽어오는 내용이 position 부터 이어짐

        }

        srcFileChannel.close();

        System.out.println("Total Read  Bytes: " + totalReadBytes);
        System.out.println("Total Write Bytes: " + totalWriteBytes);
    }
}
