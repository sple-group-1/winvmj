package OnlineTicketing.bookingoption.core;
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
import OnlineTicketing.bookingoption.BookingOptionFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BookingOptionServiceImpl extends BookingOptionServiceComponent{

    public List<HashMap<String,Object>> saveBookingOption(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BookingOption bookingoption = createBookingOption(vmjExchange);
		bookingoptionRepository.saveObject(bookingoption);
		return getAllBookingOption(vmjExchange);
	}

    public BookingOption createBookingOption(Map<String, Object> requestBody){
		String bookingType = (String) requestBody.get("bookingType");
		
		//to do: fix association attributes
		BookingOption BookingOption = BookingOptionFactory.createBookingOption(
			"OnlineTicketing.bookingoption.core.BookingOptionImpl",
		id
		, price
		, bookingType
		, bookingitemimpl
		);
		Repository.saveObject(bookingoption);
		return bookingoption;
	}

    public BookingOption createBookingOption(Map<String, Object> requestBody, int id){
		String bookingType = (String) vmjExchange.getRequestBodyForm("bookingType");
		
		//to do: fix association attributes
		
		BookingOption bookingoption = BookingOptionFactory.createBookingOption("OnlineTicketing.bookingoption.core.BookingOptionImpl", price, bookingType, bookingitemimpl);
		return bookingoption;
	}

    public HashMap<String, Object> updateBookingOption(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		BookingOption bookingoption = Repository.getObject(id);
		
		bookingoption.setBookingType((String) requestBody.get("bookingType"));
		
		Repository.updateObject(bookingoption);
		
		//to do: fix association attributes
		
		return bookingoption.toHashMap();
		
	}

    public HashMap<String, Object> getBookingOption(Map<String, Object> requestBody){
		List<HashMap<String, Object>> bookingoptionList = getAllBookingOption("bookingoption_impl");
		for (HashMap<String, Object> bookingoption : bookingoptionList){
			int record_id = ((Double) bookingoption.get("record_id")).intValue();
			if (record_id == id){
				return bookingoption;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBookingOptionById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		BookingOption bookingoption = bookingoptionRepository.getObject(id);
		return bookingoption.toHashMap();
	}

    public List<HashMap<String,Object>> getAllBookingOption(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<BookingOption> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BookingOption> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBookingOption(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBookingOption(requestBody);
	}

}
