package OnlineTicketing.bookingavailability.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BookingAvailabilityDecorator extends BookingAvailabilityComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BookingAvailabilityComponent record;

	public BookingAvailabilityDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}
		
	public BookingAvailabilityDecorator (BookingAvailabilityComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public BookingAvailabilityDecorator (UUID id, BookingAvailabilityComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public BookingAvailabilityDecorator (BookingAvailabilityComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	

	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
	}
	public int getQuota() {
		return record.getQuota();
	}
	public void setQuota(int quota) {
		record.setQuota(quota);
	}
	public int getAvailable() {
		return record.getAvailable();
	}
	public void setAvailable(int available) {
		record.setAvailable(available);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
