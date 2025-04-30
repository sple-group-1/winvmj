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
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CartServiceImpl extends CartServiceComponent{

    public List<HashMap<String,Object>> saveCart(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Cart cart = createCart(vmjExchange);
		cartRepository.saveObject(cart);
		return getAllCart(vmjExchange);
	}

    public Cart createCart(Map<String, Object> requestBody){
		String totalStr = (String) requestBody.get("total");
		int total = Integer.parseInt(totalStr);
		
		//to do: fix association attributes
		Cart Cart = CartFactory.createCart(
			"OnlineTicketing.cart.core.CartImpl",
		id
		, total
		, customerimpl
		);
		Repository.saveObject(cart);
		return cart;
	}

    public Cart createCart(Map<String, Object> requestBody, int id){
		String totalStr = (String) vmjExchange.getRequestBodyForm("total");
		int total = Integer.parseInt(totalStr);
		
		//to do: fix association attributes
		
		Cart cart = CartFactory.createCart("OnlineTicketing.cart.core.CartImpl", total, customerimpl);
		return cart;
	}

    public HashMap<String, Object> updateCart(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		Cart cart = Repository.getObject(id);
		
		String totalStr = (String) requestBody.get("total");
		cart.setTotal(Integer.parseInt(totalStr));
		
		Repository.updateObject(cart);
		
		//to do: fix association attributes
		
		return cart.toHashMap();
		
	}

    public HashMap<String, Object> getCart(Map<String, Object> requestBody){
		List<HashMap<String, Object>> cartList = getAllCart("cart_impl");
		for (HashMap<String, Object> cart : cartList){
			int record_id = ((Double) cart.get("record_id")).intValue();
			if (record_id == id){
				return cart;
			}
		}
		return null;
	}

	public HashMap<String, Object> getCartById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Cart cart = cartRepository.getObject(id);
		return cart.toHashMap();
	}

    public List<HashMap<String,Object>> getAllCart(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Cart> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Cart> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCart(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCart(requestBody);
	}

}
