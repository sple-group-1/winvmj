package OnlineTicketing.order.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.order.OrderFactory;
import vmj.auth.annotations.Restricted;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class OrderResourceImpl extends OrderResourceComponent{
	private OrderService orderService = new OrderServiceImpl();

	@Restricted(permissionName = "CreateOrder")
    @Route(url="call/order/create")
    public HashMap<String,Object> createOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Order result = orderService.createOrder(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    // @Route(url="call/order/update")
    // public HashMap<String, Object> updateOrder(VMJExchange vmjExchange){
	// 	Map<String, Object> requestBody = vmjExchange.getPayload(); 
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")){
	// 		return null;
	// 	}
	// 	return OrderService.updateOrder(requestBody);
		
	// }

	@Restricted(permissionName = "ReadOrder")
    @Route(url="call/order/detail")
    public HashMap<String, Object> getOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return orderService.getOrder(requestBody);
	}

	@Restricted(permissionName = "ReadOrder")
    @Route(url="call/order/list")
    public List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return orderService.getAllOrder(requestBody);
	}

    
	// @Restriced(permission = "")
    // @Route(url="call/order/delete")
    // public List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange){
	// 	Map<String, Object> requestBody = vmjExchange.getPayload(); 
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
		
	// 	return OrderService.deleteOrder(requestBody);
	// }

}
