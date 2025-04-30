package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class CartItemResourceDecorator extends CartItemResourceComponent{
	protected CartItemResourceComponent record;

    public CartItemResourceDecorator(CartItemResourceComponent record) {
        this.record = record;
    }

    public CartItem createCartItem(VMJExchange vmjExchange){
		return record.createCartItem(vmjExchange);
	}

    public HashMap<String, Object> updateCartItem(VMJExchange vmjExchange){
		return record.updateCartItem(vmjExchange);
	}

    public HashMap<String, Object> getCartItem(VMJExchange vmjExchange){
		return record.getCartItem(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange){
		return record.getAllCartItem(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange){
		return record.deleteCartItem(vmjExchange);
	}

}
