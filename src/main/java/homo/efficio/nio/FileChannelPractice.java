package homo.efficio.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017-04-16.
 */
public class FileChannelPractice {

    public static void main(String[] args) {

        getSpringCampAsciiPic();
    }

    private static String getSpringCampAsciiPic() {
        StringBuilder sb = new StringBuilder();
        System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
        try (
                FileChannel fileChannel = FileChannel.open(
                        // Paths.get() 은 아래와 같이 다수의 문자열 사용 가능
//                        Paths.get("src/main/resources/springcamp.txt"),
                        Paths.get("src/main/resources", "springcamp.txt"),
//                        Paths.get("src/main", "resources", "springcamp.txt"),
                                StandardOpenOption.READ  // 복수개의 OpenOption 조합 가능,
                        )  // READ + APPEND 는
                        // Exception in thread "main" java.lang.IllegalArgumentException: READ + APPEND not allowed 발생
        ) {

            Charset charset = Charset.forName("UTF-8");
            ByteBuffer buf = ByteBuffer.allocate(8 * 1024);

            while (fileChannel.read(buf) != -1) {
                buf.flip();
                sb.append(charset.decode(buf).toString());
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return null;
    }
}
