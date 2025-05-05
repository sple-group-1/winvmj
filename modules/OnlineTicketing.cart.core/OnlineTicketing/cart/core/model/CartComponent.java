package OnlineTicketing.cart.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import OnlineTicketing.customer.core.*;
import javax.persistence.ManyToOne;

@Entity
@Table(name="cart_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CartComponent implements Cart{
	@Id
	public UUID id; 
	public int total;
	@ManyToOne(targetEntity=OnlineTicketing.customer.core.CustomerComponent.class)
	public Customer customer;
	protected String objectName = CartComponent.class.getName();

	public CartComponent() {

	} 

	public CartComponent(
        UUID id, int total, Customer customer
    ) {
        this.id = id;
        this.total = total;
        this.customer = customer;
    }

	public UUID getId(){
		return this.id;
	};

	public void setId(UUID id){
		this.id = id;
	};
	
	public int getTotal(){
		return this.total;
	};

	public void setTotal(int total){
		this.total = total;
	};
	
	public Customer getCustomer(){
		return this.customer;
	}
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " total='" + getTotal() + "'" +
            " customer='" + getCustomer() + "'" +
            "}";
    }
	
}
