package OnlineTicketing.order.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
//add other required packages

public abstract class OrderServiceComponent implements OrderService{
	protected RepositoryUtil<Order> orderRepository;

    public OrderServiceComponent(){
        this.orderRepository = new RepositoryUtil<Order>(OnlineTicketing.order.core.OrderComponent.class);
    }	

    // public abstract List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> saveOrder(Map<String, Object> requestBody);

    // public abstract Order createOrder(Map<String, Object> requestBodye);
    public abstract Order createOrder(Map<String, Object> requestBody);

	// public abstract Order createOrder(Map<String, Object> requestBody, Map<String, Object> response);    
	// public abstract HashMap<String, Object> updateOrder(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getOrder(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Order> List);
    // public abstract List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getOrderById(int id);

}
