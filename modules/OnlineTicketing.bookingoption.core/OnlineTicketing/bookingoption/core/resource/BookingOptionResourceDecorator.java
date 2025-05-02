package OnlineTicketing.bookingoption.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class BookingOptionResourceDecorator extends BookingOptionResourceComponent{
	protected BookingOptionResourceComponent record;

    public BookingOptionResourceDecorator(BookingOptionResourceComponent record) {
        this.record = record;
    }

    public BookingOption createBookingOption(VMJExchange vmjExchange){
		return record.createBookingOption(vmjExchange);
	}

    public HashMap<String, Object> updateBookingOption(VMJExchange vmjExchange){
		return record.updateBookingOption(vmjExchange);
	}

    public HashMap<String, Object> getBookingOption(VMJExchange vmjExchange){
		return record.getBookingOption(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllBookingOption(VMJExchange vmjExchange){
		return record.getAllBookingOption(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteBookingOption(VMJExchange vmjExchange){
		return record.deleteBookingOption(vmjExchange);
	}

}
