package OnlineTicketing.bookingavailability.dailyavailability;

import java.util.*;

import vmj.routing.route.VMJExchange;

import OnlineTicketing.bookingavailability.core.BookingAvailabilityServiceDecorator;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityImpl;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityServiceComponent;

public class BookingAvailabilityServiceImpl extends BookingAvailabilityServiceDecorator {
    public BookingAvailabilityServiceImpl (BookingAvailabilityServiceComponent record) {
        super(record);
    }

    
}
