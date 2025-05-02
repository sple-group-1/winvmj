package OnlineTicketing.order.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class OrderResourceComponent implements OrderResource{
	protected RepositoryUtil<Order> orderRepository;

	public OrderResourceComponent() { 
        this.orderRepository = new RepositoryUtil<Order>(OnlineTicketing.order.core.OrderComponent.class);
    }
 
    // public abstract Order createOrder(VMJExchange vmjExchange);    
    public abstract HashMap<String, Object> createOrder(VMJExchange vmjExchange);    
	// public abstract HashMap<String, Object> updateOrder(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getOrder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllOrder(VMJExchange vmjExchange);
    // public abstract List<HashMap<String,Object>> deleteOrder(VMJExchange vmjExchange);

}
