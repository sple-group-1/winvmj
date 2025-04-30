package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BookingItemResourceComponent implements BookingItemResource{
	
	public BookingItemResourceComponent() { }
 
    public abstract BookingItem createBookingItem(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateBookingItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBookingItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBookingItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBookingItem(VMJExchange vmjExchange);

}
