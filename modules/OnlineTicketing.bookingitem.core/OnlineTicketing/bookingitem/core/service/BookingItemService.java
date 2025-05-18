package OnlineTicketing.bookingitem.core;
import java.util.*;


public interface BookingItemService {
	BookingItem createBookingItem(Map<String, Object> requestBody);

    BookingItem updateBookingItem(Map<String, Object> requestBody);

    BookingItem getBookingItem(UUID id);

    List<BookingItem> getAllBookingItem();

    List<BookingItem> deleteBookingItem(UUID id);

	List<HashMap<String, Object>> transformListToHashMap(List<BookingItem> list);
}
