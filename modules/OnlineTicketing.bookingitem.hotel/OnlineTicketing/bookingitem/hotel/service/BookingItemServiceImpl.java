package OnlineTicketing.bookingitem.hotel;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import OnlineTicketing.bookingitem.core.BookingItemServiceDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemDecorator;
import OnlineTicketing.bookingitem.core.BookingItemServiceComponent;
import OnlineTicketing.bookingitem.BookingItemFactory;

public class BookingItemServiceImpl extends BookingItemServiceDecorator {
    private BookingItemFactory bookingItemFactory = new BookingItemFactory();

    public BookingItemServiceImpl(BookingItemServiceComponent record) {
        super(record);
    }

    public BookingItem createBookingItem(Map<String, Object> requestBody) {
        BookingItem wrappee = record.createBookingItem(requestBody);
        String title = (String) requestBody.get("title");
        String imageUrl = (String) requestBody.get("imageUrl");
        String location = (String) requestBody.get("location");
        String facilities = (String) requestBody.get("facilities");
        BookingItemImpl deco = (BookingItemImpl) bookingItemFactory.createBookingItem(
                "OnlineTicketing.bookingitem.hotel.BookingItemImpl", wrappee, title, imageUrl, location, facilities);
        Repository.saveObject(deco);
        return deco;
    }

    public HashMap<String, Object> getBookingItem(Map<String, Object> requestBody) {
        UUID id = UUID.fromString(requestBody.get("id").toString());
        BookingItem deco = Repository.getObject(id);
        return deco.toHashMap();
    }

    // TODO cek lagi
    public HashMap<String, Object> updateBookingItem(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("id");
        UUID id = UUID.fromString(idStr);
        BookingItem bookingitem = Repository.getObject(id);
        UUID recordBookingItemId = ((BookingItemDecorator) bookingitem).getRecord().getId();

        String title = (String) requestBody.get("title");
        String imageUrl = (String) requestBody.get("imageUrl");
        String location = (String) requestBody.get("location");
        String facilities = (String) requestBody.get("facilities");
        BookingItem wrappee = bookingItemFactory.createBookingItem("OnlineTicketing.bookingitem.core.BookingItemImpl",recordBookingItemId, "hotel");

        BookingItemImpl deco = (BookingItemImpl) bookingItemFactory.createBookingItem(
                "OnlineTicketing.bookingitem.hotel.BookingItemImpl", id, wrappee, title, imageUrl, location, facilities);


        Repository.updateObject(wrappee);
        Repository.updateObject(deco);

        return bookingitem.toHashMap();
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<BookingItem> List) {
        return record.transformListToHashMap(List);
    }

    public List<HashMap<String, Object>> deleteBookingItem(Map<String, Object> requestBody) {
        return record.deleteBookingItem(requestBody);
    }

    public HashMap<String, Object> getBookingItemById(int id) {
        return record.getBookingItemById(id);
    }
}
