package OnlineTicketing.customer.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.customer.CustomerFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CustomerServiceImpl extends CustomerServiceComponent{

    public List<HashMap<String,Object>> saveCustomer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Customer customer = createCustomer(vmjExchange);
		customerRepository.saveObject(customer);
		return getAllCustomer(vmjExchange);
	}

    public Customer createCustomer(Map<String, Object> requestBody){
		String email = (String) requestBody.get("email");
		String name = (String) requestBody.get("name");
		
		//to do: fix association attributes
		Customer Customer = CustomerFactory.createCustomer(
			"OnlineTicketing.customer.core.CustomerImpl",
		customerId
		, email
		, name
		);
		Repository.saveObject(customer);
		return customer;
	}

    public Customer createCustomer(Map<String, Object> requestBody, int id){
		String email = (String) vmjExchange.getRequestBodyForm("email");
		String name = (String) vmjExchange.getRequestBodyForm("name");
		
		//to do: fix association attributes
		
		Customer customer = CustomerFactory.createCustomer("OnlineTicketing.customer.core.CustomerImpl", customerId, email, name);
		return customer;
	}

    public HashMap<String, Object> updateCustomer(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("customerId");
		int id = Integer.parseInt(idStr);
		Customer customer = Repository.getObject(id);
		
		customer.setEmail((String) requestBody.get("email"));
		customer.setName((String) requestBody.get("name"));
		
		Repository.updateObject(customer);
		
		//to do: fix association attributes
		
		return customer.toHashMap();
		
	}

    public HashMap<String, Object> getCustomer(Map<String, Object> requestBody){
		List<HashMap<String, Object>> customerList = getAllCustomer("customer_impl");
		for (HashMap<String, Object> customer : customerList){
			int record_id = ((Double) customer.get("record_id")).intValue();
			if (record_id == id){
				return customer;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCustomerById(int id){
		String idStr = vmjExchange.getGETParam("customerId"); 
		int id = Integer.parseInt(idStr);
		Customer customer = customerRepository.getObject(id);
		return customer.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCustomer(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Customer> List = Repository.getAllObject(table);
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
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCustomer(requestBody);
	}

}
