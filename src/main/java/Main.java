import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        UDPSender udpSender = new UDPSender("localhost", 1111);
        UDPRepeater udpRepeater = new UDPRepeater(1111, "localhost", 2222);
        UDPReceiver udpReceiver = new UDPReceiver(2222);
        Thread threadSender = new Thread(udpSender);
        Thread threadReceiver = new Thread(udpReceiver);
        Thread threadRepeater = new Thread(udpRepeater);
        threadReceiver.start();
        threadSender.start();
        threadRepeater.start();
    }
}
