import java.io.IOException;
import java.net.SocketException;

import static java.lang.Thread.sleep;

public class UDPReceiver implements Runnable{
    UDPUtils.UDPSocket udpSocket;
    public UDPReceiver(int port) throws SocketException {
        udpSocket = new UDPUtils.UDPSocket(port);
    }
    @Override
    public void run() {
        while (true){
            try {
                String msg = UDPUtils.recv(udpSocket);
                System.out.println(msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
