package OnlineTicketing.bookingoption.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import OnlineTicketing.bookingitem.core.*;
import OnlineTicketing.util.core.*;

@Entity(name="bookingoption_comp")
@Table(name="bookingoption_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BookingOptionComponent implements BookingOption{
	@Id
	public UUID id; 
	public Long price;
	public String bookingType;
	@ManyToOne(targetEntity=OnlineTicketing.bookingitem.core.BookingItemComponent.class)
	public BookingItem bookingItem;
	protected String objectName = BookingOptionComponent.class.getName();

	public BookingOptionComponent() {

	} 

	// public BookingOptionComponent(
    //     UUID id, Long price, String bookingType, BookingItem bookingItem
    // ) {
    //     this.id = id;
    //     this.price = price;
    //     this.bookingType = bookingType;
    //     this.bookingItem = bookingItem;
    // }

	public UUID getId() {return this.id;};
	public void setId(UUID id) {this.id=id;};
	
	public Long getPrice() {return this.price;};
	public void setPrice(Long price) {this.price=price;};
	
	public String getBookingType(){return this.bookingType;};
	public void setBookingType(String bookingType) {this.bookingType=bookingType;};
	
	public BookingItem getBookingItem() {return this.bookingItem;};
	public void setBookingItem(BookingItem bookingItem){this.bookingItem = bookingItem;};
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " price='" + getPrice() + "'" +
            " bookingType='" + getBookingType() + "'" +
            " bookingItem='" + getBookingItem() + "'" +
            "}";
    }
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bookingoptionMap = new HashMap<String,Object>();
		bookingoptionMap.put("id",getId());
		bookingoptionMap.put("price",getPrice());
		bookingoptionMap.put("bookingType",getBookingType());
		if (getBookingItem() != null) {
        	bookingoptionMap = Util.combine(bookingoptionMap, getBookingItem().toHashMap(), "bookingItem");
		}

        return bookingoptionMap;
    }
}
