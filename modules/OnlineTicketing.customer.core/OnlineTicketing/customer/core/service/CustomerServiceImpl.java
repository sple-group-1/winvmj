package OnlineTicketing.customer.core;

import java.util.*;
import java.util.logging.Logger;

import OnlineTicketing.customer.CustomerFactory;
//add other required packages

public class CustomerServiceImpl extends CustomerServiceComponent{
	private CustomerFactory customerFactory = new CustomerFactory();

    // public List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	Customer customer = createCustomer(vmjExchange);
	// 	customerRepository.saveObject(customer);
	// 	return getAllCustomer(vmjExchange);
	// }

	public List<HashMap<String,Object>> saveCustomer(Map<String, Object> requestBody) {
		String email = (String) requestBody.get("email");
		String name = (String) requestBody.get("name");
		
		Customer customer = customerFactory.createCustomer("OnlineTicketing.customer.core.CustomerImpl", email, name);
		customerRepository.saveObject(customer);
		return getAllCustomer(requestBody);
	}

    public Customer createCustomer(Map<String, Object> requestBody){
		String email = (String) requestBody.get("email");
		String name = (String) requestBody.get("name");
		
		Customer customer = customerFactory.createCustomer("OnlineTicketing.customer.core.CustomerImpl", email, name);
		customerRepository.saveObject(customer);
		return customer;
	}

    // public Customer createCustomer(Map<String, Object> requestBody, int id){
	// 	String email = (String) vmjExchange.getRequestBodyForm("email");
	// 	String name = (String) vmjExchange.getRequestBodyForm("name");
		
	// 	//to do: fix association attributes
		
	// 	Customer customer = CustomerFactory.createCustomer("OnlineTicketing.customer.core.CustomerImpl", customerId, email, name);
	// 	return customer;
	// }

    public HashMap<String, Object> updateCustomer(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("customerId");
		// int id = Integer.parseInt(idStr);
		UUID id = UUID.fromString(idStr);

		Customer customer = customerRepository.getObject(id);
		
		customer.setEmail((String) requestBody.get("email"));
		customer.setName((String) requestBody.get("name"));
		
		customerRepository.updateObject(customer);
		
		//to do: fix association attributes
		
		return customer.toHashMap();
		
	}

    public HashMap<String, Object> getCustomer(Map<String, Object> requestBody){
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "customer_impl");
		List<HashMap<String, Object>> customerList = getAllCustomer(map);
		String idStr = (String) requestBody.get("customerId");
		UUID id = UUID.fromString(idStr);
		for (HashMap<String, Object> customer : customerList){
			// int record_id = ((Double) customer.get("record_id")).intValue();
			// if (record_id == id){
			// 	return customer;
			// }
			UUID record_id = UUID.fromString(customer.get("record_id").toString());
			if (record_id.equals(id)){
				return customer;
			}
		}
		return null;
	}

	// public HashMap<String, Object> getCustomerById(int id){
	public HashMap<String, Object> getCustomerById(UUID id){
		Customer customer = customerRepository.getObject(id);
		return customer.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCustomer(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Customer> List = customerRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Customer> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCustomer(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("customerId");
		// int id = Integer.parseInt(idStr);
		UUID id = UUID.fromString(idStr);
		customerRepository.deleteObject(id);
		return getAllCustomer(requestBody);
	}

}
