public class RepeaterConfig {
    private int listenPort;
    private String forwardHost;
    private int forwardPort;

    // Getters and Setters
    public int getListenPort() {
        return listenPort;
    }

    public void setListenPort(int listenPort) {
        this.listenPort = listenPort;
    }

    public String getForwardHost() {
        return forwardHost;
    }

    public void setForwardHost(String forwardHost) {
        this.forwardHost = forwardHost;
    }

    public int getForwardPort() {
        return forwardPort;
    }

    public void setForwardPort(int forwardPort) {
        this.forwardPort = forwardPort;
    }
}
