package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BookingItemServiceComponent implements BookingItemService{
	protected RepositoryUtil<BookingItem> Repository;

    public BookingItemServiceComponent(){
        this.Repository = new RepositoryUtil<BookingItem>(OnlineTicketing.bookingitem.core.BookingItemComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveBookingItem(VMJExchange vmjExchange);
    public abstract BookingItem createBookingItem(Map<String, Object> requestBodye);
	public abstract BookingItem createBookingItem(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateBookingItem(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBookingItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllBookingItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<BookingItem> List);
    public abstract List<HashMap<String,Object>> deleteBookingItem(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBookingItemById(int id);

}
