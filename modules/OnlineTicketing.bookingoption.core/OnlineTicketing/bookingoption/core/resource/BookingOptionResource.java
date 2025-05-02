package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingOptionResource {
    List<HashMap<String,Object>> saveBookingOption(VMJExchange vmjExchange);
    HashMap<String, Object> updateBookingOption(VMJExchange vmjExchange);
    HashMap<String, Object> getBookingOption(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBookingOption(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBookingOption(VMJExchange vmjExchange);
	HashMap<String, Object> createBookingOption(VMJExchange vmjExhange);
}
