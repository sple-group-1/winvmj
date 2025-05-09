package OnlineTicketing.bookingavailability.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BookingAvailbilityResourceComponent implements BookingAvailabilityResource{
	
	public BookingAvailbilityResourceComponent() { }
 
    public abstract HashMap<String, Object> createBookingAvailability(VMJExchange vmjExchange);
	public abstract HashMap<String, Object> updateBookingAvailability(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBookingAvailability(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBookingAvailability(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBookingAvailability(VMJExchange vmjExchange);

}
