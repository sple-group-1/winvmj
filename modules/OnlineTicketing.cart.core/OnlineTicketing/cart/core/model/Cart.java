package OnlineTicketing.cart.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;
import OnlineTicketing.customer.core.*;

public interface Cart {
	public UUID getId();
	public void setId(UUID id);
	public int getTotal();
	public void setTotal(int total);
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	HashMap<String, Object> toHashMap();
}
