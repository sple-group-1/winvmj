package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingOptionResource {
	HashMap<String, Object> createBookingOption(VMJExchange vmjExhange);
    HashMap<String, Object> updateBookingOption(VMJExchange vmjExchange);
    HashMap<String, Object> getBookingOption(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBookingOption(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBookingOption(VMJExchange vmjExchange);
}
