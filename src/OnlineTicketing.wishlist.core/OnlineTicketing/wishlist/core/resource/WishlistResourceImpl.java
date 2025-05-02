package OnlineTicketing.wishlist.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.wishlist.WishlistFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class WishlistResourceImpl extends WishlistResourceComponent{
	
	private WishlistServiceImpl wishlistServiceImpl = new WishlistServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/wishlist")
    public HashMap<String,Object> createwishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Wishlist result = wishlistServiceImpl.createWishlist(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/wishlist/update")
    public HashMap<String, Object> updateWishlist(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return wishlistServiceImpl.updateWishlist(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlist/detail")
    public HashMap<String, Object> getWishlist(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishlistServiceImpl.getWishlist(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlist/list")
    public List<HashMap<String,Object>> getAllWishlist(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return wishlistServiceImpl.getAllWishlist(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/wishlist/delete")
    public List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return wishlistServiceImpl.deleteWishlist(requestBody);
	}

}
