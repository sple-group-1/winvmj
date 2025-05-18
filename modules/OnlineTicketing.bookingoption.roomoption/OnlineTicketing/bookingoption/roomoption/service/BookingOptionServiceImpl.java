package OnlineTicketing.bookingoption.roomoption;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import OnlineTicketing.bookingoption.core.BookingOptionServiceDecorator;
import OnlineTicketing.bookingoption.core.BookingOptionServiceComponent;
import OnlineTicketing.bookingoption.core.BookingOption;

import OnlineTicketing.bookingoption.roomoption.BookingOptionImpl;
import OnlineTicketing.bookingoption.BookingOptionFactory;

public class BookingOptionServiceImpl extends BookingOptionServiceDecorator {
    protected RepositoryUtil<BookingOptionImpl> Repository;

    public BookingOptionServiceImpl(BookingOptionServiceComponent record) {
        super(record);
        this.Repository = new RepositoryUtil<BookingOptionImpl>(
                OnlineTicketing.bookingoption.roomoption.BookingOptionImpl.class);
    }

    public BookingOption createBookingOption(Map<String, Object> requestBody) {
        BookingOption wrappee = record.createBookingOption(requestBody);
        String roomType = (String) requestBody.get("roomType");
        BookingOptionImpl deco = (BookingOptionImpl) BookingOptionFactory.createBookingOption(
                "OnlineTicketing.bookingoption.roomoption", wrappee, roomType);
        this.Repository.saveObject(deco);
        return deco;
    }

    public HashMap<String, Object> getBookingOption(Map<String, Object> requestBody) {
        UUID id = UUID.fromString(requestBody.get("id").toString());
        BookingOption deco = this.Repository.getObject(id);
        return deco.toHashMap();
    }

    public HashMap<String, Object> updateBookingOption(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("id");
        UUID id = UUID.fromString(idStr);
        BookingOptionImpl bookingoption = this.Repository.getObject(id);

        bookingoption.setBookingType((String) requestBody.get("bookingType"));
        bookingoption.setRoomType((String) requestBody.get("roomType"));

        this.Repository.updateObject(bookingoption);
        return bookingoption.toHashMap();
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<BookingOption> List) {
        return record.transformListToHashMap(List);
    }

    public List<HashMap<String, Object>> deleteBookingOption(Map<String, Object> requestBody) {
        return record.deleteBookingOption(requestBody);
    }

}
