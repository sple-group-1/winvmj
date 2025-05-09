package OnlineTicketing.wishlist.core;

import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.wishlist.WishlistFactory;
// import prices.auth.vmj.annotations.Restricted;
// add other required packages

public class WishlistServiceImpl extends WishlistServiceComponent {

  public List<HashMap<String, Object>> saveWishlist(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }
    Map<String, Object> map = new HashMap<>();

    Wishlist wishlist = createWishlist(map);
    wishlistRepository.saveObject(wishlist);
    return getAllWishlist(map);
  }

  public Wishlist createWishlist(Map<String, Object> requestBody) {
    String addedAt = (String) requestBody.get("addedAt");
    String wishlistId = (String) requestBody.get("wishlistId");


    // to do: fix association attributes
    Wishlist wishlist = WishlistFactory.createWishlist("OnlineTicketing.wishlist.core.WishlistImpl",
        wishlistId, addedAt);
    wishlistRepository.saveObject(wishlist);
    return wishlist;
  }

  public Wishlist createWishlist(Map<String, Object> requestBody, Map<String, Object> response) {

    // to do: fix association attributes
    String addedAt = (String) requestBody.get("addedAt");
    Wishlist wishlist =
        WishlistFactory.createWishlist("OnlineTicketing.wishlist.core.WishlistImpl", addedAt);
    return wishlist;
  }

  public HashMap<String, Object> updateWishlist(Map<String, Object> requestBody) {
    String idStr = (String) requestBody.get("wishlistId");
    int id = Integer.parseInt(idStr);
    Wishlist wishlist = wishlistRepository.getObject(id);


    wishlistRepository.updateObject(wishlist);

    // to do: fix association attributes

    return wishlist.toHashMap();

  }

  public HashMap<String, Object> getWishlist(Map<String, Object> requestBody) {
    List<HashMap<String, Object>> wishlistList = getAllWishlist(requestBody);
    String idStr = (String) requestBody.get("wishlistId");
    UUID id = UUID.fromString(idStr);
    for (HashMap<String, Object> wishlist : wishlistList) {
      // int record_id = ((Double) wishlist.get("record_id")).intValue();
      // if (record_id == id) {
      // return wishlist;
      // }
      UUID record_id = UUID.fromString(wishlist.get("record_id").toString());
      if (record_id.equals(id)) {
        return wishlist;
      }
    }
    return null;
  }

  public HashMap<String, Object> getWishlistById(VMJExchange vmjExchange) {
    String idStr = vmjExchange.getGETParam("wishlistId");
    int idInt = Integer.parseInt(idStr);
    Wishlist wishlist = wishlistRepository.getObject(idInt);
    return wishlist.toHashMap();
  }

  public List<HashMap<String, Object>> getAllWishlist(Map<String, Object> requestBody) {
    String table = "wishlist_impl";
    List<Wishlist> List = wishlistRepository.getAllObject(table);
    return transformListToHashMap(List);
  }

  public List<HashMap<String, Object>> transformListToHashMap(List<Wishlist> List) {
    List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
    for (int i = 0; i < List.size(); i++) {
      resultList.add(List.get(i).toHashMap());
    }

    return resultList;
  }

  public List<HashMap<String, Object>> deleteWishlist(Map<String, Object> requestBody) {
    String idStr = ((String) requestBody.get("id"));
    int id = Integer.parseInt(idStr);
    wishlistRepository.deleteObject(id);
    return getAllWishlist(requestBody);
  }

}
