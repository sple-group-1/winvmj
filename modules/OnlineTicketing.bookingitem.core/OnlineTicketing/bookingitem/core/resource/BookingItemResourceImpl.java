package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.bookingitem.BookingItemFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class BookingItemResourceImpl extends BookingItemResourceComponent{
	BookingItemService bookingItemService = new BookingItemServiceImpl();

  	@Restricted(permissionName = "CreateBookingItem")
  	@Route(url="call/bookingitem/save")
    public HashMap<String,Object> createBookingItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingItem result = bookingItemService.createBookingItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    @Restricted(permissionName = "UpdateBookingItem")
    @Route(url="call/bookingitem/update")
    public HashMap<String, Object> updateBookingItem(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		BookingItem result = bookingItemService.updateBookingItem(requestBody);
		return result.toHashMap();
		
	}

  	@Restricted(permissionName = "ReadBookingItem")
    @Route(url="call/bookingitem/detail")
    public HashMap<String, Object> getBookingItem(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id");
		if(idStr == null) {
		throw new IllegalArgumentException("Invalid UUID");
		}
		UUID id = UUID.fromString(idStr);

		BookingItem result = bookingItemService.getBookingItem(id);
		return result.toHashMap();
	}

  	@Restricted(permissionName = "ReadBookingItem")
    @Route(url="call/bookingitem/list")
    public List<HashMap<String,Object>> getAllBookingItem(VMJExchange vmjExchange){
		List<BookingItem> result = bookingItemService.getAllBookingItem();
		return bookingItemService.transformListToHashMap(result);
	}

  	@Restricted(permissionName = "DeleteBookingItem")
    @Route(url="call/bookingitem/delete")
    public List<HashMap<String,Object>> deleteBookingItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		String idStr = (String) vmjExchange.getRequestBodyForm("id");
    	UUID id = UUID.fromString(idStr);
		
		List<BookingItem> result = bookingItemService.deleteBookingItem(id);
		return bookingItemService.transformListToHashMap(result);
	}

}
