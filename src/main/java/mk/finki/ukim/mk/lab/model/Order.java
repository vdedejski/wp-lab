package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Order {

    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderId;
    private Long balloonId;

    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress, Long orderId, Long balloonId) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
        this.balloonId = balloonId;
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
        this.balloonId = null;
    }

}
