package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BookingOptionServiceDecorator extends BookingOptionServiceComponent{
	protected BookingOptionServiceComponent record;

    public BookingOptionServiceDecorator(BookingOptionServiceComponent record) {
        this.record = record;
    }

	public BookingOption createBookingOption(Map<String, Object> requestBody) {
		return record.createBookingOption(requestBody);
	}

    public BookingOption updateBookingOption(Map<String, Object> requestBody) {
		return record.updateBookingOption(requestBody);
	}

    public BookingOption getBookingOption(UUID id) {
		return record.getBookingOption(id);
	}

    public List<BookingOption> getAllBookingOption() {
		return record.getAllBookingOption();
	}

    public List<BookingOption> deleteBookingOption(UUID id) {
		return record.deleteBookingOption(id);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingOption> list) {
		return record.transformListToHashMap(list);
	}

}
