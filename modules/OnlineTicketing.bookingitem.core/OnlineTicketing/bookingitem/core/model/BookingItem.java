package OnlineTicketing.bookingitem.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface BookingItem {
	public UUID getId();
	public void setId(UUID id);
	public String getBookingType();
	public void setBookingType(String bookingType);
	HashMap<String, Object> toHashMap();
}
