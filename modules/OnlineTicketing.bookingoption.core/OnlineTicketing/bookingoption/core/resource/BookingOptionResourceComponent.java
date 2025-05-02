package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BookingOptionResourceComponent implements BookingOptionResource{
	protected RepositoryUtil<BookingOption> bookingOptionRepository;
	
	public BookingOptionResourceComponent() {
        this.bookingOptionRepository = new RepositoryUtil<BookingOption>(OnlineTicketing.bookingoption.core.BookingOptionComponent.class);
    }
 
    // public abstract BookingOption createBookingOption(VMJExchange vmjExchange);    
    public abstract HashMap<String, Object> createBookingOption(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateBookingOption(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBookingOption(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBookingOption(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBookingOption(VMJExchange vmjExchange);

}
