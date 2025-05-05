package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.cart.CartFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CartResourceImpl extends CartResourceComponent{
	
	private CartServiceImpl cartServiceImpl = new CartServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/cart")
    public HashMap<String,Object> createcart(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Cart result = cartServiceImpl.createCart(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/cart/update")
    public HashMap<String, Object> updateCart(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return cartServiceImpl.updateCart(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/cart/detail")
    public HashMap<String, Object> getCart(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return cartServiceImpl.getCart(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/cart/list")
    public List<HashMap<String,Object>> getAllCart(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return cartServiceImpl.getAllCart(requestBody);
	}

    
	// @Restriced(permission = "")
    // @Route(url="call/cart/delete")
    // public List<HashMap<String,Object>> deleteCart(VMJExchange vmjExchange){
	// 	Map<String, Object> requestBody = vmjExchange.getPayload(); 
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
		
	// 	return cartServiceImpl.deleteCart(requestBody);
	// }

}
