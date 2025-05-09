package OnlineTicketing.wishlist.regulerwishlist;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import OnlineTicketing.wishlist.core.WishlistResourceDecorator;
import OnlineTicketing.wishlist.core.WishlistImpl;
import OnlineTicketing.wishlist.core.WishlistResourceComponent;
import OnlineTicketing.wishlist.core.WishlistServiceImpl;

public class WishlistResourceImpl extends WishlistResourceDecorator {
  private WishlistServiceImpl wishlistServiceImpl = new WishlistServiceImpl();

  public WishlistResourceImpl(WishlistResourceComponent record) {
    super(record);
  }

  // @Restriced(permission = "")
  @Route(url = "call/regulerwishlist/save")
  public List<HashMap<String, Object>> saveWishlist(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }
    HashMap<String, Object> wishlist = createWishlist(vmjExchange);
    return getAllWishlist(vmjExchange);
  }

  public HashMap<String, Object> createWishlist(VMJExchange vmjExchange) {

    HashMap<String, Object> wishlist = record.createWishlist(vmjExchange);
    // HashMap<String, Object> wishlistdeco = WishlistFactory.createWishlist(
    // "OnlineTicketing.regulerwishlist.core.WishlistImpl", wishlist, customerimpl);
    return wishlist;
  }

  public HashMap<String, Object> createWishlist(VMJExchange vmjExchange, int id) {
    HashMap<String, Object> savedWishlist = record.getWishlist(vmjExchange);
    // int recordWishlistId = savedWishlist.getId();

    HashMap<String, Object> wishlist = record.createWishlist(vmjExchange);
    // HashMap<String, Object> wishlistdeco = WishlistFactory.createWishlist(
    // "OnlineTicketing.regulerwishlist.core.WishlistImpl", id, wishlist, customerimpl);
    // return wishlistdeco;
    return wishlist;
  }

  // @Restriced(permission = "")
  @Route(url = "call/regulerwishlist/update")
  public HashMap<String, Object> updateWishlist(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }
    String idStr = (String) vmjExchange.getRequestBodyForm("");
    int id = Integer.parseInt(idStr);

    // HashMap<String, Object> wishlist = wishlistRepository.getObject(id);
    HashMap<String, Object> wishlist = createWishlist(vmjExchange, id);

    // wishlistRepository.updateObject(wishlist);
    // wishlist = wishlistRepository.getObject(id);
    // to do: fix association attributes

    return wishlist;
    // return wishlist.toHashMap();

  }

  // @Restriced(permission = "")
  @Route(url = "call/regulerwishlist/detail")
  public HashMap<String, Object> getWishlist(VMJExchange vmjExchange) {
    return record.getWishlist(vmjExchange);
  }

  // @Restriced(permission = "")
  @Route(url = "call/regulerwishlist/list")
  public List<HashMap<String, Object>> getAllWishlist(VMJExchange vmjExchange) {
    List<HashMap<String, Object>> wishlistList = new ArrayList<HashMap<String, Object>>();
    // List<HashMap<String, Object>> wishlistList =
    // wishlistRepository.getAllObject("wishlist_impl");
    return transformWishlistListToHashMap(wishlistList);
  }

  public List<HashMap<String, Object>> transformWishlistListToHashMap(
      List<HashMap<String, Object>> WishlistList) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < WishlistList.size(); i++) {
      resultList.add(WishlistList.get(i));
      // resultList.add(WishlistList.get(i).toHashMap());
    }

    return resultList;
  }

  // @Restriced(permission = "")
  @Route(url = "call/regulerwishlist/delete")
  public List<HashMap<String, Object>> deleteWishlist(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("");
    int id = Integer.parseInt(idStr);
    // wishlistRepository.deleteObject(id);
    return getAllWishlist(vmjExchange);
  }

}
