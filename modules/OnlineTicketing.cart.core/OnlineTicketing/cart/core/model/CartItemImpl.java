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
import java.time.format.DateTimeFormatter;
import OnlineTicketing.util.core.*;

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
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        HashMap<String, Object> cartitemMap = new HashMap<String,Object>();
		cartitemMap.put("id",getId());
		cartitemMap.put("startDate",getStartDate().format(dateFormatter));
		cartitemMap.put("endDate",getEndDate().format(dateFormatter));
		cartitemMap.put("quantity",getQuantity());
		cartitemMap.put("amount",getAmount());
		cartitemMap = Util.combine(cartitemMap, getCart().toHashMap(), "cart");
        cartitemMap = Util.combine(cartitemMap, getBookingOption().toHashMap(), "bookingOption");
        return cartitemMap;
    }

}
