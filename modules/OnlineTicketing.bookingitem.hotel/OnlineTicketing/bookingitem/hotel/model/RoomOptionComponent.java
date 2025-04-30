package OnlineTicketing.bookingitem.hotel;;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RoomOptionComponent implements {
	
	@Id
	protected UUID id; 
	protected String name;
	protected ELong price;
	public BookingAvailabilityImpl bookingavailabilityimpl;

	public RoomOptionComponent() {

	} 
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public ELong getPrice() {
		return this.price;
	}

	public void setPrice(ELong price) {
		this.price = price;
	}
 
}
