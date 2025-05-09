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

import OnlineTicketing.customer.core.*;
import OnlineTicketing.bookingitem.core.*;

@Entity(name = "review_impl")
@Table(name = "review_impl")
public class ReviewImpl extends ReviewComponent {
	public ReviewImpl(UUID reviewId, String reviewContent, Date createdAt, Customer customer,
			BookingItem bookingitem) {
		this.reviewId = reviewId;
		this.reviewContent = reviewContent;
		this.createdAt = createdAt;
		this.customer = customer;
		this.bookingitem = bookingitem;
	}

	public ReviewImpl() {
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> reviewMap = new HashMap<String, Object>();
		reviewMap.put("reviewId", getReviewId());
		reviewMap.put("reviewContent", getReviewContent());
		reviewMap.put("createdAt", getCreatedAt());
		reviewMap.put("customer", getCustomer());
		reviewMap.put("bookingitem", getBookingitem());

		return reviewMap;
	}

}
