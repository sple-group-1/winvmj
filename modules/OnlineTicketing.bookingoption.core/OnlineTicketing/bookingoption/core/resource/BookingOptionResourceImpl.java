package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.bookingoption.BookingOptionFactory;
import vmj.auth.annotations.Restricted;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BookingOptionResourceImpl extends BookingOptionResourceComponent{
	BookingOptionService bookingOptionService = new BookingOptionServiceImpl();

  	@Restricted(permissionName = "CreateBookingOption")
  	@Route(url="call/bookingoption/save")
    public HashMap<String,Object> createBookingOption(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingOption result = bookingOptionService.createBookingOption(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    @Restricted(permissionName = "UpdateBookingOption")
    @Route(url="call/bookingoption/update")
    public HashMap<String, Object> updateBookingOption(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		BookingOption result = bookingOptionService.updateBookingOption(requestBody);
		return result.toHashMap();
		
	}

  	@Restricted(permissionName = "ReadBookingOption")
    @Route(url="call/bookingoption/detail")
    public HashMap<String, Object> getBookingOption(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id");
		if(idStr == null) {
		throw new IllegalArgumentException("Invalid UUID");
		}
		UUID id = UUID.fromString(idStr);

		BookingOption result = bookingOptionService.getBookingOption(id);
		return result.toHashMap();
	}

  	@Restricted(permissionName = "ReadBookingOption")
    @Route(url="call/bookingoption/list")
    public List<HashMap<String,Object>> getAllBookingOption(VMJExchange vmjExchange){
		List<BookingOption> result = bookingOptionService.getAllBookingOption();
		return bookingOptionService.transformListToHashMap(result);
	}

  	@Restricted(permissionName = "DeleteBookingOption")
    @Route(url="call/bookingoption/delete")
    public List<HashMap<String,Object>> deleteBookingOption(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		String idStr = (String) vmjExchange.getRequestBodyForm("id");
    	UUID id = UUID.fromString(idStr);
		
		List<BookingOption> result = bookingOptionService.deleteBookingOption(id);
		return bookingOptionService.transformListToHashMap(result);
	}

}
