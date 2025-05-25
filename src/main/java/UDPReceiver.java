import java.io.IOException;

import static java.lang.Thread.sleep;

public class UDPGenerator implements Runnable{
    UDPUtils.UDPSocket udp_s;
    @Override
    public void run() {
        while (true){
            try {
                UDPUtils.send(udp_s, "Hello!");
                sleep(1000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
