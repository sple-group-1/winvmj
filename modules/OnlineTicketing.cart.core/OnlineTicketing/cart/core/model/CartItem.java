package OnlineTicketing.cart.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface CartItem {
	public UUID getId();
	public void setId(UUID id);
	public int getTotal();
	public void setTotal(int total);
	public CustomerImpl getCustomerimpl();
	public void setCustomerimpl(CustomerImpl customerimpl);
	public UUID getId();
	public void setId(UUID id);
	public BookingItemImpl getBookingitemimpl();
	public void setBookingitemimpl(BookingItemImpl bookingitemimpl);
	public CartImpl getCartimpl();
	public void setCartimpl(CartImpl cartimpl);
	public int getQuantity();
	public void setQuantity(int quantity);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public int getAmount();
	public void setAmount(int amount);
	HashMap<String, Object> toHashMap();
}
