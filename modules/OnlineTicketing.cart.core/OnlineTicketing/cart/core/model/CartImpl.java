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


@Entity(name="cart_impl")
@Table(name="cart_impl")
public class CartImpl extends CartComponent {

	public CartImpl(UUID id, int total, CustomerImpl customerimpl) {
		this.id = id;
		this.total = total;
		this.customerimpl = customerimpl;
	}

	public CartImpl(int total, CustomerImpl customerimpl) {
		this.id =  id.randomUUID();;
		this.total = total;
		this.customerimpl = customerimpl;
	}

	public CartImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> cartMap = new HashMap<String,Object>();
		cartMap.put("id",getId());
		cartMap.put("total",getTotal());
		cartMap.put("customerimpl",getCustomerimpl());

        return cartMap;
    }

}
