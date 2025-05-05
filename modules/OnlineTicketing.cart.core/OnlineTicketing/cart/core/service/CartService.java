package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CartService {
	Cart createCart(Map<String, Object> requestBody);
	HashMap<String, Object> getCart(Map<String, Object> requestBody);
    HashMap<String, Object> updateCart(Map<String, Object> requestBody);
    HashMap<String, Object> getCartById(UUID id);
    List<HashMap<String,Object>> getAllCart(Map<String, Object> requestBody);
    List<HashMap<String, Object>> transformListToHashMap(List<Cart> List);
}
