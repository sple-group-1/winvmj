package OnlineTicketing.bookingitem.core;

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
import OnlineTicketing.bookingitem.BookingItemFactory;
//add other required packages

public class BookingItemServiceImpl extends BookingItemServiceComponent {

	public HashMap<String, Object> createBookingItem(Map<String, Object> requestBody) {
		String bookingType = (String) requestBody.get("bookingType");

		// to do: fix association attributes
		BookingItem bookingItem = BookingItemFactory.createBookingItem(
				"OnlineTicketing.bookingitem.core.BookingItemImpl", bookingType);
		Repository.saveObject(bookingItem);
		return bookingItem.toHashMap();
	}


	public HashMap<String, Object> updateBookingItem(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		BookingItem bookingitem = Repository.getObject(id);

		bookingitem.setBookingType((String) requestBody.get("bookingType"));

		Repository.updateObject(bookingitem);

		// to do: fix association attributes

		return bookingitem.toHashMap();

	}

	public HashMap<String, Object> getBookingItem(Map<String, Object> requestBody) {
		Map<String, Object> map = new HashMap<>() {{
			put("table_name", "bookingitem_impl");
	}};
		List<HashMap<String, Object>> bookingitemList = getAllBookingItem(map);
		for (HashMap<String, Object> bookingitem : bookingitemList) {
			int record_id = ((Double) bookingitem.get("record_id")).intValue();
			if (record_id == (int) bookingitem.get("id")) {
				return bookingitem;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBookingItemById(int id) {
		// String idStr = vmjExchange.getGETParam("id");
		// int id = Integer.parseInt(idStr);
		BookingItem bookingitem = Repository.getObject(id);
		return bookingitem.toHashMap();
	}

	public List<HashMap<String, Object>> getAllBookingItem(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<BookingItem> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingItem> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public List<HashMap<String, Object>> deleteBookingItem(Map<String, Object> requestBody) {
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBookingItem(requestBody);
	}

}
