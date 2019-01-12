package homo.efficio.nio.channel.nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-01-01.
 */
public class NioNonBlockingSocketChannelServer {

    private static final Logger LOGGER = Logger.getLogger("NioNonBlockingSocketChannelServer");

    public static void main(String[] args) throws IOException {

        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 3333));

        // Non-Blocking 모드로 설정
        serverSocketChannel.configureBlocking(false);

        LOGGER.info("Non-Blocking ServerSocketChannel 대기 중..");

        while (true) {

            // Non-Blocking 모드이므로
            // serverSocketChannel.accept()는 클라이언트 쪽에서 SocketChannel.open()을 호출하지 않아도
            // 바로 null을 return 하며 계속 while 문 내에서 반복 호출됨
            final SocketChannel clientSocketChannel = serverSocketChannel.accept();

            // 클라이언트 쪽에서 SocketChannel.open()을 호출하면
            // serverSocketChannel.accept()은 null 이 아닌 clientSocketChannel을 반환
            if (clientSocketChannel != null) {
                // Non-Blocking 모드이므로
                // 클라이언트 쪽에서 SocketChannel.open()을 호출하지 않아도 아래 로그가 바로 출력됨
                LOGGER.info("socketChannel로부터 메시지를 수신함");

                // 클라이언트가 전송한 메시지를 받아주는 버퍼
                final ByteBuffer serverByteBuffer = ByteBuffer.allocate(1024);

                // clientSocketChannel은 별도 설정을 하지 않아 Blocking 모드이므로
                // clientSocketChannel.read()는 클라이언트 쪽에서 socketChannel.write(clientByteBuffer)을 호출할 때까지 Blocking
                // 클라이언트 쪽에서 ByteBuffer에 담아 socketChannel.write(clientByteBuffer)로 보낸 메시지를 읽어서
                // severByteBuffer에 담는다.
                clientSocketChannel.read(serverByteBuffer);

                // 클라이언트 쪽에서 socketChannel.write(clientByteBuffer)을 호출하면
                // clientSocketChannel.read()가 반환된 뒤에 아래 로그 출력됨
                LOGGER.info("socketChannel로 부터 메시지가 read 됨");

                // serverByteBuffer에 담긴 메시지를 출력
                final String msgFromClient = new String(serverByteBuffer.array());
                LOGGER.info("### msgFromClient: " + msgFromClient);
            }
        }
    }
}
