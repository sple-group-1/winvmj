package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BookingOptionServiceDecorator extends BookingOptionServiceComponent{
	protected BookingOptionServiceComponent record;

    public BookingOptionServiceDecorator(BookingOptionServiceComponent record) {
        this.record = record;
    }

	public BookingOption createBookingOption(Map<String, Object> requestBody){
		return record.createBookingOption(requestBody);
	}

    // public BookingOption createBookingOption(Map<String, Object> requestBody, Map<String, Object> response){
	// 	return record.createBookingOption(requestBody, response);
	// }

	public HashMap<String, Object> getBookingOption(Map<String, Object> requestBody){
		return record.getBookingOption(requestBody);
	}

	public List<HashMap<String,Object>> getAllBookingOption(Map<String, Object> requestBody){
		return record.getAllBookingOption(requestBody);
	}

    // public List<HashMap<String,Object>> saveBookingOption(VMJExchange vmjExchange){
	// 	return record.saveBookingOption(vmjExchange);
	// }

	// public List<HashMap<String,Object>> saveBookingOption(Map<String, Object> requestBody){
	// 	return record.saveBookingOption(requestBody);
	// }

    public HashMap<String, Object> updateBookingOption(Map<String, Object> requestBody){
		return record.updateBookingOption(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BookingOption> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteBookingOption(Map<String, Object> requestBody){
		return record.deleteBookingOption(requestBody);
	}

	public HashMap<String, Object> getBookingOptionById(UUID id){
        return record.getBookingOptionById(id);
    }

}
