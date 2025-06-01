package OnlineTicketing.order.core;

import java.util.*;
import java.util.logging.Logger;
import java.time.*;

import OnlineTicketing.order.OrderFactory;
import OnlineTicketing.customer.core.*;
import OnlineTicketing.bookingoption.core.*;
//add other required packages

public class OrderServiceImpl extends OrderServiceComponent{
	private OrderFactory orderFactory = new OrderFactory();
	private BookingOptionService bookingOptionService = new BookingOptionServiceImpl();

    public Order createOrder(Map<String, Object> requestBody, Customer customer){
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String startStr = (String) requestBody.get("startDate");
		LocalDate startDate = LocalDate.parse(startStr);
		LocalDate endDate;
		if (requestBody.get("endDate") != null) {
			String endStr = (String) requestBody.get("endDate");
			endDate = LocalDate.parse(endStr);
		}
		else {
			endDate = startDate;
		}

		String bookingOptionIdStr = (String) requestBody.get("bookingOptionId");

		BookingOption bookingOption = null;
		if (bookingOptionIdStr != null) {
			UUID bookingOptionId = UUID.fromString(bookingOptionIdStr);
			bookingOption = bookingOptionService.getBookingOption(bookingOptionId);
		}

		LocalDateTime createdAt = LocalDateTime.now();

		Long totalPrice = countTotal(startDate, endDate, quantity, bookingOption);
		
		Order order = OrderFactory.createOrder("OnlineTicketing.order.core.OrderImpl"
		, createdAt
		, totalPrice
		, quantity
		, startDate
		, endDate
		, customer
		, bookingOption
		);
		orderRepository.saveObject(order);
		return order;
	}

	public HashMap<String, Object> getOrder(UUID id){
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

	public List<HashMap<String, Object>> getCompletedOrder(UUID customerId, String bookingType) {
		List<Order> orderList = orderRepository.getListObject("order_comp", "customer_customerid", customerId);
		List<Order> completedOrders = new ArrayList<>();

		LocalDate today = LocalDate.now();

		for (Order order : orderList) {
			if (order.getEndDate().isBefore(today)) {
				completedOrders.add(order);
			}
		}

		List<Order> result = filterOrdersByType(completedOrders, bookingType);
		return transformListToHashMap(result);
	}
	
	public List<HashMap<String, Object>> getUpcomingOrder(UUID customerId, String bookingType) {
		List<Order> orderList = orderRepository.getListObject("order_comp", "customer_customerid", customerId);
		List<Order> upcomingOrders = new ArrayList<>();

		LocalDate today = LocalDate.now();

		for (Order order : orderList) {
			if (order.getEndDate().isAfter(today)) {
				upcomingOrders.add(order);
			}
		}

		List<Order> result = filterOrdersByType(upcomingOrders, bookingType);
		return transformListToHashMap(result);
	}

	public List<Order> filterOrdersByType(List<Order> orderList, String bookingType) {
		List<Order> filteredOrders = new ArrayList<>();
		for (Order order : orderList) {
			if (order.getBookingOption().getBookingType().equalsIgnoreCase(bookingType)) {
				filteredOrders.add(order);
			}
		}
		return filteredOrders;
	}

	public Long countTotal(LocalDate startDate, LocalDate endDate, int quantity, BookingOption bookingOption) {
		HashMap<String, Object> optionMap = bookingOption.toHashMap();

		String bookingType = (String) optionMap.get("bookingType");
		Long price = (Long) optionMap.get("price");
		if (bookingType.equals("hotel")) {
			return 0L;
		}
		else if (bookingType.equals("event")) {
			return quantity * price;
		}
		return 0L;
	}

	public HashMap<String, Object> countPayment(Map<String, Object> requestBody){
		String bookingOptionIdStr = (String) requestBody.get("roomId");
		String startDateStr = (String) requestBody.get("startDate");
		LocalDate startDate = LocalDate.parse(startDateStr);
		String endDateStr = (String) requestBody.get("endDate");
		LocalDate endDate = LocalDate.parse(endDateStr);
		String roomCountStr = (String) requestBody.get("roomCount");
		int roomCount = Integer.parseInt(roomCountStr);

		BookingOption bookingOption = null;
		if (bookingOptionIdStr != null) {
			UUID bookingOptionId = UUID.fromString(bookingOptionIdStr);
			bookingOption = orderRepository.getProxyObject(OnlineTicketing.bookingoption.core.BookingOptionComponent.class, bookingOptionId);
		}
		Long total = 0L;
		if (bookingOption.getBookingType().equals("hotel")) {
			long days = endDate.toEpochDay() - startDate.toEpochDay();
			total = bookingOption.getPrice() * days * roomCount;
		}

		HashMap<String, Object> result = new HashMap<>();
		result.put("startDate", startDate);
		result.put("endDate", endDate);
		result.put("roomCount", roomCount);
		result.put("totalPayment", total);

		return result;
	}

}
