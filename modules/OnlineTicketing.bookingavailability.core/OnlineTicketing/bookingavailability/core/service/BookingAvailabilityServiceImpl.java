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
import OnlineTicketing.bookingavailability.BookingAvailabilityFactory;
// import prices.auth.vmj.annotations.Restricted;
//add other required packages
import OnlineTicketing.bookingoption.core.BookingOption;

public class BookingAvailabilityServiceImpl extends BookingAvailabilityServiceComponent {

	public BookingAvailability createBookingAvailability(Map<String, Object> requestBody) {
		String quotaStr = (String) requestBody.get("quota");
		int quota = Integer.parseInt(quotaStr);
		String availableStr = (String) requestBody.get("available");
		int available = Integer.parseInt(availableStr);
		String bookingOptionIdStr = (String) requestBody.get("bookingOptionId");

		BookingOption bookingOption = null;
		if (bookingOptionIdStr != null) {
			UUID bookingOptionId = UUID.fromString(bookingOptionIdStr);
			bookingOption = Repository.getProxyObject(OnlineTicketing.bookingoption.core.BookingOptionComponent.class, bookingOptionId);
		}
		// to do: fix association attributes
		BookingAvailability bookingAvailability = BookingAvailabilityFactory.createBookingAvailability(
				"OnlineTicketing.bookingavailability.core.BookingAvailabilityImpl",
				quota, available, bookingOption);
		Repository.saveObject(bookingAvailability);
		return bookingAvailability;
	}

	public HashMap<String, Object> updateBookingAvailability(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		BookingAvailability bookingavailability = Repository.getObject(id);

		String quotaStr = (String) requestBody.get("quota");
		bookingavailability.setQuota(Integer.parseInt(quotaStr));
		String availableStr = (String) requestBody.get("available");
		bookingavailability.setAvailable(Integer.parseInt(availableStr));

		Repository.updateObject(bookingavailability);

		// to do: fix association attributes

		return bookingavailability.toHashMap();

	}

	public HashMap<String, Object> getBookingAvailability(Map<String, Object> requestBody) {
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "bookingavailability_impl");
		List<HashMap<String, Object>> bookingavailabilityList = getAllBookingAvailability(map);
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		for (HashMap<String, Object> bookingavailability : bookingavailabilityList) {
			UUID record_id = UUID.fromString(bookingavailability.get("record_id").toString());
			if (record_id.equals(id)) {
				return bookingavailability;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBookingAvailabilityById(UUID id) {
		BookingAvailability bookingavailability = Repository.getObject(id);
		return bookingavailability.toHashMap();
	}

	public List<HashMap<String, Object>> getAllBookingAvailability(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<BookingAvailability> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingAvailability> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public List<HashMap<String, Object>> deleteBookingAvailability(Map<String, Object> requestBody) {
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBookingAvailability(requestBody);
	}

}
