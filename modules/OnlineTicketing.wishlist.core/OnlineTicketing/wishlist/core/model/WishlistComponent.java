package OnlineTicketing.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="wishlist_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistComponent implements Wishlist{
	@Id
	public UUID wishlistId; 
	public UUID wishlistId;
	public DateTime addedAt;
	protected String objectName = WishlistComponent.class.getName();

	public WishlistComponent() {

	} 

	public WishlistComponent(
        UUID wishlistId, DateTime addedAt
    ) {
        this.wishlistId = wishlistId;
        this.addedAt = addedAt;
    }

	public abstract UUID getWishlistId();
	public abstract void setWishlistId(UUID wishlistId);
	
	public abstract DateTime getAddedAt();
	public abstract void setAddedAt(DateTime addedAt);
	
 

	@Override
    public String toString() {
        return "{" +
            " wishlistId='" + getWishlistId() + "'" +
            " addedAt='" + getAddedAt() + "'" +
            "}";
    }
	
}
