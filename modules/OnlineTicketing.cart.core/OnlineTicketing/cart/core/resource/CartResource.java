package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CartResource {
    // List<HashMap<String,Object>> saveCart(VMJExchange vmjExchange);
    HashMap<String, Object> updateCart(VMJExchange vmjExchange);
    HashMap<String, Object> getCart(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCart(VMJExchange vmjExchange);
    // List<HashMap<String,Object>> deleteCart(VMJExchange vmjExchange);
	HashMap<String, Object> createCart(VMJExchange vmjExhange);
}
