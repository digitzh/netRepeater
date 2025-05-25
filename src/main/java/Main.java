import java.net.SocketException;
import java.net.UnknownHostException;

public class MainTest {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        UDPSender u_gene = new UDPSender("localhost", 1111);
        UDPRepeater u_repe = new UDPRepeater(1111, "localhost", 2222);
        UDPReceiver u_recv = new UDPReceiver(2222);
        Thread t_gene = new Thread(u_gene);
        Thread t_recv = new Thread(u_recv);
        Thread t_repe = new Thread(u_repe);
        t_recv.start();
        t_gene.start();
        t_repe.start();
    }
}
