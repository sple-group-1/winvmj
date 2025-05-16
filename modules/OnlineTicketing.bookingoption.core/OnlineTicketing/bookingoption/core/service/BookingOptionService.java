package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingOptionService {
	BookingOption createBookingOption(Map<String, Object> requestBody);

    BookingOption updateBookingOption(Map<String, Object> requestBody);

    BookingOption getBookingOption(UUID id);

    List<BookingOption> getAllBookingOption();

    List<BookingOption> deleteBookingOption(UUID id);

	List<HashMap<String, Object>> transformListToHashMap(List<BookingOption> list);
}
