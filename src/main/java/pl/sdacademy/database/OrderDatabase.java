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

    private static Long currentId = 0L;
    private List<Order> orders;

    private OrderDatabase() {
        this.orders = new LinkedList<>();
    }

    public Long createOrder(final String userMail, final String address, final Map<Product, Integer> cart){
        Order order = new Order(currentId, userMail, address, cart);
        orders.add(order);
        return currentId++;
    }

    public List<Order> getOrdersFromUser(final String userMail) {
        return orders.stream()
                .filter(order -> order.getUserEmail().equalsIgnoreCase(userMail))
                .collect(Collectors.toList());
    }

    public static OrderDatabase getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
