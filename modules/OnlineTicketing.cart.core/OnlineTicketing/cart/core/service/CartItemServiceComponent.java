package OnlineTicketing.cart.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
import OnlineTicketing.customer.core.*;
//add other required packages

public abstract class CartItemServiceComponent implements CartItemService{
	protected RepositoryUtil<CartItem> cartItemRepository;

    public CartItemServiceComponent(){
        this.cartItemRepository = new RepositoryUtil<CartItem>(OnlineTicketing.cart.core.CartItemComponent.class);
    }	

    // public abstract List<HashMap<String,Object>> saveCartItem(VMJExchange vmjExchange);
    // public abstract List<HashMap<String,Object>> saveCartItem(Map<String, Object> requestBody);
    // public abstract CartItem createCartItem(Map<String, Object> requestBodye);
	public abstract CartItem createCartItem(Map<String, Object> requestBody);    
	public abstract HashMap<String, Object> updateCartItem(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getCartItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllCartItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<CartItem> List);
    public abstract List<HashMap<String,Object>> deleteCartItem(Map<String, Object> requestBody);
    public abstract List<HashMap<String, Object>> getAllCustomerCartItem(Map<String, Object> requestBody, Customer customer);
	// public abstract HashMap<String, Object> getCartItemById(int id);
    public abstract HashMap<String, Object> getCartItemById(UUID id);
    public abstract List<HashMap<String, Object>> checkoutCart(Map<String, Object> requestBody, Customer customer);
}
