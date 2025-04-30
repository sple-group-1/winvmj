package OnlineTicketing.wishlist.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Wishlist {
	public UUID getWishlistId();
	public void setWishlistId(UUID wishlistId);
	public DateTime getAddedAt();
	public void setAddedAt(DateTime addedAt);
	HashMap<String, Object> toHashMap();
}
