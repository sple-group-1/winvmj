package OnlineTicketing.cart.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="cartitem_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CartItemComponent implements CartItem{
	@Id
	public UUID id; 
	@ManyToOne(targetEntity=OnlineTicketing..core.Component.class)
	public  bookingitemimpl;
	@ManyToOne(targetEntity=OnlineTicketing.cart.core.CartComponent.class)
	public Cart cartimpl;
	public int quantity;
	public Date startDate;
	public Date endDate;
	public int amount;
	protected String objectName = CartItemComponent.class.getName();

	public CartItemComponent() {

	} 

	public CartItemComponent(
        UUID id, BookingItemImpl bookingitemimpl, CartImpl cartimpl, int quantity, Date startDate, Date endDate, int amount
    ) {
        this.id = id;
        this.bookingitemimpl = bookingitemimpl;
        this.cartimpl = cartimpl;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

	public abstract UUID getId();
	public abstract void setId(UUID id);
	
	public abstract BookingItemImpl getBookingitemimpl();
	public abstract void setBookingitemimpl(BookingItemImpl bookingitemimpl);
	
	public abstract CartImpl getCartimpl();
	public abstract void setCartimpl(CartImpl cartimpl);
	
	public abstract int getQuantity();
	public abstract void setQuantity(int quantity);
	
	public abstract Date getStartDate();
	public abstract void setStartDate(Date startDate);
	
	public abstract Date getEndDate();
	public abstract void setEndDate(Date endDate);
	
	public abstract int getAmount();
	public abstract void setAmount(int amount);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " bookingitemimpl='" + getBookingitemimpl() + "'" +
            " cartimpl='" + getCartimpl() + "'" +
            " quantity='" + getQuantity() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " amount='" + getAmount() + "'" +
            "}";
    }
	
}
