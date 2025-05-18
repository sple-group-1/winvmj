package OnlineTicketing.order.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.order.OrderFactory;
import vmj.auth.annotations.Restricted;

import OnlineTicketing.customer.core.*;
//add other required packages

public class OrderResourceImpl extends OrderResourceComponent{
	private OrderService orderService = new OrderServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();

	@Restricted(permissionName = "CreateOrder")
    @Route(url="call/order/save")
    public HashMap<String,Object> createOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
			String email = vmjExchange.getAuthPayload().getEmail();
			Customer customer = customerService.getCustomerByEmail(email);
			UUID customerId = customer.getCustomerId();
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Order result = orderService.createOrder(requestBody, customer);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	@Restricted(permissionName = "ReadOrder")
    @Route(url="call/order/detail")
    public HashMap<String, Object> getOrder(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("orderId");
		if(idStr == null) {
		throw new IllegalArgumentException("Invalid UUID");
		}
		UUID id = UUID.fromString(idStr);
		return orderService.getOrder(id);
	}

	@Restricted(permissionName = "ReadOrder")
    @Route(url="call/order/list")
    public List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return orderService.getAllOrder(requestBody);
	}

	@Restricted(permissionName = "ReadOrder")
    @Route(url="call/order/completed")
    public List<HashMap<String,Object>> getCompletedOrder(VMJExchange vmjExchange){
		String type = (String) vmjExchange.getGETParam("type");

		String email = vmjExchange.getAuthPayload().getEmail();
		Customer customer = customerService.getCustomerByEmail(email);
		UUID customerId = customer.getCustomerId();

		return orderService.getCompletedOrder(customerId, type);
	}

	@Restricted(permissionName = "ReadOrder")
    @Route(url="call/order/upcoming")
    public List<HashMap<String,Object>> getUpcomingOrder(VMJExchange vmjExchange){
		String type = (String) vmjExchange.getGETParam("type");

		String email = vmjExchange.getAuthPayload().getEmail();
		Customer customer = customerService.getCustomerByEmail(email);
		UUID customerId = customer.getCustomerId();

		return orderService.getUpcomingOrder(customerId, type);
	}

    @Route(url="call/order/count")
    public HashMap<String, Object> countPayment(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return orderService.countPayment(requestBody);
	}
}
