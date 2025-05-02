package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.bookingoption.BookingOptionFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BookingOptionResourceImpl extends BookingOptionResourceComponent{
	
	private BookingOptionServiceImpl bookingoptionServiceImpl = new BookingOptionServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/bookingoption")
    public HashMap<String,Object> createbookingoption(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingOption result = bookingoptionServiceImpl.createBookingOption(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/bookingoption/update")
    public HashMap<String, Object> updateBookingOption(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return bookingoptionServiceImpl.updateBookingOption(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/bookingoption/detail")
    public HashMap<String, Object> getBookingOption(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bookingoptionServiceImpl.getBookingOption(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/bookingoption/list")
    public List<HashMap<String,Object>> getAllBookingOption(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return bookingoptionServiceImpl.getAllBookingOption(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/bookingoption/delete")
    public List<HashMap<String,Object>> deleteBookingOption(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return bookingoptionServiceImpl.deleteBookingOption(requestBody);
	}

}
