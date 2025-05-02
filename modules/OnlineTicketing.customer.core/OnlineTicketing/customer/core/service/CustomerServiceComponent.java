package OnlineTicketing.customer.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
//add other required packages

public abstract class CustomerServiceComponent implements CustomerService{
	protected RepositoryUtil<Customer> customerRepository;

    public CustomerServiceComponent(){
        this.customerRepository = new RepositoryUtil<Customer>(OnlineTicketing.customer.core.CustomerComponent.class);
    }	

    // public abstract List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> saveCustomer(Map<String, Object> requestBody);

    // public abstract Customer createCustomer(Map<String, Object> requestBodye);
    public abstract Customer createCustomer(Map<String, Object> requestBody);

	// public abstract Customer createCustomer(Map<String, Object> requestBody, Map<String, Object> response);  
	public abstract HashMap<String, Object> updateCustomer(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getCustomer(Map<String, Object> requestBody);

    public abstract List<HashMap<String,Object>> getAllCustomer(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Customer> List);
    public abstract List<HashMap<String,Object>> deleteCustomer(Map<String, Object> requestBody);

	// public abstract HashMap<String, Object> getCustomerById(int id);
	public abstract HashMap<String, Object> getCustomerById(UUID id);

}
