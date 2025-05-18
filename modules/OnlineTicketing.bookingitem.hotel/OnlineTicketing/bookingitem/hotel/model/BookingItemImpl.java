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

@Entity(name = "bookingitem_hotel")
@Table(name = "bookingitem_hotel")
public class BookingItemImpl extends BookingItemDecorator {

	protected String title;
	protected String imageUrl;
	protected String location;
	protected String facilities;

	public BookingItemImpl() {
		super();
		this.objectName = BookingItemImpl.class.getName();
	}

	public BookingItemImpl(String title, String imageUrl, String location, String facilities) {
		super();
		this.title = title;
		this.imageUrl = imageUrl;
		this.location = location;
		this.facilities = facilities;
		this.objectName = BookingItemImpl.class.getName();
	}

	public BookingItemImpl(BookingItemComponent record, String title, String imageUrl, String location,
			String facilities) {
		super(record);
		this.title = title;
		this.imageUrl = imageUrl;
		this.location = location;
		this.facilities = facilities;
		this.objectName = BookingItemImpl.class.getName();
	}

	// Note: Wrapper and Decorator should share same id (HMD)
	public BookingItemImpl(UUID id, BookingItemComponent record, String title, String imageUrl, String location,
			String facilities) {
		super(id, record);
		this.title = title;
		this.imageUrl = imageUrl;
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

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFacilities() {
		return this.facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

}
