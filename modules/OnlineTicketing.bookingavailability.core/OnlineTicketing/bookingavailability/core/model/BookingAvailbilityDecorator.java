package OnlineTicketing.bookingavailability.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BookingAvailbilityDecorator extends BookingAvailbilityComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BookingAvailbilityComponent record;

	public BookingAvailbilityDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}
		
	public BookingAvailbilityDecorator (BookingAvailbilityComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public BookingAvailbilityDecorator (UUID id, BookingAvailbilityComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public BookingAvailbilityDecorator (BookingAvailbilityComponent record, String objectName) {
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
