package OnlineTicketing.wishlist.collectionwishlist;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import OnlineTicketing.wishlist.core.WishlistResourceDecorator;
import OnlineTicketing.wishlist.core.WishlistImpl;
import OnlineTicketing.wishlist.core.WishlistResourceComponent;
import OnlineTicketing.wishlist.core.WishlistComponent;
import OnlineTicketing.wishlist.core.Wishlist;
import OnlineTicketing.wishlist.WishlistFactory;
import OnlineTicketing.wishlist.core.WishlistDecorator;

public class WishlistResourceImpl extends WishlistResourceDecorator {
  private static final String OPTIONS_METHOD = "OPTIONS";
  private static final String WISHLIST_IMPL_CLASS =
      "OnlineTicketing.wishlist.collectionwishlist.WishlistImpl";
  private RepositoryUtil<Wishlist> wishlistRepository;
  private CollectionImpl collectionImpl;

  public WishlistResourceImpl(WishlistResourceComponent component) {
    super(component);
    this.wishlistRepository =
        new RepositoryUtil<>(OnlineTicketing.wishlist.core.WishlistComponent.class);
    this.collectionImpl = new CollectionImpl();
  }

  // @Restriced(permission = "")
  @Route(url = "call/collectionwishlist/save")
  public List<HashMap<String, Object>> saveWishlist(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals(OPTIONS_METHOD)) {
      return Collections.emptyList();
    }
    HashMap<String, Object> wishlistMap = createWishlist(vmjExchange); // Convert HashMap to
                                                                       // Wishlist object
    Wishlist wishlistObj =
        WishlistFactory.createWishlist(WISHLIST_IMPL_CLASS, wishlistMap, collectionImpl);
    wishlistRepository.saveObject(wishlistObj);
    return getAllWishlist(vmjExchange);
  }

  public HashMap<String, Object> createWishlist(VMJExchange vmjExchange) {
    HashMap<String, Object> wishlist = record.createWishlist(vmjExchange);
    Wishlist wishlistObj =
        WishlistFactory.createWishlist(WISHLIST_IMPL_CLASS, wishlist, collectionImpl);
    return wishlistObj.toHashMap();
  }

  public HashMap<String, Object> createWishlist(VMJExchange vmjExchange, int id) {
    // Get data directly from the record
    HashMap<String, Object> newWishlist = record.createWishlist(vmjExchange);
    Wishlist wishlistObj =
        WishlistFactory.createWishlist(WISHLIST_IMPL_CLASS, id, newWishlist, collectionImpl);
    return wishlistObj.toHashMap();
  }

  // @Restriced(permission = "")
  @Route(url = "call/collectionwishlist/update")
  public HashMap<String, Object> updateWishlist(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals(OPTIONS_METHOD)) {
      return null;
    }
    String idStr = (String) vmjExchange.getRequestBodyForm("");
    int id = Integer.parseInt(idStr);

    // Create updated wishlist
    HashMap<String, Object> updatedWishlistMap = createWishlist(vmjExchange, id);
    // Convert HashMap to Wishlist object
    Wishlist updatedWishlist =
        WishlistFactory.createWishlist(WISHLIST_IMPL_CLASS, updatedWishlistMap, collectionImpl);

    // Update and return
    wishlistRepository.updateObject(updatedWishlist);
    Wishlist result = wishlistRepository.getObject(id);
    return result.toHashMap();
  }

  // @Restriced(permission = "")
  @Route(url = "call/collectionwishlist/detail")
  public HashMap<String, Object> getWishlist(VMJExchange vmjExchange) {
    return record.getWishlist(vmjExchange);
  } // @Restriced(permission = "")

  @Route(url = "call/collectionwishlist/list")
  public List<HashMap<String, Object>> getAllWishlist(VMJExchange vmjExchange) {
    List<Wishlist> wishlistList = wishlistRepository.getAllObject("wishlist_impl");
    return transformWishlistListToHashMap(wishlistList);
  }

  public List<HashMap<String, Object>> transformWishlistListToHashMap(List<Wishlist> wishlistList) {
    List<HashMap<String, Object>> resultList = new ArrayList<>();
    for (int i = 0; i < wishlistList.size(); i++) {
      resultList.add(wishlistList.get(i).toHashMap());
    }
    return resultList;
  }

  // @Restriced(permission = "")
  @Route(url = "call/collectionwishlist/delete")
  public List<HashMap<String, Object>> deleteWishlist(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals(OPTIONS_METHOD)) {
      return Collections.emptyList();
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("");
    int id = Integer.parseInt(idStr);
    wishlistRepository.deleteObject(id);
    return getAllWishlist(vmjExchange);
  }
}
