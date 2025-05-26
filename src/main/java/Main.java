import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 声明变量
        String senderHost = null;
        int senderPort = 0;
        int repeaterListenPort = 0;
        String repeaterForwardHost = null;
        int repeaterForwardPort = 0;
        int receiverPort = 0;

        // 读取和解析json文件
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 从文件读取
            Config config = objectMapper.readValue(new File("src/main/resources/config.json"), Config.class);

            // 使用配置
            senderHost = config.getSenderConfig().getHost();
            senderPort = config.getSenderConfig().getPort();
            repeaterListenPort = config.getRepeaterConfig().getListenPort();
            repeaterForwardHost = config.getRepeaterConfig().getForwardHost();
            repeaterForwardPort = config.getRepeaterConfig().getForwardPort();
            receiverPort = config.getReceiverConfig().getPort();

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        UDPSender udpSender = new UDPSender(senderHost, senderPort);
        UDPRepeater udpRepeater = new UDPRepeater(repeaterListenPort, repeaterForwardHost, repeaterForwardPort);
        UDPReceiver udpReceiver = new UDPReceiver(receiverPort);
        Thread threadSender = new Thread(udpSender);
        Thread threadReceiver = new Thread(udpReceiver);
        Thread threadRepeater = new Thread(udpRepeater);
        threadReceiver.start();
        threadSender.start();
        threadRepeater.start();
    }

}
