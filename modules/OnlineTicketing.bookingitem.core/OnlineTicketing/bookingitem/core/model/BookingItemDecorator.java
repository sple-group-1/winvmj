package OnlineTicketing.bookingitem.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BookingItemDecorator extends BookingItemComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BookingItemComponent record;

	public BookingItemDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}
		
	public BookingItemDecorator (BookingItemComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public BookingItemDecorator (UUID id, BookingItemComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public BookingItemDecorator (BookingItemComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
	}
	public String getBookingType() {
		return record.getBookingType();
	}
	public void setBookingType(String bookingType) {
		record.setBookingType(bookingType);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
