package OnlineTicketing.bookingitem.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name="bookingitem_comp")
@Table(name="bookingitem_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BookingItemComponent implements BookingItem{
	@Id
	protected UUID id; 
	protected String bookingType;
	protected String objectName = BookingItemComponent.class.getName();

	public BookingItemComponent() {

	} 

	// public BookingItemComponent(
    //     UUID id, String bookingType
    // ) {
    //     this.id = id;
    //     this.bookingType = bookingType;
    // }

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String getBookingType() {
		return this.bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " bookingType='" + getBookingType() + "'" +
            "}";
    }

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bookingitemMap = new HashMap<String,Object>();
		bookingitemMap.put("id",getId());
		bookingitemMap.put("bookingType",getBookingType());

        return bookingitemMap;
    }

	
}
