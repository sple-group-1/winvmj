package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BookingItemServiceComponent implements BookingItemService{
	protected RepositoryUtil<BookingItem> bookingItemRepository;

    public BookingItemServiceComponent(){
        this.bookingItemRepository = new RepositoryUtil<BookingItem>(OnlineTicketing.bookingitem.core.BookingItemComponent.class);
    }	

	public abstract BookingItem createBookingItem(Map<String, Object> requestBody);

    public abstract BookingItem updateBookingItem(Map<String, Object> requestBody);

    public abstract BookingItem getBookingItem(UUID id);

    public abstract List<BookingItem> getAllBookingItem();

    public abstract List<BookingItem> deleteBookingItem(UUID id);

	public abstract List<HashMap<String, Object>> transformListToHashMap(List<BookingItem> list);

}
