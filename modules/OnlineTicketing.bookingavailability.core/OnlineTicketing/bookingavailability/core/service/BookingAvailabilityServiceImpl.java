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
import OnlineTicketing.bookingoption.BookingOptionServiceFactory;
// import prices.auth.vmj.annotations.Restricted;
//add other required packages
import OnlineTicketing.bookingoption.core.BookingOption;
import OnlineTicketing.bookingoption.core.BookingOptionService;

public class BookingAvailabilityServiceImpl extends BookingAvailabilityServiceComponent {
	private BookingOptionService bookingOptionService = BookingOptionServiceFactory
			.createBookingOptionService("OnlineTicketing.bookingoption.core.BookingOptionServiceImpl");

	public BookingAvailability createBookingAvailability(Map<String, Object> requestBody) {
		String quotaStr = (String) requestBody.get("quota");
		int quota = Integer.parseInt(quotaStr);
		String availableStr = (String) requestBody.get("available");
		int available = Integer.parseInt(availableStr);
		String bookingOptionIdStr = (String) requestBody.get("bookingOptionId");

		BookingOption bookingOption = null;
		if (bookingOptionIdStr != null) {
			UUID bookingOptionId = UUID.fromString(bookingOptionIdStr);
			bookingOption = bookingOptionService.getBookingOption(bookingOptionId);
		}
		BookingAvailability bookingAvailability = BookingAvailabilityFactory.createBookingAvailability(
				"OnlineTicketing.bookingavailability.core.BookingAvailabilityImpl",
				quota, available, bookingOption);
		Repository.saveObject(bookingAvailability);
		return bookingAvailability;
	}

	public BookingAvailability updateBookingAvailability(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		BookingAvailability bookingavailability = Repository.getObject(id);

		String quotaStr = (String) requestBody.get("quota");
		bookingavailability.setQuota(Integer.parseInt(quotaStr));
		String availableStr = (String) requestBody.get("available");
		bookingavailability.setAvailable(Integer.parseInt(availableStr));

		Repository.updateObject(bookingavailability);

		return bookingavailability;
	}

	public BookingAvailability getBookingAvailability(Map<String, Object> requestBody) {
		String bookingOptionIdStr = (String) requestBody.get("bookingOptionId");
		UUID bookingOptionId = UUID.fromString(bookingOptionIdStr);
		List<BookingAvailability> results = Repository.getListObject("bookingavailability_comp", "bookingoption_id", bookingOptionId);
		if (results.size() > 0) {
			return results.get(0);
		} else {
			return null;
		}
	}


	public List<BookingAvailability> getAllBookingAvailability(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<BookingAvailability> results = Repository.getAllObject(table);
		return results;
	}

	public List<BookingAvailability> deleteBookingAvailability(Map<String, Object> requestBody) {
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBookingAvailability(requestBody);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingAvailability> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

}
