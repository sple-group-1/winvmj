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

	public OrderImpl(UUID orderId, LocalDateTime createdAt, int amount, int quantity, LocalDate startDate, LocalDate endDate, Customer customer, BookingOption bookingOption) {
		this.orderId = orderId;
		this.createdAt = createdAt;
		this.amount = amount;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.bookingOption = bookingOption;
	}

	public OrderImpl(LocalDateTime createdAt, int amount, int quantity, LocalDate startDate, LocalDate endDate, Customer customer, BookingOption bookingOption) {
		this.orderId =  UUID.randomUUID();
		this.createdAt = createdAt;
		this.amount = amount;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.bookingOption = bookingOption;
	}

	public OrderImpl() {
		this.orderId = UUID.randomUUID();
		this.createdAt = createdAt;
		this.amount = amount;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> orderMap = new HashMap<String,Object>();
		orderMap.put("orderId",getOrderId());
		orderMap.put("createdAt",getCreatedAt());
		orderMap.put("amount",getAmount());
		orderMap.put("quantity",getQuantity());
		orderMap.put("startDate",getStartDate());
		orderMap.put("endDate",getEndDate());
		orderMap.put("customer",getCustomer());
		orderMap.put("bookingOption",getBookingOption());

        return orderMap;
    }

}
