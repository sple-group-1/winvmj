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

@Entity(name = "bookingoption_roomoption")
@Table(name = "bookingoption_roomoption")
public class BookingOptionImpl extends BookingOptionDecorator {

	protected String roomType;

	public BookingOptionImpl() {
		super();
		this.objectName = BookingOptionImpl.class.getName();
	}

	public BookingOptionImpl(String roomType) {
		super();
		this.roomType = roomType;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public BookingOptionImpl(BookingOptionComponent record, String roomType) {
		super(record);
		this.roomType = roomType;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public BookingOptionImpl(UUID id, BookingOptionComponent record, String roomType) {
		super(id, record);
		this.roomType = roomType;
		this.objectName = BookingOptionImpl.class.getName();
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

}
