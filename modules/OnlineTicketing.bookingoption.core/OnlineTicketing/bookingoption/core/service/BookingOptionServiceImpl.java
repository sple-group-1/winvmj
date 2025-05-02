package OnlineTicketing.bookingoption.core;

import java.util.*;
import java.util.logging.Logger;

import OnlineTicketing.bookingoption.BookingOptionFactory;
import OnlineTicketing.bookingitem.core.*;
//add other required packages

public class BookingOptionServiceImpl extends BookingOptionServiceComponent{
	private BookingOptionFactory bookingOptionFactory = new BookingOptionFactory();

    // public List<HashMap<String,Object>> saveBookingOption(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	BookingOption bookingoption = createBookingOption(vmjExchange);
	// 	bookingoptionRepository.saveObject(bookingoption);
	// 	return getAllBookingOption(vmjExchange);
	// }

    public BookingOption createBookingOption(Map<String, Object> requestBody){
		String bookingType = (String) requestBody.get("bookingType");
		String priceStr = (String) requestBody.get("price");
		Long price = Long.valueOf(priceStr);
		String bookingItemIdStr = (String) requestBody.get("bookingItemId");

		BookingItem bookingItem = null;
		if (bookingItemIdStr != null) {
			UUID bookingItemId = UUID.fromString(bookingItemIdStr);
			bookingItem = bookingOptionRepository.getProxyObject(OnlineTicketing.bookingitem.core.BookingItemComponent.class, bookingItemId);
		}

		//to do: fix association attributes
		BookingOption bookingOption = bookingOptionFactory.createBookingOption(
			"OnlineTicketing.bookingoption.core.BookingOptionImpl",
		 price
		, bookingType
		, bookingItem
		);
		bookingOptionRepository.saveObject(bookingOption);

		return bookingOption;
	}

    // public BookingOption createBookingOption(Map<String, Object> requestBody, int id){
	// 	String bookingType = (String) vmjExchange.getRequestBodyForm("bookingType");
		
	// 	//to do: fix association attributes
		
	// 	BookingOption bookingoption = BookingOptionFactory.createBookingOption("OnlineTicketing.bookingoption.core.BookingOptionImpl", price, bookingType, bookingitemimpl);
	// 	return bookingoption;
	// }

    public HashMap<String, Object> updateBookingOption(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		// int id = Integer.parseInt(idStr);
		UUID id = UUID.fromString(idStr);

		BookingOption bookingoption = bookingOptionRepository.getObject(id);
		
		bookingoption.setBookingType((String) requestBody.get("bookingType"));
		
		bookingOptionRepository.updateObject(bookingoption);
		
		//to do: fix association attributes
		
		return bookingoption.toHashMap();
		
	}

    public HashMap<String, Object> getBookingOption(Map<String, Object> requestBody){
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "bookingoption_impl");
		List<HashMap<String, Object>> bookingoptionList = getAllBookingOption(map);
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		for (HashMap<String, Object> bookingoption : bookingoptionList){
			// int record_id = ((Double) bookingoption.get("record_id")).intValue();
			// if (record_id == id){
			// 	return bookingoption;
			// }
			UUID record_id = UUID.fromString(bookingoption.get("record_id").toString());
			if (record_id.equals(id)){
				return bookingoption;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBookingOptionById(UUID id){
		BookingOption bookingoption = bookingOptionRepository.getObject(id);
		return bookingoption.toHashMap();
	}

    public List<HashMap<String,Object>> getAllBookingOption(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<BookingOption> List = bookingOptionRepository.getAllObject(table);
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
		// int id = Integer.parseInt(idStr);
		UUID id = UUID.fromString(idStr);
		bookingOptionRepository.deleteObject(id);
		return getAllBookingOption(requestBody);
	}

}
