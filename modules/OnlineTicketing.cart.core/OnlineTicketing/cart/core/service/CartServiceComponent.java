package OnlineTicketing.cart.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class CartServiceComponent implements CartService{
	protected RepositoryUtil<Cart> cartRepository;

    public CartServiceComponent(){
        this.cartRepository = new RepositoryUtil<Cart>(OnlineTicketing.cart.core.CartComponent.class);
    }	

	public abstract Cart createCart(Map<String, Object> requestBody);    
	public abstract HashMap<String, Object> updateCart(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getCart(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllCart(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Cart> List);
    public abstract Cart getCartById(UUID id);

}
