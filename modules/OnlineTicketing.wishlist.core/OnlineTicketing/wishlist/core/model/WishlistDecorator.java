package OnlineTicketing.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class WishlistDecorator extends WishlistComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected WishlistComponent record;

	public WishlistDecorator () {
		super();
		this.record = record;
		this.wishlistId =  wishlistId.randomUUID();
		
	public WishlistDecorator (WishlistComponent record) {
		this.wishlistId =  wishlistId.randomUUID();
		this.record = record;
	}

	public WishlistDecorator (UUID wishlistId, WishlistComponent record) {
		this.wishlistId =  wishlistId;
		this.record = record;
	}
	
	public WishlistDecorator (WishlistComponent record, String objectName) {
		this.wishlistId =  wishlistId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public WishlistDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
