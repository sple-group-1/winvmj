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


@Entity(name="bookingavailability_impl")
@Table(name="bookingavailability_impl")
public class BookingAvailbilityImpl extends BookingAvailbilityComponent {

	public BookingAvailbilityImpl(UUID id, int quota, int available, BookingOptionImpl bookingoptionimpl) {
		this.id = id;
		this.quota = quota;
		this.available = available;
		this.bookingoptionimpl = bookingoptionimpl;
	}

	public BookingAvailbilityImpl(int quota, int available, BookingOptionImpl bookingoptionimpl) {
		this.id =  id.randomUUID();;
		this.quota = quota;
		this.available = available;
		this.bookingoptionimpl = bookingoptionimpl;
	}

	public BookingAvailbilityImpl() { }

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
		bookingavailabilityMap.put("bookingoptionimpl",getBookingoptionimpl());

        return bookingavailabilityMap;
    }

}
