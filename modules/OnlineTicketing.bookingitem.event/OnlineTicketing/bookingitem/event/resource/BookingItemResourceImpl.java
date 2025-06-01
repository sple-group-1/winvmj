package OnlineTicketing.bookingitem.event;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;

import OnlineTicketing.bookingitem.core.BookingItemResourceDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemResourceComponent;
import OnlineTicketing.bookingitem.core.BookingItemService;
import OnlineTicketing.bookingitem.core.BookingItemServiceComponent;

public class BookingItemResourceImpl extends BookingItemResourceDecorator {
	private BookingItemService bookingItemService;

    public BookingItemResourceImpl (BookingItemResourceComponent recordController, BookingItemServiceComponent recordService) {
        super(recordController);
		this.bookingItemService = new BookingItemServiceImpl(recordService);
    }

  	@Restricted(permissionName = "CreateEvent")
    @Route(url="call/event/save")
    public HashMap<String,Object> createBookingItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		BookingItem event = bookingItemService.createBookingItem(requestBody);
		return event.toHashMap();
	}

  	@Restricted(permissionName = "UpdateEvent")
    @Route(url="call/event/update")
    public HashMap<String, Object> updateBookingItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		BookingItem result = bookingItemService.updateBookingItem(requestBody);
		return result.toHashMap();
		
	}

  	@Restricted(permissionName = "ReadEvent")
    @Route(url="call/event/detail")
    public HashMap<String, Object> getBookingItem(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("eventId");
		if(idStr == null) {
		throw new IllegalArgumentException("Invalid UUID");
		}
		UUID id = UUID.fromString(idStr);

		BookingItem result = bookingItemService.getBookingItem(id);
		return result.toHashMap();
	}

  	@Restricted(permissionName = "ReadEvent")
    @Route(url="call/event/list")
    public List<HashMap<String,Object>> getAllBookingItem(VMJExchange vmjExchange){
		List<BookingItem> result = bookingItemService.getAllBookingItem();
		return bookingItemService.transformListToHashMap(result);
	}

  	@Restricted(permissionName = "DeleteEvent")
    @Route(url="call/event/delete")
    public List<HashMap<String,Object>> deleteBookingItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("eventId");
    	UUID id = UUID.fromString(idStr);
		
		List<BookingItem> result = bookingItemService.deleteBookingItem(id);
		return bookingItemService.transformListToHashMap(result);
	}

}
