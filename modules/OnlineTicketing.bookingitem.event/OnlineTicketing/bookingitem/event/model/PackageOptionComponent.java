package OnlineTicketing.bookingitem.event;;

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
public abstract class PackageOptionComponent implements {
	
	@Id
	protected UUID id; 
	protected ELong price;
	protected String name;

	public PackageOptionComponent() {

	} 
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public ELong getPrice() {
		return this.price;
	}

	public void setPrice(ELong price) {
		this.price = price;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
}
