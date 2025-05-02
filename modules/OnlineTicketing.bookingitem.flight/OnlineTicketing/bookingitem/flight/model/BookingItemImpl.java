package OnlineTicketing.bookingitem.flight;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.bookingitem.core.BookingItemDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemComponent;

@Entity(name="bookingitem_flight")
@Table(name="bookingitem_flight")
public class BookingItemImpl extends BookingItemDecorator {

	protected String departureLocation;
	protected String arrivalLocation;
	protected DateTime departureTime;
	protected DateTime arrivalTime;
	protected String airline;
	public BookingItemImpl(
        super();
        this.objectName = BookingItemImpl.class.getName();
    }
    
    public BookingItemImpl(String departureLocation, String arrivalLocation, DateTime departureTime, DateTime arrivalTime, String airline) {
    	super();
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
		this.objectName = BookingItemImpl.class.getName();
    }
	
	public BookingItemImpl(BookingItemComponent record, String departureLocation, String arrivalLocation, DateTime departureTime, DateTime arrivalTime, String airline) {
		super(record);
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
		this.objectName = BookingItemImpl.class.getName();
	}

	public String getDepartureLocation() {
		return this.departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalLocation() {
		return this.arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public DateTime getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(DateTime departureTime) {
		this.departureTime = departureTime;
	}
	public DateTime getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(DateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}


}
