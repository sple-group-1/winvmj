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

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.cart.CartFactory;
import OnlineTicketing.customer.core.*;
//add other required packages

public class CartServiceImpl extends CartServiceComponent{

	private CartFactory cartFactory = new CartFactory();
	private CustomerService customerService = new CustomerServiceImpl();

    // public List<HashMap<String,Object>> saveCart(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	Cart cart = createCart(vmjExchange);
	// 	cartRepository.saveObject(cart);
	// 	return getAllCart(vmjExchange);
	// }

    public Cart createCart(Map<String, Object> requestBody){
		int total = 0;
		String customerIdStr = (String) requestBody.get("customerId");

		Customer customer = null;
		if (customerIdStr != null) {
			UUID customerId = UUID.fromString(customerIdStr);
			customerId = (UUID) customerService.getCustomerById(customerId).get("customerId");
		}
		
		//to do: fix association attributes
		Cart cart = cartFactory.createCart(
			"OnlineTicketing.cart.core.CartImpl"
		, total
		, customer
		);
		cartRepository.saveObject(cart);
		return cart;
	}

    // public Cart createCart(Map<String, Object> requestBody, int id){
	// 	String totalStr = (String) vmjExchange.getRequestBodyForm("total");
	// 	int total = Integer.parseInt(totalStr);
		
	// 	//to do: fix association attributes
		
	// 	Cart cart = CartFactory.createCart("OnlineTicketing.cart.core.CartImpl", total, customerimpl);
	// 	return cart;
	// }

    public HashMap<String, Object> updateCart(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("cartItemId");
		UUID id = UUID.fromString(idStr);

		Cart cart = cartRepository.getObject(id);
		if (cart == null) {
			throw new NotFoundException("Cart not found for ID: " + id);
		}
		
		String totalStr = (String) requestBody.get("total");
		cart.setTotal(Integer.parseInt(totalStr));
		
		cartRepository.updateObject(cart);
		
		//to do: fix association attributes
		
		return cart.toHashMap();
		
	}

    public HashMap<String, Object> getCart(Map<String, Object> requestBody){
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "cart_impl");
		List<HashMap<String, Object>> cartList = getAllCart(map);
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);

		for (HashMap<String, Object> cart : cartList){
			// int record_id = ((Double) cart.get("record_id")).intValue();
			// if (record_id == id){
			// 	return cart;
			// }
			UUID record_id = UUID.fromString(cart.get("record_id").toString());
			if (record_id.equals(id)){
				return cart;
			}
		}
		return null;
	}

	// public HashMap<String, Object> getCartById(int id){
	// 	String idStr = vmjExchange.getGETParam("id"); 
	// 	id = Integer.parseInt(idStr);
	// 	Cart cart = cartRepository.getObject(id);
	// 	return cart.toHashMap();
	// }

	public Cart getCartById(UUID id){
		Cart cart = cartRepository.getObject(id);
		return cart;
	}

    public List<HashMap<String,Object>> getAllCart(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Cart> List = cartRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Cart> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    // public List<HashMap<String,Object>> deleteCart(Map<String, Object> requestBody){
	// 	String idStr = ((String) requestBody.get("id"));
	// 	int id = Integer.parseInt(idStr);
	// 	Repository.deleteObject(id);
	// 	return getAllCart(requestBody);
	// }

}
