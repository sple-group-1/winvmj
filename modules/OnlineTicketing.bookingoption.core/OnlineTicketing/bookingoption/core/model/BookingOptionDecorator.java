package OnlineTicketing.bookingoption.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;

import OnlineTicketing.bookingitem.core.BookingItem;
//add other required packages

@MappedSuperclass
public abstract class BookingOptionDecorator extends BookingOptionComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BookingOptionComponent record;

	public BookingOptionDecorator () {
		super();
		this.record = new BookingOptionImpl();
		this.id =  id.randomUUID();
	}
		
	public BookingOptionDecorator (BookingOptionComponent record) {
		this.id =  UUID.randomUUID();
		this.record = record;
	}

	public BookingOptionDecorator (UUID id, BookingOptionComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	// public BookingOptionDecorator (BookingOptionComponent record, String objectName) {
	// 	this.id =  UUID.randomUUID();
	// 	this.record = record;	
	// 	this.objectName=objectName;
	// }

	public BookingOptionComponent getRecord() {
		return this.record;
	}

	public void setRecord(BookingOptionComponent record) {
		this.record = record;
	}

	public UUID getId() {return this.id;};
	public void setId(UUID id) {this.id=id;};
	
	public Long getPrice() {
		return record.getPrice();
	};

	public void setPrice(Long price) {
		record.setPrice(price);
	};
	
	public String getBookingType(){
		return record.getBookingType();
	};

	public void setBookingType(String bookingType) {
		record.setBookingType(bookingType);
	};
	
	public BookingItem getBookingItem() {
		return record.getBookingItem();
	};
	
	public void setBookingItem(BookingItem bookingItem) {
		record.setBookingItem(bookingItem);
	};

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
