package homo.efficio.nio.channel.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-01-01.
 */
public class NioBlockingSocketChannelClient {

    public static void main(String[] args) throws IOException {

        // open(SocketAddress)는 내부적으로 connect(SocketAddress)를 호출
        final SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 3333));

        addShutdownHook(socketChannel);

        final Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("msg: ");

            // 터미널에서 입력을 받을때까지 Blocking
            final String msg = scanner.nextLine();

            // 입력받은 메시지를 byte array로 변환
            final byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);

            // byte array를 감싸서 clientByteBuffer에 저장
            final ByteBuffer clientByteBuffer = ByteBuffer.wrap(bytes);

            // clientByteBuffer에 저장된 메시지를 SocketChannel을 통해 상대방에게 전송
            socketChannel.write(clientByteBuffer);

            // buffer clear
            clientByteBuffer.clear();
        }
    }

    private static void addShutdownHook(SocketChannel socketChannel) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (socketChannel.isOpen()) {
                System.out.println("\n\n열려있는 socketChannel 닫음");
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }));
    }
}
