package OnlineTicketing.bookingoption.packageoption;

import java.util.*;

import vmj.routing.route.VMJExchange;

import OnlineTicketing.bookingoption.core.BookingOptionServiceDecorator;
import OnlineTicketing.bookingoption.core.BookingOptionImpl;
import OnlineTicketing.bookingoption.core.BookingOptionServiceComponent;

public class BookingOptionServiceImpl extends BookingOptionServiceDecorator {
    public BookingOptionServiceImpl (BookingOptionServiceComponent record) {
        super(record);
    }

    
}
