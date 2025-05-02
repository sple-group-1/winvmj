package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
//add other required packages

public abstract class BookingOptionServiceComponent implements BookingOptionService{
	protected RepositoryUtil<BookingOption> bookingOptionRepository;

    public BookingOptionServiceComponent(){
        this.bookingOptionRepository = new RepositoryUtil<BookingOption>(OnlineTicketing.bookingoption.core.BookingOptionComponent.class);
    }	

    // public abstract List<HashMap<String,Object>> saveBookingOption(Map<String, Object> requestBody);
    public abstract BookingOption createBookingOption(Map<String, Object> requestBody);
	// public abstract BookingOption createBookingOption(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateBookingOption(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBookingOption(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllBookingOption(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<BookingOption> List);
    public abstract List<HashMap<String,Object>> deleteBookingOption(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBookingOptionById(UUID id);

}
