package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BookingItemServiceDecorator extends BookingItemServiceComponent{
	protected BookingItemServiceComponent record;

    public BookingItemServiceDecorator(BookingItemServiceComponent record) {
        this.record = record;
    }

	public HashMap<String, Object> createBookingItem(Map<String, Object> requestBody){
		return record.createBookingItem(requestBody);
	}


	public HashMap<String, Object> getBookingItem(Map<String, Object> requestBody){
		return record.getBookingItem(requestBody);
	}

	public List<HashMap<String,Object>> getAllBookingItem(Map<String, Object> requestBody){
		return record.getAllBookingItem(requestBody);
	}

    public HashMap<String, Object> updateBookingItem(Map<String, Object> requestBody){
		return record.updateBookingItem(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BookingItem> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteBookingItem(Map<String, Object> requestBody){
		return record.deleteBookingItem(requestBody);
	}

	public HashMap<String, Object> getBookingItemById(int id){
        return record.getBookingItemById(id);
    }

}
