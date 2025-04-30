package OnlineTicketing.bookingitem.flight;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AirlineDecorator extends AirlineComponent{
	protected AirlineComponent record;
	
	public AirlineDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}

	public AirlineDecorator (AirlineComponent record) {
		this.record = record;
	}

	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
	}
	public String getName() {
		return record.getName();
	}
	public void setName(String name) {
		record.setName(name);
	}


}
