package OnlineTicketing.wishlist.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
// add other required packages

public abstract class WishlistServiceComponent implements WishlistService {
  protected RepositoryUtil<Wishlist> wishlistRepository;

  public WishlistServiceComponent() {
    this.wishlistRepository =
        new RepositoryUtil<Wishlist>(OnlineTicketing.wishlist.core.WishlistComponent.class);
  }

  public abstract List<HashMap<String, Object>> saveWishlist(VMJExchange vmjExchange);

  public abstract Wishlist createWishlist(Map<String, Object> requestBody);

  // public abstract Wishlist createWishlist(Map<String, Object> requestBody,
  // Map<String, Object> response);

  public abstract HashMap<String, Object> updateWishlist(Map<String, Object> requestBody);

  public abstract HashMap<String, Object> getWishlist(Map<String, Object> requestBody);

  public abstract List<HashMap<String, Object>> getAllWishlist(Map<String, Object> requestBody);

  public abstract List<HashMap<String, Object>> transformListToHashMap(List<Wishlist> List);

  public abstract List<HashMap<String, Object>> deleteWishlist(Map<String, Object> requestBody);

  public abstract HashMap<String, Object> getWishlistById(VMJExchange vmjExchange);

}
