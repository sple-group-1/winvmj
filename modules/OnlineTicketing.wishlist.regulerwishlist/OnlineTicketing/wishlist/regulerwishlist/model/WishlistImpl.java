package OnlineTicketing.wishlist.regulerwishlist;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.wishlist.core.WishlistDecorator;
import OnlineTicketing.wishlist.core.Wishlist;
import OnlineTicketing.wishlist.core.WishlistComponent;

@Entity(name="wishlist_regulerwishlist")
@Table(name="wishlist_regulerwishlist")
public class WishlistImpl extends WishlistDecorator {

	public WishlistImpl(
        super();
        this.objectName = WishlistImpl.class.getName();
    }
    
    public WishlistImpl(CustomerImpl customerimpl) {
    	super();
		this.objectName = WishlistImpl.class.getName();
    }
	
	public WishlistImpl(WishlistComponent record, CustomerImpl customerimpl) {
		super(record);
		this.objectName = WishlistImpl.class.getName();
	}



}
