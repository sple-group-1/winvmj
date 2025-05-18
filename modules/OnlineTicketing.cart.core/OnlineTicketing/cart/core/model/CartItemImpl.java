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
import OnlineTicketing.bookingoption.core.*;
import java.time.*;

@Entity(name="cartitem_impl")
@Table(name="cartitem_impl")
public class CartItemImpl extends CartItemComponent {

	public CartItemImpl(UUID id, BookingOption bookingOption, Cart cart, int quantity, LocalDate startDate, LocalDate endDate, int amount) {
		this.id = id;
		this.bookingOption = bookingOption;
		this.cart = cart;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}

	public CartItemImpl(BookingOption bookingOption, Cart cart, int quantity, LocalDate startDate, LocalDate endDate, int amount) {
		this.id =  id.randomUUID();
		this.bookingOption = bookingOption;
		this.cart = cart;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}

	public CartItemImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> cartitemMap = new HashMap<String,Object>();
		cartitemMap.put("id",getId());
		cartitemMap.put("bookingOption",getBookingOption());
		cartitemMap.put("cart",getCart());
		cartitemMap.put("quantity",getQuantity());
		cartitemMap.put("startDate",getStartDate());
		cartitemMap.put("endDate",getEndDate());
		cartitemMap.put("amount",getAmount());

        return cartitemMap;
    }

}
