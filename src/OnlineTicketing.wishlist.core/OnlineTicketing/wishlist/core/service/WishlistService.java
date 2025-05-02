package OnlineTicketing.wishlist.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistService {
	Wishlist createWishlist(Map<String, Object> requestBody);
	Wishlist createWishlist(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getWishlist(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveWishlist(Map<String, Object> requestBody);
    HashMap<String, Object> updateWishlist(Map<String, Object> requestBody);
    HashMap<String, Object> getWishlistById(int id);
    List<HashMap<String,Object>> getAllWishlist(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
