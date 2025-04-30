package OnlineTicketing.review.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Review {
	public UUID getReviewId();
	public void setReviewId(UUID reviewId);
	public String getReviewContent();
	public void setReviewContent(String reviewContent);
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	public CustomerImpl getCustomerimpl();
	public void setCustomerimpl(CustomerImpl customerimpl);
	public BookingItemImpl getBookingitemimpl();
	public void setBookingitemimpl(BookingItemImpl bookingitemimpl);
	HashMap<String, Object> toHashMap();
}
