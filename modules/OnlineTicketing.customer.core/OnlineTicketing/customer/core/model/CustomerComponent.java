package OnlineTicketing.customer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name="customer_comp")
@Table(name="customer_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CustomerComponent implements Customer{
	@Id
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
	
	public UUID getCustomerId(){ return this.customerId; }
	public void setCustomerId(UUID customerId) {this.customerId=customerId; }
	
	public String getEmail(){ return this.email; }
	public void setEmail(String email) {this.email=email; }
	
	public String getName(){ return this.name; }
	public void setName(String name) {this.name=name; }


	@Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            " email='" + getEmail() + "'" +
            " name='" + getName() + "'" +
            "}";
    }
	
}
