package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
//add other required packages

public abstract class BookingOptionServiceComponent implements BookingOptionService{
	protected RepositoryUtil<BookingOption> bookingOptionRepository;

    public BookingOptionServiceComponent(){
        this.bookingOptionRepository = new RepositoryUtil<BookingOption>(OnlineTicketing.bookingoption.core.BookingOptionComponent.class);
    }	

	public abstract BookingOption createBookingOption(Map<String, Object> requestBody);

    public abstract BookingOption updateBookingOption(Map<String, Object> requestBody);

    public abstract BookingOption getBookingOption(UUID id);

    public abstract List<BookingOption> getAllBookingOption();

    public abstract List<BookingOption> deleteBookingOption(UUID id);

	public abstract List<HashMap<String, Object>> transformListToHashMap(List<BookingOption> list);

}
