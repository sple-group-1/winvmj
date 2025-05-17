package OnlineTicketing.bookingitem.core;

import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BookingItemServiceDecorator extends BookingItemServiceComponent {
	protected BookingItemServiceComponent record;

	public BookingItemServiceDecorator(BookingItemServiceComponent record) {
		this.record = record;
	}

	public BookingItem createBookingItem(Map<String, Object> requestBody) {
		return record.createBookingItem(requestBody);
	}

    public BookingItem updateBookingItem(Map<String, Object> requestBody) {
		return record.updateBookingItem(requestBody);
	}

    public BookingItem getBookingItem(UUID id) {
		return record.getBookingItem(id);
	}

    public List<BookingItem> getAllBookingItem() {
		return record.getAllBookingItem();
	}

    public List<BookingItem> deleteBookingItem(UUID id) {
		return record.deleteBookingItem(id);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingItem> list) {
		return record.transformListToHashMap(list);
	}

}
