package OnlineTicketing.bookingitem.event;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PackageOptionDecorator extends PackageOptionComponent{
	protected PackageOptionComponent record;
	
	public PackageOptionDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
	}

	public PackageOptionDecorator (PackageOptionComponent record) {
		this.record = record;
	}

	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
	}
	public ELong getPrice() {
		return record.getPrice();
	}
	public void setPrice(ELong price) {
		record.setPrice(price);
	}
	public String getName() {
		return record.getName();
	}
	public void setName(String name) {
		record.setName(name);
	}


}
