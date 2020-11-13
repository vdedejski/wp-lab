package mk.finki.ukim.mk.lab.model;

import lombok.Data;

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

    public Long getBalloonId() {
        return balloonId;
    }

    public void setBalloonId(Long balloonId) {
        this.balloonId = balloonId;
    }
}
