package OnlineTicketing.order.core;

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


@Entity(name="order_impl")
@Table(name="order_impl")
public class OrderImpl extends OrderComponent {

	public OrderImpl(UUID orderId, DateTime createdAt, int amount, int quantity, Date startDate, Date endDate, Customer customer, BookingOption bookingOption) {
		this.orderId = orderId;
		this.createdAt = createdAt;
		this.amount = amount;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.bookingOption = bookingOption;
	}

	public OrderImpl(DateTime createdAt, int amount, int quantity, Date startDate, Date endDate, Customer customer, BookingOption bookingOption) {
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
