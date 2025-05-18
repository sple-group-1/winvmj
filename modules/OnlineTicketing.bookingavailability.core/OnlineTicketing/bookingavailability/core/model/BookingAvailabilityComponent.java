package OnlineTicketing.bookingavailability.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import OnlineTicketing.bookingoption.core.BookingOption;

@Entity
@Table(name = "bookingavailability_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BookingAvailabilityComponent implements BookingAvailability {
	@Id
	protected UUID id;
	protected int quota;
	protected int available;
	@ManyToOne(targetEntity = OnlineTicketing.bookingoption.core.BookingOptionComponent.class)
	public BookingOption bookingOption;
	protected String objectName = BookingAvailabilityComponent.class.getName();

	public BookingAvailabilityComponent() {

	}

	public BookingAvailabilityComponent(
			UUID id, int quota, int available, BookingOption bookingoptionimpl) {
		this.id = id;
		this.quota = quota;
		this.available = available;
		this.bookingOption = bookingoptionimpl;
	}

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

	public BookingOption getBookingOption() {
		return this.bookingOption;
	};

	public void setBookingOption(BookingOption bookingoptionimpl) {
		this.bookingOption = bookingoptionimpl;
	};

	@Override
	public String toString() {
		return "{" +
				" id='" + getId() + "'" +
				" quota='" + getQuota() + "'" +
				" available='" + getAvailable() + "'" +
				" bookingoptionimpl='" + getBookingOption() + "'" +
				"}";
	}

}
