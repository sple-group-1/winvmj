package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.cart.CartItemFactory;
import OnlineTicketing.customer.core.*;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CartItemResourceImpl extends CartItemResourceComponent{
	
	private CartItemServiceImpl cartitemServiceImpl = new CartItemServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/cartitem")
    public HashMap<String,Object> createCartItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CartItem result = cartitemServiceImpl.createCartItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/cartitem/update")
    public HashMap<String, Object> updateCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return cartitemServiceImpl.updateCartItem(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/cartitem/detail")
    public HashMap<String, Object> getCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return cartitemServiceImpl.getCartItem(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/cartitem/list")
    public List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange){
		String email = vmjExchange.getAuthPayload().getEmail();
		Customer customer = customerService.getCustomerByEmail(email);
		UUID customerId = customer.getCustomerId();

		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return cartitemServiceImpl.getAllCartItem(requestBody, customer);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/cartitem/delete")
    public List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return cartitemServiceImpl.deleteCartItem(requestBody);
	}

	@Route(url="call/cartitem/checkout")
	public List<HashMap<String, Object>> checkoutCart(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
			String email = vmjExchange.getAuthPayload().getEmail();
			Customer customer = customerService.getCustomerByEmail(email);
			UUID customerId = customer.getCustomerId();

		    Map<String, Object> requestBody = vmjExchange.getPayload(); 

			List<HashMap<String, Object>> result = cartitemServiceImpl.checkoutCart(requestBody, customer);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
}
