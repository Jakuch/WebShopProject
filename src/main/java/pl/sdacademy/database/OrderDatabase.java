package pl.sdacademy.database;

import pl.sdacademy.model.Order;
import pl.sdacademy.model.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderDatabase {
    private static class SingletonHelper {
        private static final OrderDatabase INSTANCE = new OrderDatabase();
    }

    private List<Order> orders;

    public OrderDatabase() {
        this.orders = new LinkedList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long createOrder(Long orderId, String userMail, String address, Map<Product, Integer> products){
        Order order = new Order(orderId, userMail, address, products);
        orders.add(order);
        return orderId;
    }

    public List<Order> getOrdersFromUser(String userMail) {
        return orders.stream()
                .filter(order -> order.getUserEmail().equalsIgnoreCase(userMail))
                .collect(Collectors.toList());
    }

    public static OrderDatabase getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
