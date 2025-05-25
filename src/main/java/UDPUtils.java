import java.io.IOException;
import java.net.*;

public class UDPUtils {
    public static class UDPSocket {
        DatagramSocket s;
        InetAddress addr;
        int port;
        UDPSocket(String addr, int port) throws SocketException, UnknownHostException {
            s = new DatagramSocket();
            this.addr = InetAddress.getByName(addr);
            this.port = port;
        }
        // 接收端无需指定IP地址
        UDPSocket(int port) throws SocketException {
            // 接收端需在初始化DatagramSocket时指定端口
            s = new DatagramSocket(port);
            this.addr = null;
            this.port = port;
        }
    }
    public static void send(UDPSocket downSocket, String msg) throws IOException {
        byte[] sendData = msg.getBytes();
        DatagramPacket upPacket = new DatagramPacket(sendData, sendData.length, downSocket.addr, downSocket.port);
        downSocket.s.send(upPacket);
    }
    public static String recv(UDPSocket upSocket) throws IOException {
        byte[] buffer = new byte[1024];
        DatagramPacket downPacket = new DatagramPacket(buffer, buffer.length);
        upSocket.s.receive(downPacket);
        return new String(downPacket.getData(), 0, downPacket.getLength());
    }
    public static void close(DatagramSocket socket) {
        if (socket != null) {
            socket.close();
        }
    }
}
