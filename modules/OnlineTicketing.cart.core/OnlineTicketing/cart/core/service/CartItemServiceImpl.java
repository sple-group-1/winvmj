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
import OnlineTicketing.cart.CartItemFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CartItemServiceImpl extends CartItemServiceComponent{

    public List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CartItem cartitem = createCartItem(vmjExchange);
		cartitemRepository.saveObject(cartitem);
		return getAllCartItem(vmjExchange);
	}

    public CartItem createCartItem(Map<String, Object> requestBody){
		String quantityStr = (String) requestBody.get("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String amountStr = (String) requestBody.get("amount");
		int amount = Integer.parseInt(amountStr);
		
		//to do: fix association attributes
		CartItem CartItem = CartItemFactory.createCartItem(
			"OnlineTicketing.cart.core.CartItemImpl",
		id
		, bookingitemimpl
		, cartimpl
		, quantity
		, startDate
		, endDate
		, amount
		);
		Repository.saveObject(cartitem);
		return cartitem;
	}

    public CartItem createCartItem(Map<String, Object> requestBody, int id){
		String quantityStr = (String) vmjExchange.getRequestBodyForm("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String amountStr = (String) vmjExchange.getRequestBodyForm("amount");
		int amount = Integer.parseInt(amountStr);
		
		//to do: fix association attributes
		
		CartItem cartitem = CartItemFactory.createCartItem("OnlineTicketing.cart.core.CartItemImpl", bookingitemimpl, cartimpl, quantity, startDate, endDate, amount);
		return cartitem;
	}

    public HashMap<String, Object> updateCartItem(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		CartItem cartitem = Repository.getObject(id);
		
		String quantityStr = (String) requestBody.get("quantity");
		cartitem.setQuantity(Integer.parseInt(quantityStr));
		String amountStr = (String) requestBody.get("amount");
		cartitem.setAmount(Integer.parseInt(amountStr));
		
		Repository.updateObject(cartitem);
		
		//to do: fix association attributes
		
		return cartitem.toHashMap();
		
	}

    public HashMap<String, Object> getCartItem(Map<String, Object> requestBody){
		List<HashMap<String, Object>> cartitemList = getAllCartItem("cartitem_impl");
		for (HashMap<String, Object> cartitem : cartitemList){
			int record_id = ((Double) cartitem.get("record_id")).intValue();
			if (record_id == id){
				return cartitem;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCartItemById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		CartItem cartitem = cartitemRepository.getObject(id);
		return cartitem.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCartItem(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<CartItem> List = Repository.getAllObject(table);
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
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCartItem(requestBody);
	}

}
