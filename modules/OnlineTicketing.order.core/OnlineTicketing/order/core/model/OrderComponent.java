package OnlineTicketing.order.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="order_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrderComponent implements Order{
	@Id
	public UUID orderId; 
	public UUID orderId;
	public DateTime createdAt;
	public int amount;
	public int quantity;
	public Date startDate;
	public Date endDate;
	@ManyToOne(targetEntity=OnlineTicketing.customer.core.CustomerComponent.class)
	public Customer customerimpl;
	@ManyToOne(targetEntity=OnlineTicketing..core.Component.class)
	public  bookingoptionimpl;
	protected String objectName = OrderComponent.class.getName();

	public OrderComponent() {

	} 

	public OrderComponent(
        UUID orderId, DateTime createdAt, int amount, int quantity, Date startDate, Date endDate, CustomerImpl customerimpl, BookingOptionImpl bookingoptionimpl
    ) {
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.amount = amount;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerimpl = customerimpl;
        this.bookingoptionimpl = bookingoptionimpl;
    }

	public abstract UUID getOrderId();
	public abstract void setOrderId(UUID orderId);
	
	public abstract DateTime getCreatedAt();
	public abstract void setCreatedAt(DateTime createdAt);
	
	public abstract int getAmount();
	public abstract void setAmount(int amount);
	
	public abstract int getQuantity();
	public abstract void setQuantity(int quantity);
	
	public abstract Date getStartDate();
	public abstract void setStartDate(Date startDate);
	
	public abstract Date getEndDate();
	public abstract void setEndDate(Date endDate);
	
	public abstract CustomerImpl getCustomerimpl();
	public abstract void setCustomerimpl(CustomerImpl customerimpl);
	
	public abstract BookingOptionImpl getBookingoptionimpl();
	public abstract void setBookingoptionimpl(BookingOptionImpl bookingoptionimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " orderId='" + getOrderId() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " amount='" + getAmount() + "'" +
            " quantity='" + getQuantity() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " customerimpl='" + getCustomerimpl() + "'" +
            " bookingoptionimpl='" + getBookingoptionimpl() + "'" +
            "}";
    }
	
}
