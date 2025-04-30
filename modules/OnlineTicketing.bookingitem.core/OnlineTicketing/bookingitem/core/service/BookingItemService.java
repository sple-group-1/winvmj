package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingItemService {
	BookingItem createBookingItem(Map<String, Object> requestBody);
	BookingItem createBookingItem(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getBookingItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveBookingItem(Map<String, Object> requestBody);
    HashMap<String, Object> updateBookingItem(Map<String, Object> requestBody);
    HashMap<String, Object> getBookingItemById(int id);
    List<HashMap<String,Object>> getAllBookingItem(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteBookingItem(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
