package OnlineTicketing.bookingavailability.hotelavailability;

import java.util.*;

import vmj.routing.route.VMJExchange;

import OnlineTicketing.bookingavailability.core.BookingAvailabilityServiceDecorator;
import OnlineTicketing.bookingavailability.BookingAvailabilityFactory;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityDecorator;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityImpl;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityServiceComponent;
import java.time.LocalDate;

public class BookingAvailabilityServiceImpl extends BookingAvailabilityServiceDecorator {
    public BookingAvailabilityServiceImpl(BookingAvailabilityServiceComponent record) {
        super(record);
    }

    public BookingAvailability createBookingAvailability(Map<String, Object> requestBody) {
        String dateStr = (String) requestBody.get("date");
        LocalDate date = new LocalDate(dateStr);

        BookingAvailability wrappee = record.createBookingAvailability(requestBody);
        BookingAvailability bookingAvailability = new BookingAvailabilityImpl(wrappee, date);

        Repository.saveObject(bookingAvailability);

        return bookingAvailability;
    };

    public BookingAvailability updateBookingAvailability(Map<String, Object> requestBody) {
        record.updateBookingAvailability(requestBody);

        String idStr = (String) requestBody.get("id");
        UUID id = UUID.fromString(idStr);
        String dateStr = (String) requestBody.get("date");
        LocalDate date = new LocalDate(dateStr);

        BookingAvailabilityImpl hotelAvailability = Repository.getObject(id);

        hotelAvailability.setDate(date);

        Repository.updateObject(hotelAvailability);

        return hotelAvailability;
    };

    public List<BookingAvailability> deleteBookingAvailability(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("id");
        UUID id = UUID.fromString(idStr);

        BookingAvailability hotelAvailability = Repository.getObject(id);
        BookingAvailability bookingAvailability = ((BookingAvailabilityDecorator) hotelAvailability).getRecord();

        Repository.deleteObject(bookingAvailability);

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        return record.deleteBookingAvailability(map);
    };
}
