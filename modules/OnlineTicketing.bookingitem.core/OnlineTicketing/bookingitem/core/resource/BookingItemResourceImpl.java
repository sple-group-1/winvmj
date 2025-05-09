package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.bookingitem.BookingItemFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BookingItemResourceImpl extends BookingItemResourceComponent{
	
	private BookingItemServiceImpl bookingitemServiceImpl = new BookingItemServiceImpl();

	// @Restriced(permission = "")
  @Route(url="call/bookingitem/create")
    public HashMap<String,Object> createBookingItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
				BookingItem result = bookingitemServiceImpl.createBookingItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/bookingitem/update")
    public HashMap<String, Object> updateBookingItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return bookingitemServiceImpl.updateBookingItem(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/bookingitem/detail")
    public HashMap<String, Object> getBookingItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bookingitemServiceImpl.getBookingItem(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/bookingitem/list")
    public List<HashMap<String,Object>> getAllBookingItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bookingitemServiceImpl.getAllBookingItem(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/bookingitem/delete")
    public List<HashMap<String,Object>> deleteBookingItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return bookingitemServiceImpl.deleteBookingItem(requestBody);
	}

}
