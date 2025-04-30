package OnlineTicketing.bookingavailability.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.bookingavailability.BookingAvailbilityFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BookingAvailbilityResourceImpl extends BookingAvailbilityResourceComponent{
	
	private BookingAvailbilityServiceImpl bookingavailabilityServiceImpl = new BookingAvailbilityServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/bookingavailability")
    public HashMap<String,Object> createbookingavailability(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingAvailability result = bookingavailabilityServiceImpl.createBookingAvailability(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/bookingavailability/update")
    public HashMap<String, Object> updateBookingAvailability(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return bookingavailabilityServiceImpl.updateBookingAvailability(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/bookingavailability/detail")
    public HashMap<String, Object> getBookingAvailability(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bookingavailabilityServiceImpl.getBookingAvailability(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/bookingavailability/list")
    public List<HashMap<String,Object>> getAllBookingAvailability(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bookingavailabilityServiceImpl.getAllBookingAvailability(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/bookingavailability/delete")
    public List<HashMap<String,Object>> deleteBookingAvailability(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return bookingavailabilityServiceImpl.deleteBookingAvailability(requestBody);
	}

}
