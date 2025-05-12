package OnlineTicketing.bookingitem.hotel;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import OnlineTicketing.bookingitem.core.BookingItemServiceDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemServiceComponent;
import OnlineTicketing.bookingitem.BookingItemFactory;

public class BookingItemServiceImpl extends BookingItemServiceDecorator {
    protected RepositoryUtil<BookingItemImpl> Repository;

    public BookingItemServiceImpl(BookingItemServiceComponent record) {
        super(record);
        this.Repository = new RepositoryUtil<BookingItemImpl>(OnlineTicketing.bookingitem.hotel.BookingItemImpl.class);
    }

    public BookingItem createBookingItem(Map<String, Object> requestBody) {
        BookingItem wrappee = record.createBookingItem(requestBody);
        String title = (String) requestBody.get("title");
        String imageUrl = (String) requestBody.get("imageUrl");
        String location = (String) requestBody.get("location");
        String facilities = (String) requestBody.get("facilities");
        BookingItemImpl deco = (BookingItemImpl) BookingItemFactory.createBookingItem(
                "OnlineTicketing.bookingitem.hotel.BookingItemImpl", wrappee, title, imageUrl, location, facilities);
        this.Repository.saveObject(deco);
        return deco;
    }

    public HashMap<String, Object> getBookingItem(Map<String, Object> requestBody) {
        UUID id = UUID.fromString(requestBody.get("id").toString());
        BookingItem deco = this.Repository.getObject(id);
        return deco.toHashMap();
    }

    public HashMap<String, Object> updateBookingItem(Map<String, Object> requestBody) {
        String idStr = (String) requestBody.get("id");
        UUID id = UUID.fromString(idStr);
        BookingItemImpl bookingitem = this.Repository.getObject(id);

        bookingitem.setBookingType((String) requestBody.get("bookingType"));
        bookingitem.setTitle((String) requestBody.get("title"));
        bookingitem.setImageUrl((String) requestBody.get("imageUrl"));
        bookingitem.setLocation((String) requestBody.get("location"));
        bookingitem.setFacilities((String) requestBody.get("facilities"));

        this.Repository.updateObject(bookingitem);
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
