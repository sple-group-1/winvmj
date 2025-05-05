package OnlineTicketing.cart.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import OnlineTicketing.bookingitem.core.*;
import java.time.*;

public interface CartItem {
	public UUID getId();
	public void setId(UUID id);
	public BookingItem getBookingitem();
	public void setBookingitem(BookingItem bookingitem);
	public Cart getCart();
	public void setCart(Cart cart);
	public int getQuantity();
	public void setQuantity(int quantity);
	public LocalDate getStartDate();
	public void setStartDate(LocalDate startDate);
	public LocalDate getEndDate();
	public void setEndDate(LocalDate endDate);
	public int getAmount();
	public void setAmount(int amount);
	HashMap<String, Object> toHashMap();
}
