package homo.efficio.nio.channel.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-01-01.
 */
public class SimpleClient {

    public static void main(String[] args) throws IOException {
        final SocketChannel socketChannel = SocketChannel.open();
        System.out.println("$ 연결 시도");
        final boolean connect = socketChannel.connect(new InetSocketAddress("localhost", 3333));
        if (connect) {
            System.out.println("$$ 연결 성공 with " + ((InetSocketAddress) socketChannel.getRemoteAddress()).getHostString());
        }
    }
}
