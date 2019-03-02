package pl.sdacademy.model;

import java.util.Map;

public class Order {
    private Long orderId;
    private String userEmail;
    private String address;
    private Map<Product, Integer> productIntegerMap;

    public Order(Long orderId, String userEmail, String address, Map<Product, Integer> productIntegerMap) {
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.address = address;
        this.productIntegerMap = productIntegerMap;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<Product, Integer> getProductIntegerMap() {
        return productIntegerMap;
    }

    public void setProductIntegerMap(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (userEmail != null ? !userEmail.equals(order.userEmail) : order.userEmail != null) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        return productIntegerMap != null ? productIntegerMap.equals(order.productIntegerMap) : order.productIntegerMap == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (productIntegerMap != null ? productIntegerMap.hashCode() : 0);
        return result;
    }
}
