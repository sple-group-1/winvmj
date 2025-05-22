package OnlineTicketing.bookingavailability.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import OnlineTicketing.bookingoption.core.BookingOption;

public interface BookingAvailability {
	void setId(UUID id);
	UUID getId();
	void setQuota(int quota);
	int getQuota();
	void setAvailable(int available);
	int getAvailable();
	void setBookingOption(BookingOption bookingOption);
	BookingOption getBookingOption();
	HashMap<String, Object> toHashMap();
}
