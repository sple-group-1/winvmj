package OnlineTicketing.bookingitem.core;

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


@Entity(name="bookingitem_impl")
@Table(name="bookingitem_impl")
public class BookingItemImpl extends BookingItemComponent {

	public BookingItemImpl(UUID id, String bookingType) {
		this.id = id;
		this.bookingType = bookingType;
        this.objectName = BookingItemImpl.class.getName();

	}

	public BookingItemImpl(String bookingType) {
		this.id =  id.randomUUID();
		this.bookingType = bookingType;
        this.objectName = BookingItemImpl.class.getName();

	}

	public BookingItemImpl() {
		this.id =  id.randomUUID();
		this.bookingType = "";
        this.objectName = BookingItemImpl.class.getName();
	}

	// public UUID getId() {
	// 	return this.id;
	// }

	// public void setId(UUID id) {
	// 	this.id = id;
	// }
	// public String getBookingType() {
	// 	return this.bookingType;
	// }

	// public void setBookingType(String bookingType) {
	// 	this.bookingType = bookingType;
	// }

}
