package OnlineTicketing.cart.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Cart {
	public UUID getId();
	public void setId(UUID id);
	public int getTotal();
	public void setTotal(int total);
	public CustomerImpl getCustomerimpl();
	public void setCustomerimpl(CustomerImpl customerimpl);
	HashMap<String, Object> toHashMap();
}
