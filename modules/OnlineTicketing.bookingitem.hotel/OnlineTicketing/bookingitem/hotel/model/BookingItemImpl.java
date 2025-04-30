package OnlineTicketing.bookingitem.hotel;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.bookingitem.core.BookingItemDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemComponent;

@Entity(name="bookingitem_hotel")
@Table(name="bookingitem_hotel")
public class BookingItemImpl extends BookingItemDecorator {

	protected String title;
	protected List<String> imageUrls;
	protected String location;
	protected List<String> facilities;
	public BookingItemImpl(
        super();
        this.objectName = BookingItemImpl.class.getName();
    }
    
    public BookingItemImpl(String title, List<String> imageUrls, String location, List<String> facilities, RoomOptionImpl ) {
    	super();
		this.title = title;
		this.imageUrls = imageUrls;
		this.location = location;
		this.facilities = facilities;
		this.objectName = BookingItemImpl.class.getName();
    }
	
	public BookingItemImpl(BookingItemComponent record, String title, List<String> imageUrls, String location, List<String> facilities, RoomOptionImpl ) {
		super(record);
		this.title = title;
		this.imageUrls = imageUrls;
		this.location = location;
		this.facilities = facilities;
		this.objectName = BookingItemImpl.class.getName();
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getImageUrls() {
		return this.imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public List<String> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(List<String> facilities) {
		this.facilities = facilities;
	}


}
