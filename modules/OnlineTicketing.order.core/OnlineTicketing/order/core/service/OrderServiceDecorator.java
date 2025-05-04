package OnlineTicketing.order.core;
import java.util.*;

public abstract class OrderServiceDecorator extends OrderServiceComponent{
	protected OrderServiceComponent record;

    public OrderServiceDecorator(OrderServiceComponent record) {
        this.record = record;
    }

	public Order createOrder(Map<String, Object> requestBody){
		return record.createOrder(requestBody);
	}

	public HashMap<String, Object> getOrder(Map<String, Object> requestBody){
		return record.getOrder(requestBody);
	}

	public List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody){
		return record.getAllOrder(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Order> List){
		return record.transformListToHashMap(List);
	}

	public HashMap<String, Object> getOrderById(UUID id){
        return record.getOrderById(id);
    }

    public List<HashMap<String, Object>> getCompletedOrder(UUID customerId, String bookingType) {
		return record.getCompletedOrder(customerId, bookingType);
	}

	public List<HashMap<String, Object>> getUpcomingOrder(UUID customerId, String bookingType) {
		return record.getUpcomingOrder(customerId, bookingType);
	}

	public HashMap<String, Object> countPayment(Map<String, Object> requestBody){
		return record.countPayment(requestBody);
	}
}
