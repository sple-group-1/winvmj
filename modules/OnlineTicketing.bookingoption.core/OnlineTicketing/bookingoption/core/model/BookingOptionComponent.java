package OnlineTicketing.bookingoption.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="bookingoption_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BookingOptionComponent implements BookingOption{
	@Id
	public UUID id; 
	public ELong price;
	public String bookingType;
	@ManyToOne(targetEntity=OnlineTicketing..core.Component.class)
	public  bookingitemimpl;
	protected String objectName = BookingOptionComponent.class.getName();

	public BookingOptionComponent() {

	} 

	public BookingOptionComponent(
        UUID id, ELong price, String bookingType, BookingItemImpl bookingitemimpl
    ) {
        this.id = id;
        this.price = price;
        this.bookingType = bookingType;
        this.bookingitemimpl = bookingitemimpl;
    }

	public abstract UUID getId();
	public abstract void setId(UUID id);
	
	public abstract ELong getPrice();
	public abstract void setPrice(ELong price);
	
	public abstract String getBookingType();
	public abstract void setBookingType(String bookingType);
	
	public abstract BookingItemImpl getBookingitemimpl();
	public abstract void setBookingitemimpl(BookingItemImpl bookingitemimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " price='" + getPrice() + "'" +
            " bookingType='" + getBookingType() + "'" +
            " bookingitemimpl='" + getBookingitemimpl() + "'" +
            "}";
    }
	
}
