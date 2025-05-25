import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import static java.lang.Thread.sleep;

public class UDPSender implements Runnable{
    UDPUtils.UDPSocket udpSocket;
    public UDPSender(String addr, int port) throws SocketException, UnknownHostException {
        udpSocket = new UDPUtils.UDPSocket(addr, port);
    }
    @Override
    public void run() {
        int cycleTimes = 10, i = 0;
        while (i<cycleTimes){
            try {
                UDPUtils.send(udpSocket, i + " " + System.currentTimeMillis());
                i++;
                sleep(1000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        UDPUtils.close(udpSocket.s);
    }
}
