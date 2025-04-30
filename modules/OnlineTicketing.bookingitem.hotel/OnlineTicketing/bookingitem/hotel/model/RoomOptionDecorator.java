package OnlineTicketing.bookingitem.hotel;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class RoomOptionDecorator extends RoomOptionComponent{
	protected RoomOptionComponent record;
	
	public RoomOptionDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}

	public RoomOptionDecorator (RoomOptionComponent record) {
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
	public ELong getPrice() {
		return record.getPrice();
	}
	public void setPrice(ELong price) {
		record.setPrice(price);
	}


}
