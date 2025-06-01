package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.VMJExchange;
import OnlineTicketing.customer.core.*;

public abstract class CartItemServiceDecorator extends CartItemServiceComponent{
	protected CartItemServiceComponent record;

    public CartItemServiceDecorator(CartItemServiceComponent record) {
        this.record = record;
    }

	public CartItem createCartItem(Map<String, Object> requestBody){
		return record.createCartItem(requestBody);
	}

    // public CartItem createCartItem(Map<String, Object> requestBody, Map<String, Object> response){
	// 	return record.createCartItem(requestBody, response);
	// }

	public HashMap<String, Object> getCartItem(Map<String, Object> requestBody){
		return record.getCartItem(requestBody);
	}

	public List<HashMap<String,Object>> getAllCartItem(Map<String, Object> requestBody){
		return record.getAllCartItem(requestBody);
	}

	public List<HashMap<String, Object>> getAllCustomerCartItem(Map<String, Object> requestBody, Customer customer){
		return record.getAllCustomerCartItem(requestBody, customer);
	}

    // public List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange){
	// 	return record.saveCartItem(vmjExchange);
	// }

    public HashMap<String, Object> updateCartItem(Map<String, Object> requestBody){
		return record.updateCartItem(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CartItem> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody){
		return record.deleteCartItem(requestBody);
	}

	// public HashMap<String, Object> getCartItemById(int id){
    //     return record.getCartItemById(id);
    // }

	public HashMap<String, Object> getCartItemById(UUID id){
        return record.getCartItemById(id);
    }

	public List<HashMap<String, Object>> checkoutCart(Map<String, Object> requestBody, Customer customer){
		return record.checkoutCart(requestBody, customer);
	}
}
