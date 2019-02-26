package homo.efficio.nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static homo.efficio.nio.LargeFileSplitterIO.splitFileIntoDir;
import static homo.efficio.nio.LargeFileSplitterIO.splitFileIntoDirChannel;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-02-25.
 */
public class LargeFileSplitterRunner {

    public static void main(String[] args) throws IOException, InterruptedException {

//        String s = System.lineSeparator();
//        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
//        System.out.print("[");
//        for (int i = 0, len = bytes.length ; i < len ; i++) {
//            System.out.print(bytes[i]);
//            System.out.print(" ");
//        }
//        System.out.println("]");

        Thread.sleep(8000L);

        runSplitterChannel(
                "./out/production/resources/file-split/test-data.csv",
//                "./src/main/resources/file-split/test-short",
                "./src/main/resources/file-split/splitted",
                "1%04d",
                ByteBuffer.allocateDirect(100 * 1024 * 1024)
//                ByteBuffer.allocateDirect(65)
        );


        Thread.sleep(5000L);


        runSplitterChannel(
                "./out/production/resources/file-split/test-data.csv",
                "./out/production/resources/file-split/splitted",
                "2%04d",
                ByteBuffer.allocate(100 * 1024 * 1024)
        );


        Thread.sleep(5000L);


        System.out.println("==============");
        System.out.println("파일 나누기 시작");
        long startTime = System.nanoTime();
        final File srcFile = new File("./out/production/resources/file-split/test-data.csv");

        splitFileIntoDir(srcFile, 100, new File("./out/production/resources/file-split/splitted"));

        long endTime = System.nanoTime();
        System.out.println("파일 나누기 완료");
        System.out.println("소요 시간(초): " + (endTime - startTime));


        Thread.sleep(8000L);
    }

    private static void runSplitterChannel(String srcFilePath,
                                           String destDirPath,
                                           String splittedFileNameFormat,
                                           ByteBuffer buffer) throws IOException {
        System.out.println("==============");
        System.out.println("파일 나누기 시작");
        long startTime = System.nanoTime();

        splitFileIntoDirChannel(
                srcFilePath,
                destDirPath,
                splittedFileNameFormat,
                buffer
        );

        long endTime = System.nanoTime();
        System.out.println("파일 나누기 완료");
        System.out.println("소요 시간(초): " + (endTime - startTime));
    }
}
