package OnlineTicketing.wishlist.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistResource {
  // List<HashMap<String,Object>> saveWishlist(VMJExchange vmjExchange);
  HashMap<String, Object> updateWishlist(VMJExchange vmjExchange);

  HashMap<String, Object> getWishlist(VMJExchange vmjExchange);

  List<HashMap<String, Object>> getAllWishlist(VMJExchange vmjExchange);

  List<HashMap<String, Object>> deleteWishlist(VMJExchange vmjExchange);

  HashMap<String, Object> createWishlist(VMJExchange vmjExhange);
}
