package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Order {

    // Lombok mi dava getteri i setteri

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

    public String getBalloonColor() {
        return balloonColor;
    }

    public void setBalloonColor(String balloonColor) {
        this.balloonColor = balloonColor;
    }

    public String getBalloonSize() {
        return balloonSize;
    }

    public void setBalloonSize(String balloonSize) {
        this.balloonSize = balloonSize;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
