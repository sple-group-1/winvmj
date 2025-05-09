package OnlineTicketing.order.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import java.time.*;

import OnlineTicketing.customer.core.Customer;
import OnlineTicketing.bookingoption.core.BookingOption;

public interface Order {
	public UUID getOrderId();
	public void setOrderId(UUID orderId);
	public LocalDateTime getCreatedAt();
	public void setCreatedAt(LocalDateTime createdAt);
	public Long getTotalPrice();
	public void setTotalPrice(Long totalPrice);
	public int getQuantity();
	public void setQuantity(int quantity);
	public LocalDate getStartDate();
	public void setStartDate(LocalDate startDate);
	public LocalDate getEndDate();
	public void setEndDate(LocalDate endDate);
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public BookingOption getBookingOption();
	public void setBookingOption(BookingOption bookingoption);
	HashMap<String, Object> toHashMap();
}
