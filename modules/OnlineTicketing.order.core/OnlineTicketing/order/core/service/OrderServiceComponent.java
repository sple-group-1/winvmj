package OnlineTicketing.order.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import OnlineTicketing.customer.core.Customer;
//add other required packages

public abstract class OrderServiceComponent implements OrderService{
	protected RepositoryUtil<Order> orderRepository;

    public OrderServiceComponent(){
        this.orderRepository = new RepositoryUtil<Order>(OnlineTicketing.order.core.OrderComponent.class);
    }	

    public abstract Order createOrder(Map<String, Object> requestBody, Customer customer);
    public abstract List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Order> List);
	public abstract HashMap<String, Object> getOrder(UUID id);
    public abstract List<HashMap<String, Object>> getCompletedOrder(UUID customerId, String bookingType);
    public abstract List<HashMap<String, Object>> getUpcomingOrder(UUID customerId, String bookingType);
	public abstract HashMap<String, Object> countPayment(Map<String, Object> requestBody);

}
