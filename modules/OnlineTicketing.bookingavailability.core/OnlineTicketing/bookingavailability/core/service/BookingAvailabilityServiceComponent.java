package OnlineTicketing.bookingavailability.core;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BookingAvailabilityServiceComponent implements BookingAvailabilityService {
    protected RepositoryUtil<BookingAvailability> Repository;

    public BookingAvailabilityServiceComponent() {
        this.Repository = new RepositoryUtil<BookingAvailability>(
                OnlineTicketing.bookingavailability.core.BookingAvailabilityComponent.class);
    }

    public abstract BookingAvailability createBookingAvailability(Map<String, Object> requestBodye);

    public abstract BookingAvailability updateBookingAvailability(Map<String, Object> requestBody);

    public abstract BookingAvailability getBookingAvailability(Map<String, Object> requestBody);

    public abstract List<BookingAvailability> getAllBookingAvailability(Map<String, Object> requestBody);

    public abstract List<BookingAvailability> deleteBookingAvailability(Map<String, Object> requestBody);

    public abstract List<HashMap<String, Object>> transformListToHashMap(List<BookingAvailability> List);

}
