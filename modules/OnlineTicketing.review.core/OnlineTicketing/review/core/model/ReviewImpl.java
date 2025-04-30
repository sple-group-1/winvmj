package OnlineTicketing.review.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="review_impl")
@Table(name="review_impl")
public class ReviewImpl extends ReviewComponent {

	public ReviewImpl(UUID reviewId, String reviewContent, Date createdAt, CustomerImpl customerimpl, BookingItemImpl bookingitemimpl) {
		this.reviewId = reviewId;
		this.reviewContent = reviewContent;
		this.createdAt = createdAt;
		this.customerimpl = customerimpl;
		this.bookingitemimpl = bookingitemimpl;
	}

	public ReviewImpl(UUID reviewId, String reviewContent, Date createdAt, CustomerImpl customerimpl, BookingItemImpl bookingitemimpl) {
		this.reviewId =  reviewId.randomUUID();;
		this.reviewId = reviewId;
		this.reviewContent = reviewContent;
		this.createdAt = createdAt;
		this.customerimpl = customerimpl;
		this.bookingitemimpl = bookingitemimpl;
	}

	public ReviewImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reviewMap = new HashMap<String,Object>();
		reviewMap.put("reviewId",getReviewId());
		reviewMap.put("reviewContent",getReviewContent());
		reviewMap.put("createdAt",getCreatedAt());
		reviewMap.put("customerimpl",getCustomerimpl());
		reviewMap.put("bookingitemimpl",getBookingitemimpl());

        return reviewMap;
    }

}
