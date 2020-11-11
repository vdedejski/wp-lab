package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Order {

    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;

    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress, Long orderId) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
    }

    public Order() {
    }

    public void setClientNameAndAddress(String clientName, String clientAddress) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

    public void dumpData(){
        this.clientName = null;
        this.clientAddress = null;
        this.balloonColor = null;
        this.balloonSize = null;
        this.orderId = null;
    }
}
