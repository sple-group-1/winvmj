package OnlineTicketing.bookingavailability.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="bookingavailability_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BookingAvailbilityComponent implements BookingAvailability{
	@Id
	protected UUID id; 
	protected int quota;
	protected int available;
	protected String objectName = BookingAvailbilityComponent.class.getName();

	public BookingAvailbilityComponent() {

	} 

	public BookingAvailbilityComponent(
        UUID id, int quota, int available
    ) {
        this.id = id;
        this.quota = quota;
        this.available = available;
    }

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public int getQuota() {
		return this.quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}
	public int getAvailable() {
		return this.available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " quota='" + getQuota() + "'" +
            " available='" + getAvailable() + "'" +
            "}";
    }
	
}
