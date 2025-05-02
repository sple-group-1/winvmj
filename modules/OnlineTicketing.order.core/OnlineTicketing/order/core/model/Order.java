package OnlineTicketing.order.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import OnlineTicketing.customer.core.Customer;
import OnlineTicketing.bookingoption.core.BookingOption;

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
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public BookingOption getBookingOption();
	public void setBookingOption(BookingOption bookingoption);
	HashMap<String, Object> toHashMap();
}
