package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingItemResource {
	HashMap<String, Object> createBookingItem(VMJExchange vmjExhange);
    HashMap<String, Object> updateBookingItem(VMJExchange vmjExchange);
    HashMap<String, Object> getBookingItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBookingItem(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBookingItem(VMJExchange vmjExchange);
}
