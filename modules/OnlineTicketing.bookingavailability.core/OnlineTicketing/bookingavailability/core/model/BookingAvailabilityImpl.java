package OnlineTicketing.bookingavailability.core;

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

import OnlineTicketing.bookingoption.core.BookingOption;


@Entity(name="bookingavailability_impl")
@Table(name="bookingavailability_impl")
public class BookingAvailabilityImpl extends BookingAvailabilityComponent {

	public BookingAvailabilityImpl(UUID id, int quota, int available, BookingOption bookingOption) {
		this.id = id;
		this.quota = quota;
		this.available = available;
		this.bookingOption = bookingOption;
	}

	public BookingAvailabilityImpl(int quota, int available, BookingOption bookingOption) {
		this.id =  id.randomUUID();;
		this.quota = quota;
		this.available = available;
		this.bookingOption = bookingOption;
	}

	public BookingAvailabilityImpl() { }

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public int getQuota() {
		return this.quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}
	public int getAvailable() {
		return this.available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bookingavailabilityMap = new HashMap<String,Object>();
		bookingavailabilityMap.put("id",getId());
		bookingavailabilityMap.put("quota",getQuota());
		bookingavailabilityMap.put("available",getAvailable());
		bookingavailabilityMap.put("bookingoptionimpl",getBookingOption());

        return bookingavailabilityMap;
    }

}
