package OnlineTicketing.bookingitem.event;

import java.util.*;

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
	protected byte[] imageUrls;
	protected String facilities;
	protected String description;
	
	public BookingItemImpl() {
        super();
		this.title = "";
		this.location = "";
		this.imageUrls = null;
		this.facilities = "";
		this.description = "";
        this.objectName = BookingItemImpl.class.getName();
    }
    
    public BookingItemImpl(String title, String location, byte[] imageUrls, String facilities, String description) {
    	super();
		this.title = title;
		this.location = location;
		this.imageUrls = imageUrls;
		this.facilities = facilities;
		this.description = description;
		this.objectName = BookingItemImpl.class.getName();
    }
	
	public BookingItemImpl(BookingItemComponent record, String title, String location, byte[] imageUrls, String facilities, String description) {
		super(record);
		this.title = title;
		this.location = location;
		this.imageUrls = imageUrls;
		this.facilities = facilities;
		this.description = description;
		this.objectName = BookingItemImpl.class.getName();
	}

	public BookingItemImpl(UUID id, BookingItemComponent record, String title, String location, byte[] imageUrls, String facilities, String description) {
		super(id, record);
		this.title = title;
		this.location = location;
		this.imageUrls = imageUrls;
		this.facilities = facilities;
		this.description = description;
		this.objectName = BookingItemImpl.class.getName();
	}

	public UUID getId() {
		return this.id;
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

	public byte[] getImageUrls() {
		return this.imageUrls;
	}

	public void setImageUrls(byte[] imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getFacilities() {
		return this.facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " record='" + getRecord() + "'" +
            " title='" + getTitle() + "'" +
            " location='" + getLocation() + "'" +
            " imageUrls='" + getImageUrls() + "'" +
            " facilities='" + getFacilities() + "'" +
            " description='" + getDescription() + "'" +
            "}";
    }

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bookingitemMap = record.toHashMap();
		bookingitemMap.put("eventId",this.getId());
		bookingitemMap.put("title",this.getTitle());
		bookingitemMap.put("location",this.getLocation());
		bookingitemMap.put("imageUrls",this.getImageUrls());
		bookingitemMap.put("facilities",this.getFacilities());
		bookingitemMap.put("description",this.getDescription());

        return bookingitemMap;
    }


}
