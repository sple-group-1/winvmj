package OnlineTicketing.bookingitem.event;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="_impl")
@Table(name="_impl")
public class PackageOptionImpl extends PackageOptionComponent {

	public PackageOptionImpl(UUID id, ELong price, String name) {
		this.id = id;
		this.price = price;
		this.name = name;
	}


}
