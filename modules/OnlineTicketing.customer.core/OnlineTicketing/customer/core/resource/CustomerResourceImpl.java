package OnlineTicketing.customer.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.customer.CustomerFactory;
import vmj.auth.annotations.Restricted;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CustomerResourceImpl extends CustomerResourceComponent{
	private CustomerService customerService = new CustomerServiceImpl();

	@Restricted(permissionName = "CreateCustomer")
    @Route(url="call/customer/create")
    public HashMap<String,Object> createcustomer(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Customer result = customerService.createCustomer(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	@Restricted(permissionName = "UpdateCustomer")
    @Route(url="call/customer/update")
    public HashMap<String, Object> updateCustomer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return customerService.updateCustomer(requestBody);
		
	}

	@Restricted(permissionName = "ReadCustomer")
    @Route(url="call/customer/detail")
    public HashMap<String, Object> getCustomer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return customerService.getCustomer(requestBody);
	}

	@Restricted(permissionName = "ReadCustomer")
    @Route(url="call/customer/list")
    public List<HashMap<String,Object>> getAllCustomer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return customerService.getAllCustomer(requestBody);
	}

	@Restricted(permissionName = "DeleteCustomer")
    @Route(url="call/customer/delete")
    public List<HashMap<String,Object>> deleteCustomer(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return customerService.deleteCustomer(requestBody);
	}

}
