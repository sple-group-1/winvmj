package OnlineTicketing.customer.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CustomerResourceComponent implements CustomerResource {
	protected RepositoryUtil<Customer> customerRepository;
	
	public CustomerResourceComponent() {
        this.customerRepository = new RepositoryUtil<Customer>(OnlineTicketing.customer.core.CustomerComponent.class);
    }
 
    // public abstract Customer createCustomer(VMJExchange vmjExchange);    
    public abstract HashMap<String, Object> createCustomer(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateCustomer(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getCustomer(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllCustomer(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteCustomer(VMJExchange vmjExchange);

}
