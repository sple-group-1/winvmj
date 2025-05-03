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

    // public Order createOrder(Map<String, Object> requestBody, Map<String, Object> response){
	// 	return record.createOrder(requestBody, response);
	// }

	public HashMap<String, Object> getOrder(Map<String, Object> requestBody){
		return record.getOrder(requestBody);
	}

	public List<HashMap<String,Object>> getAllOrder(Map<String, Object> requestBody){
		return record.getAllOrder(requestBody);
	}

    // public List<HashMap<String,Object>> saveOrder(VMJExchange vmjExchange){
	// 	return record.saveOrder(vmjExchange);
	// }

	// public List<HashMap<String,Object>> saveOrder(Map<String, Object> requestBody){
	// 	return record.saveOrder(requestBody);
	// }

    // public HashMap<String, Object> updateOrder(Map<String, Object> requestBody){
	// 	return record.updateOrder(requestBody);
	// }

    public List<HashMap<String,Object>> transformListToHashMap(List<Order> List){
		return record.transformListToHashMap(List);
	}

    // public List<HashMap<String,Object>> deleteOrder(Map<String, Object> requestBody){
	// 	return record.deleteOrder(requestBody);
	// }

	public HashMap<String, Object> getOrderById(UUID id){
	// public HashMap<String, Object> getOrderById(int id){
        return record.getOrderById(id);
    }

}
