package OnlineTicketing.customer.core;
import java.util.*;

public abstract class CustomerServiceDecorator extends CustomerServiceComponent{
	protected CustomerServiceComponent record;

    public CustomerServiceDecorator(CustomerServiceComponent record) {
        this.record = record;
    }

	public Customer createCustomer(Map<String, Object> requestBody){
		return record.createCustomer(requestBody);
	}

    // public Customer createCustomer(Map<String, Object> requestBody, Map<String, Object> response){
	// 	return record.createCustomer(requestBody, response);
	// }

	public HashMap<String, Object> getCustomer(Map<String, Object> requestBody){
		return record.getCustomer(requestBody);
	}

	public List<HashMap<String,Object>> getAllCustomer(Map<String, Object> requestBody){
		return record.getAllCustomer(requestBody);
	}

    // public List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange){
	// 	return record.saveCustomer(vmjExchange);
	// }

	public List<HashMap<String,Object>> saveCustomer(Map<String, Object> requestBody) {
		return record.saveCustomer(requestBody);
	}

    public HashMap<String, Object> updateCustomer(Map<String, Object> requestBody){
		return record.updateCustomer(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Customer> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteCustomer(Map<String, Object> requestBody){
		return record.deleteCustomer(requestBody);
	}

	// public HashMap<String, Object> getCustomerById(int id){
	public HashMap<String, Object> getCustomerById(UUID id){
        return record.getCustomerById(id);
    }

	public Customer getCustomerByEmail(String email) {
		return record.getCustomerByEmail(email);
	}

}
