package br.com.selat.feignpocclient.contract;

public class DelayResponse {

    private int delay;

    public DelayResponse() {
    }

    public DelayResponse(int status) {
        this.delay = status;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "DelayResponse{" +
                "delay=" + delay +
                '}';
    }
}
