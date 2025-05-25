import java.io.IOException;
import java.net.*;

public class UDPRepeater implements Runnable {
    UDPUtils.UDPSocket upSocket;
    UDPUtils.UDPSocket downSocket;
    public UDPRepeater(int upPort, String upAddress, int downPort) throws SocketException, UnknownHostException {
        upSocket = new UDPUtils.UDPSocket(upPort);
        downSocket = new UDPUtils.UDPSocket(upAddress, downPort);
    }
    @Override
    public void run() {
        while (true){
            try {
                String msg = UDPUtils.recv(upSocket);
                UDPUtils.send(downSocket, msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
