package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BookingItemResourceComponent implements BookingItemResource{
	
	protected RepositoryUtil<BookingItem> Repository;

    public BookingItemResourceComponent(){
        this.Repository = new RepositoryUtil<BookingItem>(OnlineTicketing.bookingitem.core.BookingItemComponent.class);
    }	
 
    public abstract HashMap<String, Object> createBookingItem(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateBookingItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBookingItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBookingItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBookingItem(VMJExchange vmjExchange);

}
