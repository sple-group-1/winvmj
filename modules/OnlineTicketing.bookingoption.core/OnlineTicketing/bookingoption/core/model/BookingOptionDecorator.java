package OnlineTicketing.bookingoption.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BookingOptionDecorator extends BookingOptionComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BookingOptionComponent record;

	public BookingOptionDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}
		
	public BookingOptionDecorator (BookingOptionComponent record) {
		this.id =  UUID.randomUUID();
		this.record = record;
	}

	public BookingOptionDecorator (UUID id, BookingOptionComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public BookingOptionDecorator (BookingOptionComponent record, String objectName) {
		this.id =  UUID.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
