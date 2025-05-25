import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import static java.lang.Thread.sleep;

public class UDPGenerator implements Runnable{
    UDPUtils.UDPSocket udp_s;
    public UDPGenerator(String addr, int port) throws SocketException, UnknownHostException {
        udp_s = new UDPUtils.UDPSocket(addr, port);
    }
    @Override
    public void run() {
        int cycle_times = 10, i = 0;
        while (i<cycle_times){
            try {
                UDPUtils.send(udp_s, i + " " + System.currentTimeMillis());
                i++;
                sleep(1000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
