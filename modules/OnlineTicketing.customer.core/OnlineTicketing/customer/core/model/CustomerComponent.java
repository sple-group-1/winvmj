package OnlineTicketing.customer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="customer_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CustomerComponent implements Customer{
	@Id
	public UUID customerId; 
	public UUID customerId;
	public String email;
	public String name;
	protected String objectName = CustomerComponent.class.getName();

	public CustomerComponent() {

	} 

	public CustomerComponent(
        UUID customerId, String email, String name
    ) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
    }

	public abstract UUID getCustomerId();
	public abstract void setCustomerId(UUID customerId);
	
	public abstract String getEmail();
	public abstract void setEmail(String email);
	
	public abstract String getName();
	public abstract void setName(String name);
	
 

	@Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            " email='" + getEmail() + "'" +
            " name='" + getName() + "'" +
            "}";
    }
	
}
