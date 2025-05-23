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
import java.time.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.cart.CartItemFactory;
import OnlineTicketing.customer.core.*;
import OnlineTicketing.order.core.*;
//add other required packages

import OnlineTicketing.bookingoption.core.*;

public class CartItemServiceImpl extends CartItemServiceComponent{

	private CartItemFactory cartItemFactory = new CartItemFactory();
	private BookingOptionService bookingOptionService = new BookingOptionServiceImpl();
	private CartService cartService = new CartServiceImpl();
	private OrderService orderService = new OrderServiceImpl();

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
		String bookingOptionIdStr = (String) requestBody.get("bookingOptionId");

		Cart cart = null;
		if (cartIdStr != null) {
			UUID cartId = UUID.fromString(cartIdStr);
			cart = cartService.getCartById(cartId);
		}

		BookingOption bookingOption = null;
		if (bookingOptionIdStr != null){
			UUID bookingOptionId = UUID.fromString(bookingOptionIdStr);
			bookingOption = bookingOptionService.getBookingOption(bookingOptionId);
		}
		
		CartItem cartItem = CartItemFactory.createCartItem(
			"OnlineTicketing.cart.core.CartItemImpl"
		, bookingOption
		, cart
		, quantity
		, startDate
		, endDate
		, amount
		);
		cartItemRepository.saveObject(cartItem);
		return cartItem;
	}

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
		String table = "cartitem_impl";
		List<CartItem> list = cartItemRepository.getAllObject(table);
		return transformListToHashMap(list);
	}

	public List<HashMap<String, Object>> getAllCustomerCartItem(Map<String, Object> requestBody, Customer customer){
		Cart customerCart = getCustomerCart(customer);
		if (customerCart == null) return null;
		List<HashMap<String, Object>> cartCartItems = getCartItems(customerCart);
		return cartCartItems;
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CartItem> list){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < list.size(); i++) {
			HashMap<String, Object> cartItem = list.get(i).toHashMap();
			cartItem.put("startDate", cartItem.get("startDate").toString());
			cartItem.put("endDate", cartItem.get("endDate").toString());
            resultList.add(cartItem);
        }
        return resultList;
	}

    public List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		UUID id = UUID.fromString(idStr);
		cartItemRepository.deleteObject(id);
		return getAllCartItem(requestBody);
	}

	private Cart getCustomerCart(Customer customer){
		List<HashMap<String, Object>> carts = cartService.getAllCart(null);
		Cart customerCart = null;
		for(HashMap<String, Object> cart: carts){
			Cart tempCart = cartService.getCartById((UUID) cart.get("id"));
			if (tempCart.getCustomer().getCustomerId().toString().equals(customer.getCustomerId().toString()))
				customerCart = tempCart;
				break;
		}
		return customerCart;
	}

	private List<HashMap<String, Object>> getCartItems(Cart cart){
		List<HashMap<String, Object>> cartItems = getAllCartItem(null);
		List<HashMap<String, Object>> cartCartItems = new ArrayList<>();

		for(HashMap<String, Object> cartItem: cartItems){
			UUID cartId = (UUID) cartItem.get("cartId");
			if (cartId.toString().equals(cart.getId().toString()))
				cartCartItems.add(cartItem);
		}

		return cartCartItems;
	}

	public List<HashMap<String, Object>> checkoutCart(Map<String, Object> requestBody, Customer customer){
		Cart customerCart = getCustomerCart(customer);
		if (customerCart == null) return null;
		List<HashMap<String, Object>> cartCartItems = getCartItems(customerCart);
		if (cartCartItems.isEmpty()) return null;

		List<HashMap<String, Object>> orders = new ArrayList<>();
		for (HashMap<String, Object> cartItem: cartCartItems){
			Order order = orderService.createOrder(cartItem, customer);
			orders.add(order.toHashMap());
		}
		return orders;
	}
}
