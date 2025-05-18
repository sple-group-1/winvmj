package OnlineTicketing.bookingoption.roomoption;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import OnlineTicketing.bookingitem.BookingItemServiceFactory;
import OnlineTicketing.bookingitem.core.BookingItemService;
import OnlineTicketing.bookingoption.BookingOptionFactory;
import OnlineTicketing.bookingoption.core.BookingOptionServiceDecorator;
import OnlineTicketing.bookingoption.core.BookingOptionServiceComponent;
import OnlineTicketing.bookingoption.core.BookingOption;
import OnlineTicketing.bookingoption.core.BookingOptionDecorator;
import OnlineTicketing.bookingoption.roomoption.BookingOptionImpl;

public class BookingOptionServiceImpl extends BookingOptionServiceDecorator {
    private BookingItemService hotelService;

    public BookingOptionServiceImpl(BookingOptionServiceComponent record) {
        super(record);
        this.hotelService = BookingItemServiceFactory.createBookingItemService(
                "OnlineTicketing.bookingitem.hotel.BookingItemServiceImpl",
                BookingItemServiceFactory.createBookingItemService(
                        "OnlineTicketing.bookingitem.core.BookingItemServiceImpl"));
    }

    public BookingOption createBookingOption(Map<String, Object> requestBody) {
        requestBody.put("bookingType", "HOTEL");
        BookingOption wrappee = record.createBookingOption(requestBody);
        UUID id = wrappee.getId();
        String roomType = (String) requestBody.get("roomType");
        BookingOption deco = BookingOptionFactory.createBookingOption(
                "OnlineTicketing.bookingoption.roomoption.BookingOptionImpl", id, wrappee, roomType);
        this.bookingOptionRepository.saveObject(deco);
        return deco;
    }

    public BookingOption updateBookingOption(Map<String, Object> requestBody) {
        record.updateBookingOption(requestBody);

        String idStr = (String) requestBody.get("id");
        UUID id = UUID.fromString(idStr);
        
        BookingOptionImpl roomOption = (BookingOptionImpl) this.bookingOptionRepository.getObject(id);
        roomOption.setRoomType((String) requestBody.get("roomType"));
        this.bookingOptionRepository.updateObject(roomOption);
        return bookingOptionRepository.getObject(id);
    }

    public BookingOption getBookingOption(UUID id) {
        BookingOption roomOption = this.bookingOptionRepository.getObject(id);
        return roomOption;
    }

    public List<BookingOption> getAllBookingOption() {
        List<BookingOption> list = bookingOptionRepository.getAllObject("bookingoption_roomoption");
        return list;
    }

    public List<BookingOption> deleteBookingOption(UUID id) {
        BookingOption roomOption = this.bookingOptionRepository.getObject(id);
        BookingOption bookingOption = ((BookingOptionDecorator) roomOption).getRecord();
        bookingOptionRepository.deleteObject(id);
        record.deleteBookingOption(bookingOption.getId());
        return getAllBookingOption();
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<BookingOption> List) {
        return record.transformListToHashMap(List);
    }

}
