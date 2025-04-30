package OnlineTicketing.cart.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CartDecorator extends CartComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CartComponent record;

	public CartDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
		
	public CartDecorator (CartComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public CartDecorator (UUID id, CartComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public CartDecorator (CartComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public CartDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
