package homo.efficio.nio.channel.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-01-01.
 */
public class SimpleServer {

    public static void main(String[] args) throws IOException {
        final ServerSocketChannel serverSocketChannel =
                ServerSocketChannel.open()
                    .bind(new InetSocketAddress("localhost", 3333));

        addShutdownHook(serverSocketChannel);

        while (true) {
            System.out.println("# 연결 대기");
            final SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("## 연결 수락 from " + ((InetSocketAddress) socketChannel.getRemoteAddress()).getHostString());
        }
    }

    private static void addShutdownHook(ServerSocketChannel serverSocketChannel) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (serverSocketChannel.isOpen()) serverSocketChannel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }
}
