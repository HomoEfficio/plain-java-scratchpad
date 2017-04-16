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
                FileChannel readChannel = FileChannel.open(Paths.get("src/main/resources/springcamp.txt"), StandardOpenOption.READ)
        ) {

            Charset charset = Charset.forName("UTF-8");
            ByteBuffer buf = ByteBuffer.allocate(8 * 1024);

            while (readChannel.read(buf) != -1) {
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
