package OnlineTicketing.review.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import OnlineTicketing.customer.core.*;
import OnlineTicketing.bookingitem.core.*;

@Entity
@Table(name = "review_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReviewComponent implements Review {
	@Id
	public UUID reviewId;
	public String reviewContent;
	public Date createdAt;
	@ManyToOne(targetEntity = OnlineTicketing.customer.core.CustomerComponent.class)
	public Customer customer;
	@ManyToOne(targetEntity = OnlineTicketing.bookingitem.core.BookingItemComponent.class)
	public BookingItem bookingitem;
	protected String objectName = ReviewComponent.class.getName();

	public ReviewComponent() {

	}

	public ReviewComponent(
			UUID reviewId, String reviewContent, Date createdAt,
			Customer customer,
			BookingItem bookingitem) {
		this.reviewId = reviewId;
		this.reviewContent = reviewContent;
		this.createdAt = createdAt;
		this.customer = customer;
		this.bookingitem = bookingitem;
	}

	public UUID getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(UUID reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewContent() {
		return this.reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Customer getCustomer() {
		return (Customer) this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BookingItem getBookingitem() {
		return (BookingItem) this.bookingitem;
	}

	public void setBookingitem(BookingItem bookingitem) {
		this.bookingitem = bookingitem;
	}

	@Override
	public String toString() {
		return "{" +
				" reviewId='" + getReviewId() + "'" +
				" reviewContent='" + getReviewContent() + "'" +
				" createdAt='" + getCreatedAt() + "'" +
				" customer='" + getCustomer() + "'" +
				" bookingitem='" + getBookingitem() + "'" +
				"}";
	}

}
