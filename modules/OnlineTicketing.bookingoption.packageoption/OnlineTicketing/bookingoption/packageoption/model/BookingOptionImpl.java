package OnlineTicketing.bookingoption.packageoption;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;

import OnlineTicketing.util.core.*;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.event.*;
import OnlineTicketing.bookingoption.core.BookingOptionDecorator;
import OnlineTicketing.bookingoption.core.BookingOption;
import OnlineTicketing.bookingoption.core.BookingOptionComponent;

@Entity(name="bookingoption_packageoption")
@Table(name="bookingoption_packageoption")
public class BookingOptionImpl extends BookingOptionDecorator {

	protected String packageName;

    @OneToOne(targetEntity = OnlineTicketing.bookingitem.event.BookingItemImpl.class)
	public BookingItem event;

	public BookingOptionImpl() {
        super();
        this.objectName = BookingOptionImpl.class.getName();
    }
    
    public BookingOptionImpl(String packageName, BookingItem event) {
    	super();
		this.packageName = packageName;
		this.event = event;
		this.objectName = BookingOptionImpl.class.getName();
    }
	
	public BookingOptionImpl(BookingOptionComponent record, String packageName, BookingItem event) {
		super(record);
		this.packageName = packageName;
		this.event = event;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public BookingOptionImpl(UUID id, BookingOptionComponent record, String packageName, BookingItem event) {
		super(id, record);
		this.packageName = packageName;
		this.event = event;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public BookingItem getEvent() {
		return this.event;
	}

	public void setEvent(BookingItem event) {
		this.event = event;
	}

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " record='" + getRecord() + "'" +
            ", packageName='" + getPackageName() + "'" +
            ", event='" + getEvent() + "'" +
            "}";
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bookingOptionMap = record.toHashMap();
        bookingOptionMap.put("packageId", this.getId());
        bookingOptionMap.put("packageName", this.getPackageName());
        bookingOptionMap = Util.combine(bookingOptionMap, ((BookingItemImpl) this.getEvent()).toHashMap(), "event");
        return bookingOptionMap;
    }

}
