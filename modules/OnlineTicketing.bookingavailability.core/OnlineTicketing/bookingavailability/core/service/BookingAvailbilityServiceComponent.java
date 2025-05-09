package OnlineTicketing.bookingavailability.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BookingAvailbilityServiceComponent implements BookingAvailabilityService{
	protected RepositoryUtil<BookingAvailability> Repository;

    public BookingAvailbilityServiceComponent(){
        this.Repository = new RepositoryUtil<BookingAvailability>(OnlineTicketing.bookingavailability.core.BookingAvailbilityComponent.class);
    }	

    public abstract BookingAvailability createBookingAvailability(Map<String, Object> requestBodye);
	public abstract HashMap<String, Object> updateBookingAvailability(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBookingAvailability(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllBookingAvailability(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<BookingAvailability> List);
    public abstract List<HashMap<String,Object>> deleteBookingAvailability(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBookingAvailabilityById(UUID id);

}
