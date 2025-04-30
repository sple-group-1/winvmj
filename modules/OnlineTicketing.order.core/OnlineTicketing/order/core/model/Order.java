package OnlineTicketing.order.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Order {
	public UUID getOrderId();
	public void setOrderId(UUID orderId);
	public DateTime getCreatedAt();
	public void setCreatedAt(DateTime createdAt);
	public int getAmount();
	public void setAmount(int amount);
	public CustomerImpl getCustomerimpl();
	public void setCustomerimpl(CustomerImpl customerimpl);
	public BookingItemImpl getBookingitemimpl();
	public void setBookingitemimpl(BookingItemImpl bookingitemimpl);
	public int getQuantity();
	public void setQuantity(int quantity);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	HashMap<String, Object> toHashMap();
}
