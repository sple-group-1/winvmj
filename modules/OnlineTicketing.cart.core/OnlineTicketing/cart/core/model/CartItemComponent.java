package OnlineTicketing.cart.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import OnlineTicketing.bookingoption.core.*;
import java.time.*;
import javax.persistence.ManyToOne;

@Entity
@Table(name="cartitem_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CartItemComponent implements CartItem{
	@Id
	public UUID id; 
	@ManyToOne(targetEntity=OnlineTicketing.bookingoption.core.BookingOptionComponent.class)
	public BookingOption bookingOption;
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
        UUID id, BookingOption bookingOption, Cart cart, int quantity, LocalDate startDate, LocalDate endDate, int amount
    ) {
        this.id = id;
        this.bookingOption = bookingOption;
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
	
	public BookingOption getBookingOption(){
		return this.bookingOption; 
	}
	public void setBookingOption(BookingOption bookingOption){
		this.bookingOption = bookingOption;
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
            " bookingOption='" + getBookingOption() + "'" +
            " cart='" + getCart() + "'" +
            " quantity='" + getQuantity() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " amount='" + getAmount() + "'" +
            "}";
    }
	
}
