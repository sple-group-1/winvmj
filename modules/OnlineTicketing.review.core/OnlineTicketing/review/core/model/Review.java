package OnlineTicketing.review.core;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import OnlineTicketing.customer.core.*;
import OnlineTicketing.bookingitem.core.*;

public interface Review {
	public UUID getReviewId();

	public void setReviewId(UUID reviewId);

	public String getReviewContent();

	public void setReviewContent(String reviewContent);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public Customer getCustomer();

	public void setCustomer(Customer customer);

	public BookingItem getBookingitem();

	public void setBookingitem(BookingItem bookingitem);

	HashMap<String, Object> toHashMap();
}
