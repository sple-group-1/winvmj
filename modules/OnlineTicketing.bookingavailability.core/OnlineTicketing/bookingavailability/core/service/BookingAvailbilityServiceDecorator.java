package OnlineTicketing.bookingavailability.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BookingAvailbilityServiceDecorator extends BookingAvailbilityServiceComponent {
	protected BookingAvailbilityServiceComponent record;

	public BookingAvailbilityServiceDecorator(BookingAvailbilityServiceComponent record) {
		this.record = record;
	}

	public BookingAvailability createBookingAvailability(Map<String, Object> requestBody) {
		return record.createBookingAvailability(requestBody);
	}

	
	public HashMap<String, Object> getBookingAvailability(Map<String, Object> requestBody) {
		return record.getBookingAvailability(requestBody);
	}

	public List<HashMap<String, Object>> getAllBookingAvailability(Map<String, Object> requestBody) {
		return record.getAllBookingAvailability(requestBody);
	}



	public HashMap<String, Object> updateBookingAvailability(Map<String, Object> requestBody) {
		return record.updateBookingAvailability(requestBody);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingAvailability> List) {
		return record.transformListToHashMap(List);
	}

	public List<HashMap<String, Object>> deleteBookingAvailability(Map<String, Object> requestBody) {
		return record.deleteBookingAvailability(requestBody);
	}

	public HashMap<String, Object> getBookingAvailabilityById(UUID id) {
		return record.getBookingAvailabilityById(id);
	}

}
