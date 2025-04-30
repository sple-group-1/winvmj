package OnlineTicketing.review.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="review_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReviewComponent implements Review{
	@Id
	public UUID reviewId; 
	public UUID reviewId;
	public String reviewContent;
	public Date createdAt;
	@ManyToOne(targetEntity=OnlineTicketing.customer.core.CustomerComponent.class)
	public Customer customerimpl;
	@ManyToOne(targetEntity=OnlineTicketing..core.Component.class)
	public  bookingitemimpl;
	protected String objectName = ReviewComponent.class.getName();

	public ReviewComponent() {

	} 

	public ReviewComponent(
        UUID reviewId, String reviewContent, Date createdAt, CustomerImpl customerimpl, BookingItemImpl bookingitemimpl
    ) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.createdAt = createdAt;
        this.customerimpl = customerimpl;
        this.bookingitemimpl = bookingitemimpl;
    }

	public abstract UUID getReviewId();
	public abstract void setReviewId(UUID reviewId);
	
	public abstract String getReviewContent();
	public abstract void setReviewContent(String reviewContent);
	
	public abstract Date getCreatedAt();
	public abstract void setCreatedAt(Date createdAt);
	
	public abstract CustomerImpl getCustomerimpl();
	public abstract void setCustomerimpl(CustomerImpl customerimpl);
	
	public abstract BookingItemImpl getBookingitemimpl();
	public abstract void setBookingitemimpl(BookingItemImpl bookingitemimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " reviewId='" + getReviewId() + "'" +
            " reviewContent='" + getReviewContent() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " customerimpl='" + getCustomerimpl() + "'" +
            " bookingitemimpl='" + getBookingitemimpl() + "'" +
            "}";
    }
	
}
