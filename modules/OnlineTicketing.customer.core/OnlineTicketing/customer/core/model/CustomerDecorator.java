package OnlineTicketing.customer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class CustomerDecorator extends CustomerComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected CustomerComponent record;

	public CustomerDecorator () {
		super();
		this.record = record;
		this.customerId =  customerId.randomUUID();
	}
		
	public CustomerDecorator (CustomerComponent record) {
		this.customerId =  customerId.randomUUID();
		this.record = record;
	}

	public CustomerDecorator (UUID customerId, CustomerComponent record) {
		this.customerId =  customerId;
		this.record = record;
	}
	
	public CustomerDecorator (CustomerComponent record, String objectName) {
		this.customerId =  customerId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
