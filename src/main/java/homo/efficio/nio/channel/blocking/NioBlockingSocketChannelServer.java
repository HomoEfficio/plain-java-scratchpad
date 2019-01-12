package homo.efficio.nio.channel.blocking;

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
public class NioBlockingSocketChannelServer {

    private static final Logger LOGGER = Logger.getLogger("NioBlockingSocketChannelServer");

    public static void main(String[] args) throws IOException {

        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // SocketChannel은 SocketChannel.configureBlocking(false)로 별도 설정하지 않으면 기본적으로 blocking
        LOGGER.info("serverSocketChannel isBlocking: " + serverSocketChannel.isBlocking());

        final ServerSocketChannel serverSocketChannel1 = serverSocketChannel.bind(new InetSocketAddress("localhost", 3333));

        // serverSocketChannel.accept()는 클라이언트 쪽에서 SocketChannel.connect(SocketAddress)을 호출해서
        // 클라이언트와 연결되는 소켓과 FileDescriptor가 생성될 때까지 Blocking
        final SocketChannel clientSocketChannel = serverSocketChannel.accept();

        // 클라이언트 쪽에서 SocketChannel.connect(SocketAddress)을 호출해서 소켓과 FileDescriptor가 생성되면
        // serverSocketChannel.accept()가 clientSocketChannel을 새로 생성해서 반환한 후 아래 로그 출력됨
        LOGGER.info("clientSocketChannel이 생성 됨");

        while (true) {
            LOGGER.info("Blocking ServerSocketChannel 대기 중..");

            // 클라이언트가 전송한 메시지를 받아주는 버퍼
            final ByteBuffer serverByteBuffer = ByteBuffer.allocate(3);

            // clientSocketChannel.read()는 클라이언트 쪽에서 socketChannel.write(clientByteBuffer)을 호출할 때까지 Blocking
            // 클라이언트 쪽에서 ByteBuffer에 담아 socketChannel.write(clientByteBuffer)로 보낸 메시지를 읽어서
            // serverByteBuffer에 담는다.
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
