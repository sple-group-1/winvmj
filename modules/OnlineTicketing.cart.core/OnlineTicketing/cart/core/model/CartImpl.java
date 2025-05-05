package OnlineTicketing.cart.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import OnlineTicketing.customer.core.*;


@Entity(name="cart_impl")
@Table(name="cart_impl")
public class CartImpl extends CartComponent {

	public CartImpl(UUID id, int total, Customer customer) {
		this.id = id;
		this.total = total;
		this.customer = customer;
	}

	public CartImpl(int total, Customer customer) {
		this.id =  id.randomUUID();;
		this.total = total;
		this.customer = customer;
	}

	public CartImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> cartMap = new HashMap<String,Object>();
		cartMap.put("id",getId());
		cartMap.put("total",getTotal());
		cartMap.put("customer",getCustomer());

        return cartMap;
    }

}
