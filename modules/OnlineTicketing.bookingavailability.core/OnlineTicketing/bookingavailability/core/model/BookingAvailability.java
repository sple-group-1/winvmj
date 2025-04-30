package OnlineTicketing.bookingavailability.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface BookingAvailability {
	public UUID getId();
	public void setId(UUID id);
	public int getQuota();
	public void setQuota(int quota);
	public int getAvailable();
	public void setAvailable(int available);
	HashMap<String, Object> toHashMap();
}
