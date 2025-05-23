package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class CartServiceDecorator extends CartServiceComponent{
	protected CartServiceComponent record;

    public CartServiceDecorator(CartServiceComponent record) {
        this.record = record;
    }

	public Cart createCart(Map<String, Object> requestBody){
		return record.createCart(requestBody);
	}

    // public Cart createCart(Map<String, Object> requestBody, Map<String, Object> response){
	// 	return record.createCart(requestBody, response);
	// }

	public HashMap<String, Object> getCart(Map<String, Object> requestBody){
		return record.getCart(requestBody);
	}

	public List<HashMap<String,Object>> getAllCart(Map<String, Object> requestBody){
		return record.getAllCart(requestBody);
	}

    // public List<HashMap<String,Object>> saveCart(VMJExchange vmjExchange){
	// 	return record.saveCart(vmjExchange);
	// }

    public HashMap<String, Object> updateCart(Map<String, Object> requestBody){
		return record.updateCart(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Cart> List){
		return record.transformListToHashMap(List);
	}

    // public List<HashMap<String,Object>> deleteCart(Map<String, Object> requestBody){
	// 	return record.deleteCart(requestBody);
	// }

	public Cart getCartById(UUID id){
        return record.getCartById(id);
    }

}
