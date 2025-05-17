package OnlineTicketing.order.core;
import java.util.*;

import vmj.routing.route.VMJExchange;
import OnlineTicketing.customer.core.Customer;

public interface OrderService {
	Order createOrder(Map<String, Object> requestBody, Customer customer);
    HashMap<String, Object> getOrder(UUID id);
    List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Order> List);
    List<HashMap<String, Object>> getCompletedOrder(UUID customerId, String bookingType);
    List<HashMap<String, Object>> getUpcomingOrder(UUID customerId, String bookingType);
	HashMap<String, Object> countPayment(Map<String, Object> requestBody);
}
