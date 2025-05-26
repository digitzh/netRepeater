// 配置类
public class Config {
    private SenderConfig senderConfig;
    private RepeaterConfig repeaterConfig;
    private ReceiverConfig receiverConfig;

    // Getters and Setters
    public SenderConfig getSenderConfig() {
        return senderConfig;
    }

    public void setSenderConfig(SenderConfig senderConfig) {
        this.senderConfig = senderConfig;
    }

    public RepeaterConfig getRepeaterConfig() {
        return repeaterConfig;
    }

    public void setRepeaterConfig(RepeaterConfig repeaterConfig) {
        this.repeaterConfig = repeaterConfig;
    }

    public ReceiverConfig getReceiverConfig() {
        return receiverConfig;
    }

    public void setReceiverConfig(ReceiverConfig receiverConfig) {
        this.receiverConfig = receiverConfig;
    }
}

