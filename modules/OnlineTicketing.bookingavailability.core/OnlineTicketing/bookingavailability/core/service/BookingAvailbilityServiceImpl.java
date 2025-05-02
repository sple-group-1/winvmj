package OnlineTicketing.bookingavailability.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.bookingavailability.BookingAvailbilityFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BookingAvailbilityServiceImpl extends BookingAvailbilityServiceComponent{

    public List<HashMap<String,Object>> saveBookingAvailability(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BookingAvailability bookingavailability = createBookingAvailability(vmjExchange);
		bookingavailabilityRepository.saveObject(bookingavailability);
		return getAllBookingAvailability(vmjExchange);
	}

    public BookingAvailability createBookingAvailability(Map<String, Object> requestBody){
		String quotaStr = (String) requestBody.get("quota");
		int quota = Integer.parseInt(quotaStr);
		String availableStr = (String) requestBody.get("available");
		int available = Integer.parseInt(availableStr);
		
		//to do: fix association attributes
		BookingAvailability BookingAvailability = BookingAvailabilityFactory.createBookingAvailability(
			"OnlineTicketing.bookingavailability.core.BookingAvailbilityImpl",
		id
		, quota
		, available
		, bookingoptionimpl
		);
		Repository.saveObject(bookingavailability);
		return bookingavailability;
	}

    public BookingAvailability createBookingAvailability(Map<String, Object> requestBody, int id){
		String quotaStr = (String) vmjExchange.getRequestBodyForm("quota");
		int quota = Integer.parseInt(quotaStr);
		String availableStr = (String) vmjExchange.getRequestBodyForm("available");
		int available = Integer.parseInt(availableStr);
		
		//to do: fix association attributes
		
		BookingAvailability bookingavailability = BookingAvailabilityFactory.createBookingAvailability("OnlineTicketing.bookingavailability.core.BookingAvailbilityImpl", quota, available, bookingoptionimpl);
		return bookingavailability;
	}

    public HashMap<String, Object> updateBookingAvailability(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		BookingAvailability bookingavailability = Repository.getObject(id);
		
		String quotaStr = (String) requestBody.get("quota");
		bookingavailability.setQuota(Integer.parseInt(quotaStr));
		String availableStr = (String) requestBody.get("available");
		bookingavailability.setAvailable(Integer.parseInt(availableStr));
		
		Repository.updateObject(bookingavailability);
		
		//to do: fix association attributes
		
		return bookingavailability.toHashMap();
		
	}

    public HashMap<String, Object> getBookingAvailability(Map<String, Object> requestBody){
		List<HashMap<String, Object>> bookingavailabilityList = getAllBookingAvailability("bookingavailability_impl");
		for (HashMap<String, Object> bookingavailability : bookingavailabilityList){
			int record_id = ((Double) bookingavailability.get("record_id")).intValue();
			if (record_id == id){
				return bookingavailability;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBookingAvailabilityById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		BookingAvailability bookingavailability = bookingavailabilityRepository.getObject(id);
		return bookingavailability.toHashMap();
	}

    public List<HashMap<String,Object>> getAllBookingAvailability(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<BookingAvailability> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BookingAvailability> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBookingAvailability(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBookingAvailability(requestBody);
	}

}
