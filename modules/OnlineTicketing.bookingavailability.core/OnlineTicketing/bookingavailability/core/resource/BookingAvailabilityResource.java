package OnlineTicketing.bookingavailability.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BookingAvailabilityResource {
    HashMap<String, Object> createBookingAvailability(VMJExchange vmjExchange);
    HashMap<String, Object> updateBookingAvailability(VMJExchange vmjExchange);
    HashMap<String, Object> getBookingAvailability(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBookingAvailability(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBookingAvailability(VMJExchange vmjExchange);
}
