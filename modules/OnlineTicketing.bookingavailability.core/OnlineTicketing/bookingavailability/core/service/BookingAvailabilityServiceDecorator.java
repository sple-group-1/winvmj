package OnlineTicketing.bookingavailability.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BookingAvailabilityServiceDecorator extends BookingAvailabilityServiceComponent {
	protected BookingAvailabilityServiceComponent record;

	public BookingAvailabilityServiceDecorator(BookingAvailabilityServiceComponent record) {
		this.record = record;
	}

	public BookingAvailability createBookingAvailability(Map<String, Object> requestBody) {
		return record.createBookingAvailability(requestBody);
	}

	
	public BookingAvailability getBookingAvailability(Map<String, Object> requestBody) {
		return record.getBookingAvailability(requestBody);
	}

	public List<BookingAvailability> getAllBookingAvailability(Map<String, Object> requestBody) {
		return record.getAllBookingAvailability(requestBody);
	}


	public BookingAvailability updateBookingAvailability(Map<String, Object> requestBody) {
		return record.updateBookingAvailability(requestBody);
	}

	
	public List<BookingAvailability> deleteBookingAvailability(Map<String, Object> requestBody) {
		return record.deleteBookingAvailability(requestBody);
	}
	
	
	public List<HashMap<String, Object>> transformListToHashMap(List<BookingAvailability> List) {
		return record.transformListToHashMap(List);
	}

}
