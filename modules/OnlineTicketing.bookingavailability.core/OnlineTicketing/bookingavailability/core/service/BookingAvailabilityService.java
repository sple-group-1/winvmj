package OnlineTicketing.bookingavailability.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingAvailabilityService {
	BookingAvailability createBookingAvailability(Map<String, Object> requestBody);
	BookingAvailability createBookingAvailability(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getBookingAvailability(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveBookingAvailability(Map<String, Object> requestBody);
    HashMap<String, Object> updateBookingAvailability(Map<String, Object> requestBody);
    HashMap<String, Object> getBookingAvailabilityById(int id);
    List<HashMap<String,Object>> getAllBookingAvailability(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteBookingAvailability(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
