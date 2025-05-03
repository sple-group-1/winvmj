package OnlineTicketing.order.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface OrderService {
	Order createOrder(Map<String, Object> requestBody);
	// Order createOrder(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getOrder(Map<String, Object> requestBody);
    // List<HashMap<String,Object>> saveOrder(Map<String, Object> requestBody);
    // HashMap<String, Object> updateOrder(Map<String, Object> requestBody);

    // HashMap<String, Object> getOrderById(int id);
    HashMap<String, Object> getOrderById(UUID id);

    List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody);
    // List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody);
	// List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
	List<HashMap<String, Object>> transformListToHashMap(List<Order> List);
}
