package OnlineTicketing.bookingitem.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class BookingItemResourceDecorator extends BookingItemResourceComponent{
	protected BookingItemResourceComponent record;

    public BookingItemResourceDecorator(BookingItemResourceComponent record) {
        this.record = record;
    }

    public HashMap<String, Object> createBookingItem(VMJExchange vmjExchange){
		return record.createBookingItem(vmjExchange);
	}

    public HashMap<String, Object> updateBookingItem(VMJExchange vmjExchange){
		return record.updateBookingItem(vmjExchange);
	}

    public HashMap<String, Object> getBookingItem(VMJExchange vmjExchange){
		return record.getBookingItem(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllBookingItem(VMJExchange vmjExchange){
		return record.getAllBookingItem(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteBookingItem(VMJExchange vmjExchange){
		return record.deleteBookingItem(vmjExchange);
	}

}
