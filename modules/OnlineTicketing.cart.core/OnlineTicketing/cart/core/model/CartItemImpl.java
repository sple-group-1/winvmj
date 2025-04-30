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


@Entity(name="cartitem_impl")
@Table(name="cartitem_impl")
public class CartItemImpl extends CartItemComponent {

	public CartItemImpl(UUID id, BookingItemImpl bookingitemimpl, CartImpl cartimpl, int quantity, Date startDate, Date endDate, int amount) {
		this.id = id;
		this.bookingitemimpl = bookingitemimpl;
		this.cartimpl = cartimpl;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}

	public CartItemImpl(BookingItemImpl bookingitemimpl, CartImpl cartimpl, int quantity, Date startDate, Date endDate, int amount) {
		this.id =  id.randomUUID();;
		this.bookingitemimpl = bookingitemimpl;
		this.cartimpl = cartimpl;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}

	public CartItemImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> cartitemMap = new HashMap<String,Object>();
		cartitemMap.put("id",getId());
		cartitemMap.put("bookingitemimpl",getBookingitemimpl());
		cartitemMap.put("cartimpl",getCartimpl());
		cartitemMap.put("quantity",getQuantity());
		cartitemMap.put("startDate",getStartDate());
		cartitemMap.put("endDate",getEndDate());
		cartitemMap.put("amount",getAmount());

        return cartitemMap;
    }

}
