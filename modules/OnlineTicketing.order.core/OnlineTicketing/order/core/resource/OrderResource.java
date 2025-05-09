package OnlineTicketing.order.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface OrderResource {
    HashMap<String, Object> getOrder(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange);
	HashMap<String, Object> createOrder(VMJExchange vmjExhange);
}
