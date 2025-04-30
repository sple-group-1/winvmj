package OnlineTicketing.cart.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CartItemResourceComponent implements CartItemResource{
	
	public CartItemResourceComponent() { }
 
    public abstract CartItem createCartItem(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateCartItem(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getCartItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllCartItem(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteCartItem(VMJExchange vmjExchange);

}
