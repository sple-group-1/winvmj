package OnlineTicketing.order.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface OrderResource {
    List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange);
    HashMap<String, Object> updateOrder(VMJExchange vmjExchange);
    HashMap<String, Object> getOrder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange);
	HashMap<String, Object> createOrder(VMJExchange vmjExhange);
}
