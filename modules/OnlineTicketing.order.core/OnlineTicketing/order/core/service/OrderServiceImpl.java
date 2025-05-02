package OnlineTicketing.order.core;
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
import OnlineTicketing.order.OrderFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class OrderServiceImpl extends OrderServiceComponent{

    public List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Order order = createOrder(vmjExchange);
		orderRepository.saveObject(order);
		return getAllOrder(vmjExchange);
	}

    public Order createOrder(Map<String, Object> requestBody){
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		
		//to do: fix association attributes
		Order Order = OrderFactory.createOrder(
			"OnlineTicketing.order.core.OrderImpl",
		orderId
		, createdAt
		, amount
		, quantity
		, startDate
		, endDate
		, customerimpl
		, bookingoptionimpl
		);
		Repository.saveObject(order);
		return order;
	}

    public Order createOrder(Map<String, Object> requestBody, int id){
		String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
		int amount = Integer.parseInt(amountStr);
		String quantityStr = (String) vmjExchange.getRequestBodyForm("quantity");
		int quantity = Integer.parseInt(quantityStr);
		
		//to do: fix association attributes
		
		Order order = OrderFactory.createOrder("OnlineTicketing.order.core.OrderImpl", orderId, createdAt, amount, quantity, startDate, endDate, customerimpl, bookingoptionimpl);
		return order;
	}

    public HashMap<String, Object> updateOrder(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("orderId");
		int id = Integer.parseInt(idStr);
		Order order = Repository.getObject(id);
		
		String amountStr = (String) requestBody.get("amount");
		order.setAmount(Integer.parseInt(amountStr));
		String quantityStr = (String) requestBody.get("quantity");
		order.setQuantity(Integer.parseInt(quantityStr));
		
		Repository.updateObject(order);
		
		//to do: fix association attributes
		
		return order.toHashMap();
		
	}

    public HashMap<String, Object> getOrder(Map<String, Object> requestBody){
		List<HashMap<String, Object>> orderList = getAllOrder("order_impl");
		for (HashMap<String, Object> order : orderList){
			int record_id = ((Double) order.get("record_id")).intValue();
			if (record_id == id){
				return order;
			}
		}
		return null;
	}

	public HashMap<String, Object> getOrderById(int id){
		String idStr = vmjExchange.getGETParam("orderId"); 
		int id = Integer.parseInt(idStr);
		Order order = orderRepository.getObject(id);
		return order.toHashMap();
	}

    public List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Order> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Order> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllOrder(requestBody);
	}

}
