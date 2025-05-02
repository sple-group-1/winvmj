package OnlineTicketing.wishlist.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class WishlistResourceDecorator extends WishlistResourceComponent{
	protected WishlistResourceComponent record;

    public WishlistResourceDecorator(WishlistResourceComponent record) {
        this.record = record;
    }

    public Wishlist createWishlist(VMJExchange vmjExchange){
		return record.createWishlist(vmjExchange);
	}

    public HashMap<String, Object> updateWishlist(VMJExchange vmjExchange){
		return record.updateWishlist(vmjExchange);
	}

    public HashMap<String, Object> getWishlist(VMJExchange vmjExchange){
		return record.getWishlist(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllWishlist(VMJExchange vmjExchange){
		return record.getAllWishlist(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange){
		return record.deleteWishlist(vmjExchange);
	}

}
