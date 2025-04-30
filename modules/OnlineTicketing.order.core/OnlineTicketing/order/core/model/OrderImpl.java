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

	public OrderImpl(UUID orderId, DateTime createdAt, int amount, CustomerImpl customerimpl, BookingItemImpl bookingitemimpl, int quantity, Date startDate, Date endDate) {
		this.orderId = orderId;
		this.createdAt = createdAt;
		this.amount = amount;
		this.customerimpl = customerimpl;
		this.bookingitemimpl = bookingitemimpl;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public OrderImpl(UUID orderId, DateTime createdAt, int amount, CustomerImpl customerimpl, BookingItemImpl bookingitemimpl, int quantity, Date startDate, Date endDate) {
		this.orderId =  orderId.randomUUID();;
		this.orderId = orderId;
		this.createdAt = createdAt;
		this.amount = amount;
		this.customerimpl = customerimpl;
		this.bookingitemimpl = bookingitemimpl;
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public OrderImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> orderMap = new HashMap<String,Object>();
		orderMap.put("orderId",getOrderId());
		orderMap.put("createdAt",getCreatedAt());
		orderMap.put("amount",getAmount());
		orderMap.put("customerimpl",getCustomerimpl());
		orderMap.put("bookingitemimpl",getBookingitemimpl());
		orderMap.put("quantity",getQuantity());
		orderMap.put("startDate",getStartDate());
		orderMap.put("endDate",getEndDate());

        return orderMap;
    }

}
