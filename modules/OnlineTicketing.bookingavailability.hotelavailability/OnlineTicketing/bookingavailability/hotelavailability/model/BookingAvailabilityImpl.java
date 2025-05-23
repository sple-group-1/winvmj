package OnlineTicketing.bookingavailability.hotelavailability;

import java.time.LocalDate;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.bookingavailability.core.BookingAvailabilityDecorator;
import OnlineTicketing.bookingavailability.core.BookingAvailability;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityComponent;

@Entity(name = "bookingavailability_hotelavailability")
@Table(name = "bookingavailability_hotelavailability")
public class BookingAvailabilityImpl extends BookingAvailabilityDecorator {

	protected LocalDate date;

	public BookingAvailabilityImpl() {
		super();
		this.objectName = BookingAvailabilityImpl.class.getName();
	}


	public BookingAvailabilityImpl(BookingAvailabilityComponent record, LocalDate date) {
		super(record);
		this.date = date;
		this.objectName = BookingAvailabilityImpl.class.getName();
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
