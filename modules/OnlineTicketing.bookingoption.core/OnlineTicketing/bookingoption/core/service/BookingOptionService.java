package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingOptionService {
	BookingOption createBookingOption(Map<String, Object> requestBody);
	BookingOption createBookingOption(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getBookingOption(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveBookingOption(Map<String, Object> requestBody);
    HashMap<String, Object> updateBookingOption(Map<String, Object> requestBody);
    HashMap<String, Object> getBookingOptionById(int id);
    List<HashMap<String,Object>> getAllBookingOption(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteBookingOption(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
