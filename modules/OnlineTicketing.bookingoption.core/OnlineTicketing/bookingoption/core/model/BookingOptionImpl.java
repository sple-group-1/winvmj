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


@Entity(name="bookingoption_impl")
@Table(name="bookingoption_impl")
public class BookingOptionImpl extends BookingOptionComponent {

	public BookingOptionImpl(UUID id, ELong price, String bookingType, BookingItemImpl bookingitemimpl) {
		this.id = id;
		this.price = price;
		this.bookingType = bookingType;
		this.bookingitemimpl = bookingitemimpl;
	}

	public BookingOptionImpl(ELong price, String bookingType, BookingItemImpl bookingitemimpl) {
		this.id =  id.randomUUID();;
		this.price = price;
		this.bookingType = bookingType;
		this.bookingitemimpl = bookingitemimpl;
	}

	public BookingOptionImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bookingoptionMap = new HashMap<String,Object>();
		bookingoptionMap.put("id",getId());
		bookingoptionMap.put("price",getPrice());
		bookingoptionMap.put("bookingType",getBookingType());
		bookingoptionMap.put("bookingitemimpl",getBookingitemimpl());

        return bookingoptionMap;
    }

}
