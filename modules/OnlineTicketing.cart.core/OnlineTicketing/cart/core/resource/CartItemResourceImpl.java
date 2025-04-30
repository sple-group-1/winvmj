package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.cart.CartItemFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CartItemResourceImpl extends CartItemResourceComponent{
	
	private CartItemServiceImpl cartitemServiceImpl = new CartItemServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/cart")
    public HashMap<String,Object> createcartitem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CartItem result = cartitemServiceImpl.createCartItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/cart/update")
    public HashMap<String, Object> updateCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return cartitemServiceImpl.updateCartItem(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/cart/detail")
    public HashMap<String, Object> getCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return cartitemServiceImpl.getCartItem(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/cart/list")
    public List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return cartitemServiceImpl.getAllCartItem(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/cart/delete")
    public List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return cartitemServiceImpl.deleteCartItem(requestBody);
	}

}
