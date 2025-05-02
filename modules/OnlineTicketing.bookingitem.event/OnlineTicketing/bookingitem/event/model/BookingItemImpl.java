package OnlineTicketing.bookingitem.event;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.bookingitem.core.BookingItemDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemComponent;

@Entity(name="bookingitem_event")
@Table(name="bookingitem_event")
public class BookingItemImpl extends BookingItemDecorator {

	protected String title;
	protected String location;
	protected List<String> imageUrls;
	protected List<String> facilities;
	protected String description;
	public BookingItemImpl(
        super();
        this.objectName = BookingItemImpl.class.getName();
    }
    
    public BookingItemImpl(String title, String location, List<String> imageUrls, List<String> facilities, String description) {
    	super();
		this.title = title;
		this.location = location;
		this.imageUrls = imageUrls;
		this.facilities = facilities;
		this.description = description;
		this.objectName = BookingItemImpl.class.getName();
    }
	
	public BookingItemImpl(BookingItemComponent record, String title, String location, List<String> imageUrls, List<String> facilities, String description) {
		super(record);
		this.title = title;
		this.location = location;
		this.imageUrls = imageUrls;
		this.facilities = facilities;
		this.description = description;
		this.objectName = BookingItemImpl.class.getName();
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public List<String> getImageUrls() {
		return this.imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	public List<String> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(List<String> facilities) {
		this.facilities = facilities;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
