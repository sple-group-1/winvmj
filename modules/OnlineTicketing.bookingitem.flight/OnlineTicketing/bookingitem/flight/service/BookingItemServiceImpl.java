package OnlineTicketing.bookingitem.flight;

import java.util.*;

import vmj.routing.route.VMJExchange;

import OnlineTicketing.bookingitem.core.BookingItemServiceDecorator;
import OnlineTicketing.bookingitem.core.BookingItemImpl;
import OnlineTicketing.bookingitem.core.BookingItemServiceComponent;

public class BookingItemServiceImpl extends BookingItemServiceDecorator {
    public BookingItemServiceImpl (BookingItemServiceComponent record) {
        super(record);
    }

    
}
