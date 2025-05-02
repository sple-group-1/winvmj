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
	public int getQuantity();
	public void setQuantity(int quantity);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public CustomerImpl getCustomerimpl();
	public void setCustomerimpl(CustomerImpl customerimpl);
	public BookingOptionImpl getBookingoptionimpl();
	public void setBookingoptionimpl(BookingOptionImpl bookingoptionimpl);
	HashMap<String, Object> toHashMap();
}
