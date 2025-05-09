package OnlineTicketing.cart.core;
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
import java.time.LocalDate;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.cart.CartItemFactory;
//add other required packages

import OnlineTicketing.bookingitem.core.*;

public class CartItemServiceImpl extends CartItemServiceComponent{

	private CartItemFactory cartItemFactory = new CartItemFactory();

    // public List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	CartItem cartitem = createCartItem(vmjExchange);
	// 	cartitemRepository.saveObject(cartitem);
	// 	return getAllCartItem(vmjExchange);
	// }

	// public List<HashMap<String,Object>> saveCartItem(Map<String, Object> requestBody){
	// 	String quantityStr = (String) requestBody.get("quantity");
	// 	int quantity = Integer.parseInt(quantityStr);
	// 	String startStr = (String) requestBody.get("start_date");
	// 	LocalDate startDate = LocalDate.parse(startStr);
	// 	String endStr = (String) requestBody.get("end_date");
	// 	LocalDate endDate = LocalDate.parse(endStr);
	// 	String cartIdStr = (String) requestBody.get("cartId");


	// 	CartItem cartitem = cartItemFactory.createCartItem();
	// 	cartitemRepository.saveObject(cartitem);
	// 	return getAllCartItem(requestBody);
	// }

    public CartItem createCartItem(Map<String, Object> requestBody){
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String startStr = (String) requestBody.get("start_date");
		LocalDate startDate = LocalDate.parse(startStr);
		String endStr = (String) requestBody.get("end_date");
		LocalDate endDate = LocalDate.parse(endStr);
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);

		String cartIdStr = (String) requestBody.get("cartId");
		String bookingitemIdStr = (String) requestBody.get("bookingItemId");

		Cart cart = null;
		if (cartIdStr != null) {
			UUID cartId = UUID.fromString(cartIdStr);
			cart = cartItemRepository.getProxyObject(OnlineTicketing.cart.core.CartComponent.class, cartId);
		}

		BookingItem bookingitem = null;
		if (bookingitemIdStr != null){
			UUID bookingitemId = UUID.fromString(bookingitemIdStr);
			bookingitem = cartItemRepository.getProxyObject(OnlineTicketing.bookingitem.core.BookingItemComponent.class, bookingitemId);
		}
		
		//to do: fix association attributes
		CartItem cartItem = CartItemFactory.createCartItem(
			"OnlineTicketing.cart.core.CartItemImpl"
		, bookingitem
		, cart
		, quantity
		, startDate
		, endDate
		, amount
		);
		cartItemRepository.saveObject(cartItem);
		return cartItem;
	}

    // public CartItem createCartItem(Map<String, Object> requestBody, int id){
	// 	String quantityStr = (String) vmjExchange.getRequestBodyForm("quantity");
	// 	int quantity = Integer.parseInt(quantityStr);
	// 	String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
	// 	int amount = Integer.parseInt(amountStr);
		
	// 	//to do: fix association attributes
		
	// 	CartItem cartitem = CartItemFactory.createCartItem("OnlineTicketing.cart.core.CartItemImpl", bookingitemimpl, cartimpl, quantity, startDate, endDate, amount);
	// 	return cartitem;
	// }

    public HashMap<String, Object> updateCartItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("cartItemId");
		UUID id = UUID.fromString(idStr);

		CartItem cartItem = cartItemRepository.getObject(id);
		if (cartItem == null) {
			throw new NotFoundException("CartItem not found for ID: " + id);
		}

		String quantityStr = (String) requestBody.get("quantity");
		cartItem.setQuantity(Integer.parseInt(quantityStr));
		String startStr = (String) requestBody.get("start_date");
		cartItem.setStartDate(LocalDate.parse(startStr));
		String endStr = (String) requestBody.get("end_date");
		cartItem.setEndDate(LocalDate.parse(endStr));
		String amountStr = (String) requestBody.get("amount");
		cartItem.setAmount(Integer.parseInt(amountStr));
		
		cartItemRepository.updateObject(cartItem);
		// to do: ngerjain total
		
		return cartItem.toHashMap();
		
	}

    public HashMap<String, Object> getCartItem(Map<String, Object> requestBody){
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "cartitem_impl");
		List<HashMap<String, Object>> cartitemList = getAllCartItem(map);
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		for (HashMap<String, Object> cartitem : cartitemList){
			// int record_id = ((Double) cartitem.get("record_id")).intValue();
			// if (record_id == id){
			// 	return cartitem;
			// }

			UUID record_id = UUID.fromString(cartitem.get("record_id").toString());
			if (record_id.equals(id)){
				return cartitem;
			}
		}
		return null;
	}

	// public HashMap<String, Object> getCartItemById(int id){
	// 	String idStr = vmjExchange.getGETParam("id"); 
	// 	id = Integer.parseInt(idStr);
	// 	CartItem cartitem = cartitemRepository.getObject(id);
	// 	return cartitem.toHashMap();
	// }
	public HashMap<String, Object> getCartItemById(UUID id){
		CartItem cartitem = cartItemRepository.getObject(id);
		return cartitem.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCartItem(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<CartItem> List = cartItemRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CartItem> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		UUID id = UUID.fromString(idStr);
		cartItemRepository.deleteObject(id);
		return getAllCartItem(requestBody);
	}
}
