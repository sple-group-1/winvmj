package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface CartItemService {
	CartItem createCartItem(Map<String, Object> requestBody);
	// CartItem createCartItem(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getCartItem(Map<String, Object> requestBody);
    // List<HashMap<String,Object>> saveCartItem(Map<String, Object> requestBody);
    HashMap<String, Object> updateCartItem(Map<String, Object> requestBody);
    // HashMap<String, Object> getCartItemById(int id);
    HashMap<String, Object> getCartItemById(UUID id);
    List<HashMap<String,Object>> getAllCartItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody);
	// List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
    List<HashMap<String, Object>> transformListToHashMap(List<CartItem> List);
}
