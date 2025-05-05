package OnlineTicketing.cart.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import OnlineTicketing.bookingitem.core.*;
import java.time.*;
import javax.persistence.ManyToOne;

@Entity
@Table(name="cartitem_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CartItemComponent implements CartItem{
	@Id
	public UUID id; 
	@ManyToOne(targetEntity=OnlineTicketing.bookingitem.core.BookingItemComponent.class)
	public BookingItem bookingitem;
	@ManyToOne(targetEntity=OnlineTicketing.cart.core.CartComponent.class)
	public Cart cart;
	public int quantity;
	public LocalDate startDate;
	public LocalDate endDate;
	public int amount;
	protected String objectName = CartItemComponent.class.getName();

	public CartItemComponent() {

	} 

	public CartItemComponent(
        UUID id, BookingItem bookingitem, Cart cart, int quantity, LocalDate startDate, LocalDate endDate, int amount
    ) {
        this.id = id;
        this.bookingitem = bookingitem;
        this.cart = cart;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

	public UUID getId(){
		return this.id;
	}
	public void setId(UUID id){
		this.id = id;
	}
	
	public BookingItem getBookingitem(){
		return this.bookingitem; 
	}
	public void setBookingitem(BookingItem bookingitem){
		this.bookingitem = bookingitem;
	}
	
	public Cart getCart(){
		return this.cart;
	}
	public void setCart(Cart cart){
		this.cart = cart;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	};
	
	public LocalDate getStartDate(){
		return this.startDate;
	}
	public void setStartDate(LocalDate startDate){
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate(){
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate){
		this.endDate = endDate;
	}
	
	public int getAmount(){
		return this.amount;
	}
	public void setAmount(int amount){
		this.amount = amount;
	}
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " bookingitem='" + getBookingitem() + "'" +
            " cart='" + getCart() + "'" +
            " quantity='" + getQuantity() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " amount='" + getAmount() + "'" +
            "}";
    }
	
}
