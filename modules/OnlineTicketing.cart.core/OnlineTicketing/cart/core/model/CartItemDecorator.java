package OnlineTicketing.cart.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CartItemDecorator extends CartItemComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CartItemComponent record;

	public CartItemDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}
	
	public CartItemDecorator (CartItemComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public CartItemDecorator (UUID id, CartItemComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public CartItemDecorator (CartItemComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
