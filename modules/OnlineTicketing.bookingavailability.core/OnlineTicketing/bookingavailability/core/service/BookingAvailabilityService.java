package OnlineTicketing.bookingavailability.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingAvailabilityService {
	BookingAvailability createBookingAvailability(Map<String, Object> requestBody);
	BookingAvailability getBookingAvailability(Map<String, Object> requestBody);
    BookingAvailability updateBookingAvailability(Map<String, Object> requestBody);
    List<BookingAvailability> getAllBookingAvailability(Map<String, Object> requestBody);
    List<BookingAvailability> deleteBookingAvailability(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<BookingAvailability> List);
}
