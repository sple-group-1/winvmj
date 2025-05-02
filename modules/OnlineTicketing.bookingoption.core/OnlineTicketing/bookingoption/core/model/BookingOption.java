package OnlineTicketing.bookingoption.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import OnlineTicketing.bookingitem.core.BookingItem;

public interface BookingOption {
	public UUID getId();
	public void setId(UUID id);
	public Long getPrice();
	public void setPrice(Long price);
	public String getBookingType();
	public void setBookingType(String bookingType);
	public BookingItem getBookingItem();
	public void setBookingItem(BookingItem bookingItem);
	HashMap<String, Object> toHashMap();
}
