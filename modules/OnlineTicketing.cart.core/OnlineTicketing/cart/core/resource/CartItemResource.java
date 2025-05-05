package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CartItemResource {
    // List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange);
    HashMap<String, Object> updateCartItem(VMJExchange vmjExchange);
    HashMap<String, Object> getCartItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange);
	HashMap<String, Object> createCartItem(VMJExchange vmjExhange);
}
