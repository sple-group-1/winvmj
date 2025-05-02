package OnlineTicketing.bookingoption.core;

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

import OnlineTicketing.bookingitem.core.*;


@Entity(name="bookingoption_impl")
@Table(name="bookingoption_impl")
public class BookingOptionImpl extends BookingOptionComponent {

	public BookingOptionImpl(UUID id, Long price, String bookingType, BookingItem bookingItem) {
		this.id = id;
		this.price = price;
		this.bookingType = bookingType;
		this.bookingItem = bookingItem;
	}

	public BookingOptionImpl(Long price, String bookingType, BookingItem bookingItem) {
		this.id =  UUID.randomUUID();
		this.price = price;
		this.bookingType = bookingType;
		this.bookingItem = bookingItem;
	}

	public BookingOptionImpl() {
		this.id =  UUID.randomUUID();
		this.price = null;
		this.bookingType = "";
		this.bookingItem = null;
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bookingoptionMap = new HashMap<String,Object>();
		bookingoptionMap.put("id",getId());
		bookingoptionMap.put("price",getPrice());
		bookingoptionMap.put("bookingType",getBookingType());
		bookingoptionMap.put("bookingItem",getBookingItem());

        return bookingoptionMap;
    }

}
