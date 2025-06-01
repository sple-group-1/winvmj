package OnlineTicketing.bookingoption.roomoption;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.bookingoption.core.BookingOptionDecorator;
import OnlineTicketing.bookingoption.core.BookingOption;
import OnlineTicketing.bookingoption.core.BookingOptionComponent;
import OnlineTicketing.util.core.*;

import OnlineTicketing.bookingitem.hotel.BookingItemImpl;

@Entity(name = "bookingoption_roomoption")
@Table(name = "bookingoption_roomoption")
public class BookingOptionImpl extends BookingOptionDecorator {

	protected String roomType;
	protected String imageUrl;

	public BookingOptionImpl() {
		super();
		this.objectName = BookingOptionImpl.class.getName();
	}

	public BookingOptionImpl(String roomType, String imageUrl) {
		super();
		this.roomType = roomType;
		this.imageUrl = imageUrl;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public BookingOptionImpl(BookingOptionComponent record, String roomType, String imageUrl) {
		super(record);
		this.roomType = roomType;
		this.imageUrl = imageUrl;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public BookingOptionImpl(UUID id, BookingOptionComponent record, String roomType, String imageUrl) {
		super(id, record);
		this.roomType = roomType;
		this.imageUrl = imageUrl;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public UUID getId() {
		return this.id;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> bookingOptionMap = record.toHashMap();
		bookingOptionMap.put("id", this.getId());
		bookingOptionMap.put("roomType", this.getRoomType());
		bookingOptionMap.put("imageUrl", this.getImageUrl());
		BookingItemImpl hotel = (BookingItemImpl) this.getBookingItem();
		System.out.println("Hotel 0f room option: " + hotel.toHashMap());
		bookingOptionMap = Util.combine(bookingOptionMap, hotel.toHashMap(), "hotel");
		return bookingOptionMap;
}

}
