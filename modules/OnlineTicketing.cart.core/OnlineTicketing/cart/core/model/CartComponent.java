package OnlineTicketing.cart.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="cart_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CartComponent implements Cart{
	@Id
	public UUID id; 
	public int total;
	@ManyToOne(targetEntity=OnlineTicketing.customer.core.CustomerComponent.class)
	public Customer customerimpl;
	protected String objectName = CartComponent.class.getName();

	public CartComponent() {

	} 

	public CartComponent(
        UUID id, int total, CustomerImpl customerimpl
    ) {
        this.id = id;
        this.total = total;
        this.customerimpl = customerimpl;
    }

	public abstract UUID getId();
	public abstract void setId(UUID id);
	
	public abstract int getTotal();
	public abstract void setTotal(int total);
	
	public abstract CustomerImpl getCustomerimpl();
	public abstract void setCustomerimpl(CustomerImpl customerimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " total='" + getTotal() + "'" +
            " customerimpl='" + getCustomerimpl() + "'" +
            "}";
    }
	
}
