package OnlineTicketing.wishlist.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class WishlistServiceDecorator extends WishlistServiceComponent{
	protected WishlistServiceComponent record;

    public WishlistServiceDecorator(WishlistServiceComponent record) {
        this.record = record;
    }

	public WishlistImpl createWishlist(Map<String, Object> requestBody){
		return record.createWishlist(requestBody);
	}

    public Wishlist createWishlist(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createWishlist(requestBody, response);
	}

	public HashMap<String, Object> getWishlist(Map<String, Object> requestBody){
		return record.getWishlist(requestBody);
	}

	public List<HashMap<String,Object>> getAllWishlist(Map<String, Object> requestBody){
		return record.getAllWishlist(requestBody);
	}

    public List<HashMap<String,Object>> saveWishlist(VMJExchange vmjExchange){
		return record.saveWishlist(vmjExchange);
	}

    public HashMap<String, Object> updateWishlist(Map<String, Object> requestBody){
		return record.updateWishlist(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody){
		return record.deleteWishlist(requestBody);
	}

	public HashMap<String, Object> getWishlistById(int id){
        return record.getWishlistById(id);
    }

}
