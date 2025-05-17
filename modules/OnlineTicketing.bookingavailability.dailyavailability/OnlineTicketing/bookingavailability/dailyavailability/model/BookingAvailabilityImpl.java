package OnlineTicketing.bookingavailability.dailyavailability;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.bookingavailability.core.BookingAvailabilityDecorator;
import OnlineTicketing.bookingavailability.core.BookingAvailability;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityComponent;

@Entity(name="bookingavailability_dailyavailability")
@Table(name="bookingavailability_dailyavailability")
public class BookingAvailabilityImpl extends BookingAvailabilityDecorator {

	protected Date date;
	public BookingAvailabilityImpl(
        super();
        this.objectName = BookingAvailabilityImpl.class.getName();
    }
    
    public BookingAvailabilityImpl(Date date, BookingAvailabilityImpl , BookingOptionImpl bookingoptionimpl, BookingOptionImpl bookingoptionimpl) {
    	super();
		this.date = date;
		this.objectName = BookingAvailabilityImpl.class.getName();
    }
	
	public BookingAvailabilityImpl(BookingAvailabilityComponent record, Date date, BookingAvailabilityImpl , BookingOptionImpl bookingoptionimpl, BookingOptionImpl bookingoptionimpl) {
		super(record);
		this.date = date;
		this.objectName = BookingAvailabilityImpl.class.getName();
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
