package OnlineTicketing.bookingoption.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface BookingOption {
	public UUID getId();
	public void setId(UUID id);
	public ELong getPrice();
	public void setPrice(ELong price);
	public String getBookingType();
	public void setBookingType(String bookingType);
	public BookingItemImpl getBookingitemimpl();
	public void setBookingitemimpl(BookingItemImpl bookingitemimpl);
	HashMap<String, Object> toHashMap();
}
