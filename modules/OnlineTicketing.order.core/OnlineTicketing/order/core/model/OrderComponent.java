package OnlineTicketing.order.core;

import java.util.*;
import java.time.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import OnlineTicketing.customer.core.*;
import OnlineTicketing.bookingoption.core.*;

@Entity(name="order_comp")
@Table(name="order_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrderComponent implements Order{
	@Id
	public UUID orderId; 
	public LocalDateTime createdAt;
	public int amount;
	public int quantity;
	public LocalDate startDate;
	public LocalDate endDate;
	@ManyToOne(targetEntity=OnlineTicketing.customer.core.CustomerComponent.class)
	public Customer customer;
	@ManyToOne(targetEntity=OnlineTicketing.bookingoption.core.BookingOptionComponent.class)
	public BookingOption bookingOption;
	protected String objectName = OrderComponent.class.getName();

	public OrderComponent() {

	} 

	public OrderComponent(
        UUID orderId, LocalDateTime createdAt, int amount, int quantity, LocalDate startDate, LocalDate endDate, Customer customer, BookingOption bookingOption
    ) {
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.amount = amount;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.bookingOption = bookingOption;
    }

	public UUID getOrderId() {
        return this.orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BookingOption getBookingOption() {
        return this.bookingOption;
    }

    public void setBookingOption(BookingOption bookingOption) {
        this.bookingOption = bookingOption;
    }
	
	@Override
    public String toString() {
        return "{" +
            " orderId='" + getOrderId() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            " amount='" + getAmount() + "'" +
            " quantity='" + getQuantity() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " customer='" + getCustomer() + "'" +
            " bookingOption='" + getBookingOption() + "'" +
            "}";
    }
	
}
