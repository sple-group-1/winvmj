package OnlineTicketing.cart.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class CartResourceDecorator extends CartResourceComponent{
	protected CartResourceComponent record;

    public CartResourceDecorator(CartResourceComponent record) {
        this.record = record;
    }

    public Cart createCart(VMJExchange vmjExchange){
		return record.createCart(vmjExchange);
	}

    public HashMap<String, Object> updateCart(VMJExchange vmjExchange){
		return record.updateCart(vmjExchange);
	}

    public HashMap<String, Object> getCart(VMJExchange vmjExchange){
		return record.getCart(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllCart(VMJExchange vmjExchange){
		return record.getAllCart(vmjExchange);
	}

    // public List<HashMap<String,Object>> deleteCart(VMJExchange vmjExchange){
	// 	return record.deleteCart(vmjExchange);
	// }

}
