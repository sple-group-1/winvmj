package OnlineTicketing.bookingavailability.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class BookingAvailbilityResourceDecorator extends BookingAvailbilityResourceComponent {
	protected BookingAvailbilityResourceComponent record;

	public BookingAvailbilityResourceDecorator(BookingAvailbilityResourceComponent record) {
		this.record = record;
	}

	public HashMap<String, Object> createBookingAvailability(VMJExchange vmjExchange) {
		return record.createBookingAvailability(vmjExchange);
	}

	public HashMap<String, Object> updateBookingAvailability(VMJExchange vmjExchange) {
		return record.updateBookingAvailability(vmjExchange);
	}

	public HashMap<String, Object> getBookingAvailability(VMJExchange vmjExchange) {
		return record.getBookingAvailability(vmjExchange);
	}

	public List<HashMap<String, Object>> getAllBookingAvailability(VMJExchange vmjExchange) {
		return record.getAllBookingAvailability(vmjExchange);
	}

	public List<HashMap<String, Object>> deleteBookingAvailability(VMJExchange vmjExchange) {
		return record.deleteBookingAvailability(vmjExchange);
	}

}
