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
        BookingItem bookingItem = record.createBookingItem(requestBody);
        UUID id = bookingItem.getId();
        String title = (String) requestBody.get("title");
        String imageUrl = (String) requestBody.get("imageUrl");
        String location = (String) requestBody.get("location");
        String facilities = (String) requestBody.get("facilities");
        BookingItem hotel = (BookingItem) bookingItemFactory.createBookingItem(
                "OnlineTicketing.bookingitem.hotel.BookingItemImpl", bookingItem, title, imageUrl, location,
                facilities);

        bookingItemRepository.saveObject(hotel);

        hotel = bookingItemRepository.getObject(hotel.getId());
        return hotel;
    }

    // TODO cek lagi
    public BookingItem updateBookingItem(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("id");
        UUID id = UUID.fromString(idStr);
        BookingItem bookingitem = bookingItemRepository.getObject(id);
        UUID recordBookingItemId = ((BookingItemDecorator) bookingitem).getRecord().getId();

        String title = (String) requestBody.get("title");
        String imageUrl = (String) requestBody.get("imageUrl");
        String location = (String) requestBody.get("location");
        String facilities = (String) requestBody.get("facilities");
        BookingItem wrappee = bookingItemFactory.createBookingItem("OnlineTicketing.bookingitem.core.BookingItemImpl",
                recordBookingItemId, "hotel");

        BookingItemImpl deco = (BookingItemImpl) bookingItemFactory.createBookingItem(
                "OnlineTicketing.bookingitem.hotel.BookingItemImpl", id, wrappee, title, imageUrl, location,
                facilities);

        bookingItemRepository.updateObject(wrappee);
        bookingItemRepository.updateObject(deco);

        return bookingitem;
    }

    public BookingItem getBookingItem(UUID id) {
        return bookingItemRepository.getObject(id);
    }

    public List<BookingItem> getAllBookingItem() {
        List<BookingItem> list = bookingItemRepository.getAllObject("bookingitem_hotel");
        return list;
    }

    public List<BookingItem> deleteBookingItem(UUID id) {
        BookingItem deco = bookingItemRepository.getObject(id);
        BookingItem wrappee = ((BookingItemDecorator) deco).getRecord();
        bookingItemRepository.deleteObject(id);
        record.deleteBookingItem(wrappee.getId());
        return getAllBookingItem();
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<BookingItem> List) {
        return record.transformListToHashMap(List);
    }
}
