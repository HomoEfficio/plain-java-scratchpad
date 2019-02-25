package homo.efficio.nio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-02-25.
 */
public class LargeFileSplitterIOTest {

    private static final String DEST_DIR_PATH = "./src/main/resources/file-split/splitted";

    @Before
    public void setup() throws IOException {
        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(DEST_DIR_PATH));
        for (Path path: paths) {
            Files.delete(path);
        }
    }

//    @After
//    public void teardown() throws IOException {
//        System.out.println(Thread.currentThread().getName());
//        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(DEST_DIR_PATH));
//        for (Path path: paths) {
//            Files.delete(path);
//        }
//    }

    @Test(expected = IllegalArgumentException.class)
    public void buffer_size_smaller_than_line_length() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1);
        runSplitterChannel(
                "./src/main/resources/file-split/test-short",
                DEST_DIR_PATH,
                "1%04d",
                ByteBuffer.allocateDirect(59)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void buffer_size_eq_line_length() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1);
        runSplitterChannel(
                "./src/main/resources/file-split/test-short",
                DEST_DIR_PATH,
                "1%04d",
                ByteBuffer.allocateDirect(60)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void buffer_size_ends_with_CR() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1);
        runSplitterChannel(
                "./src/main/resources/file-split/test-short",
                DEST_DIR_PATH,
                "1%04d",
                ByteBuffer.allocateDirect(61)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void buffer_size_ends_with_LF() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1);
        runSplitterChannel(
                "./src/main/resources/file-split/test-short",
                DEST_DIR_PATH,
                "1%04d",
                ByteBuffer.allocateDirect(62)
        );
    }

    @Test
    public void buffer_size_bigger_than_line_length() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1);
        runSplitterChannel(
                "./src/main/resources/file-split/test-short",
                DEST_DIR_PATH,
                "1%04d",
                ByteBuffer.allocateDirect(63)
        );

        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(DEST_DIR_PATH));
        int fileCount = 0;
        for (Path path: paths) {
            fileCount++;
        }
        assertThat(fileCount).isEqualTo(3);

        final BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File(DEST_DIR_PATH, "/10001")));
        assertThat(bufferedReader1.readLine()).isEqualTo("1,0.360507174,0.426709261,0.985675594,0.16216356,0.574695155");

        final BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File(DEST_DIR_PATH, "/10002")));
        assertThat(bufferedReader2.readLine()).isEqualTo("2,0.521748758,0.55061311,0.579868307,0.264238368,0.278763394");

        final BufferedReader bufferedReader3 = new BufferedReader(new FileReader(new File(DEST_DIR_PATH, "/10003")));
        assertThat(bufferedReader3.readLine()).isEqualTo("3,0.827426633,0.847610608,0.275608171,0.540904184,0.468640283");
    }

//    @Test
//    public void big_csv_file_with_100M_buffer_test() throws IOException {
//        runSplitterChannel(
//                "./src/main/resources/file-split/test-data.csv",
//                DEST_DIR_PATH,
//                "2%04d",
//                ByteBuffer.allocateDirect(100 * 1024 * 1024)
//        );
//
//        DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(DEST_DIR_PATH));
//        int fileCount = 0;
//        for (Path path: paths) {
//            fileCount++;
//        }
//        assertThat(fileCount).isEqualTo(3);
//
//        final BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File(DEST_DIR_PATH, "/20001")));
//        assertThat(bufferedReader1.readLine()).isEqualTo("1,0.360507174,0.426709261,0.985675594,0.16216356,0.574695155");
//
//        final BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File(DEST_DIR_PATH, "/20002")));
//        assertThat(bufferedReader2.readLine()).isEqualTo("738811,0.374146102,0.267714359,0.757768935,0.071658809,0.186567312");
//
//        final BufferedReader bufferedReader3 = new BufferedReader(new FileReader(new File(DEST_DIR_PATH, "/20003")));
//        assertThat(bufferedReader3.readLine()).isEqualTo("658426,0.879629279,0.064486956,0.410058201,0.665694847,0.778917752");
//    }

    private void runSplitterChannel(String srcFilePath,
                                    String destDirAbsPath,
                                    String splittedFileNameFormat,
                                    ByteBuffer buffer) throws IOException {
        System.out.println("==============");
        System.out.println("파일 나누기 시작");
        long startTime = System.nanoTime();

        LargeFileSplitterIO.splitFileIntoDirChannel(
                srcFilePath,
                destDirAbsPath,
                splittedFileNameFormat,
                buffer
        );

        long endTime = System.nanoTime();
        System.out.println("파일 나누기 완료");
        System.out.println("소요 시간(초): " + (endTime - startTime));
    }
}
