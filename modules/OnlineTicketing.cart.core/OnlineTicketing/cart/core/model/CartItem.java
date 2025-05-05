package OnlineTicketing.cart.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import OnlineTicketing.bookingitem.core.*;

public interface CartItem {
	public UUID getId();
	public void setId(UUID id);
	public BookingItem getBookingitem();
	public void setBookingitem(BookingItem bookingitem);
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
