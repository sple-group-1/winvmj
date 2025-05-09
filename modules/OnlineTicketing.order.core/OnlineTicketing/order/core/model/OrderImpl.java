package OnlineTicketing.order.core;

import java.lang.Math;
import java.util.*;
import java.time.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import OnlineTicketing.customer.core.*;
import OnlineTicketing.bookingoption.core.*;

@Entity(name="order_impl")
@Table(name="order_impl")
public class OrderImpl extends OrderComponent {

	public OrderImpl(UUID orderId, LocalDateTime createdAt, Long totalPrice, int quantity, LocalDate startDate, LocalDate endDate, Customer customer, BookingOption bookingOption) {
		this.orderId = orderId;
		this.createdAt = createdAt;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.bookingOption = bookingOption;
	}

	public OrderImpl(LocalDateTime createdAt, Long totalPrice, int quantity, LocalDate startDate, LocalDate endDate, Customer customer, BookingOption bookingOption) {
		this.orderId =  UUID.randomUUID();
		this.createdAt = createdAt;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.bookingOption = bookingOption;
	}

	public OrderImpl() {
		this.orderId = UUID.randomUUID();
		this.createdAt = null;
		this.totalPrice = 0L;
		this.quantity = 0;
		this.startDate = null;
		this.endDate = null;
	}

}
