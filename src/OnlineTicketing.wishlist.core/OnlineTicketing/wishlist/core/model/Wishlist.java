package OnlineTicketing.wishlist.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Wishlist {
	public UUID getWishlistId();
	public void setWishlistId(UUID wishlistId);
	public Date getAddedAt();
	public void setAddedAt(Date addedAt);
	HashMap<String, Object> toHashMap();
}
