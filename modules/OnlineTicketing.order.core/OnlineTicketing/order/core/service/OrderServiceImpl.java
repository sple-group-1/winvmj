package OnlineTicketing.order.core;

import java.util.*;
import java.util.logging.Logger;
import java.time.*;

import OnlineTicketing.order.OrderFactory;
import OnlineTicketing.customer.core.*;
import OnlineTicketing.bookingoption.core.*;
//add other required packages

public class OrderServiceImpl extends OrderServiceComponent{

    // public List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	Order order = createOrder(vmjExchange);
	// 	orderRepository.saveObject(order);
	// 	return getAllOrder(vmjExchange);
	// }

    public Order createOrder(Map<String, Object> requestBody){
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String startStr = (String) requestBody.get("start_date");
		Date startDate = Date.from(Instant.parse(startStr));
		String endStr = (String) requestBody.get("end_date");
		Date endDate = Date.from(Instant.parse(endStr));
		String customerIdStr = (String) requestBody.get("customerId");
		String bookingOptionIdStr = (String) requestBody.get("bookingOptionId");

		LocalDateTime createdAt = LocalDateTime.now();

		Customer customer = null;
		if (customerIdStr != null) {
			UUID customerId = UUID.fromString(customerIdStr);
			customer = orderRepository.getProxyObject(OnlineTicketing.customer.core.CustomerComponent.class, customerId);
		}

		BookingOption bookingOption = null;
		if (bookingOptionIdStr != null) {
			UUID bookingOptionId = UUID.fromString(bookingOptionIdStr);
			bookingOption = orderRepository.getProxyObject(OnlineTicketing.bookingoption.core.BookingOptionComponent.class, bookingOptionId);
		}
		
		//to do: fix association attributes
		Order order = OrderFactory.createOrder("OnlineTicketing.order.core.OrderImpl"
		, createdAt
		, amount
		, quantity
		, startDate
		, endDate
		, customer
		, bookingOption
		);
		orderRepository.saveObject(order);
		return order;
	}

    // public Order createOrder(Map<String, Object> requestBody, int id){
	// 	String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
	// 	int amount = Integer.parseInt(amountStr);
	// 	String quantityStr = (String) vmjExchange.getRequestBodyForm("quantity");
	// 	int quantity = Integer.parseInt(quantityStr);
		
	// 	//to do: fix association attributes
		
	// 	Order order = OrderFactory.createOrder("OnlineTicketing.order.core.OrderImpl", orderId, createdAt, amount, quantity, startDate, endDate, customerimpl, bookingoptionimpl);
	// 	return order;
	// }

    // public HashMap<String, Object> updateOrder(Map<String, Object> requestBody){
	// 	String idStr = (String) requestBody.get("orderId");
	// 	int id = Integer.parseInt(idStr);
	// 	Order order = Repository.getObject(id);
		
	// 	String amountStr = (String) requestBody.get("amount");
	// 	order.setAmount(Integer.parseInt(amountStr));
	// 	String quantityStr = (String) requestBody.get("quantity");
	// 	order.setQuantity(Integer.parseInt(quantityStr));
		
	// 	Repository.updateObject(order);
		
	// 	//to do: fix association attributes
		
	// 	return order.toHashMap();
		
	// }

    public HashMap<String, Object> getOrder(Map<String, Object> requestBody){
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "order_impl");
		List<HashMap<String, Object>> orderList = getAllOrder(map);
		String idStr = (String) requestBody.get("orderId");
		UUID id = UUID.fromString(idStr);
		for (HashMap<String, Object> order : orderList){
			// int record_id = ((Double) order.get("record_id")).intValue();
			// if (record_id == id){
			// 	return order;
			// }
			UUID record_id = UUID.fromString(order.get("record_id").toString());
			if (record_id.equals(id)){
				return order;
			}
		}
		return null;
	}

	public HashMap<String, Object> getOrderById(UUID id){
		// String idStr = vmjExchange.getGETParam("orderId"); 
		// int id = Integer.parseInt(idStr);
		Order order = orderRepository.getObject(id);
		return order.toHashMap();
	}

    public List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Order> List = orderRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Order> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    // public List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody){
	// 	String idStr = ((String) requestBody.get("id"));
	// 	int id = Integer.parseInt(idStr);
	// 	Repository.deleteObject(id);
	// 	return getAllOrder(requestBody);
	// }

}
