package OnlineTicketing.bookingitem.hotel;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import OnlineTicketing.bookingitem.core.BookingItemServiceDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemDecorator;
import OnlineTicketing.bookingitem.core.BookingItemServiceComponent;
import OnlineTicketing.bookingitem.BookingItemFactory;

import OnlineTicketing.bookingitem.hotel.BookingItemImpl;

import OnlineTicketing.bookingoption.core.BookingOption;

public class BookingItemServiceImpl extends BookingItemServiceDecorator {
    private BookingItemFactory bookingItemFactory = new BookingItemFactory();

    private RepositoryUtil<BookingOption> roomRepository = new RepositoryUtil<>(OnlineTicketing.bookingoption.core.BookingOption.class);

    public BookingItemServiceImpl(BookingItemServiceComponent record) {
        super(record);
    }

    public BookingItem createBookingItem(Map<String, Object> requestBody) {
        requestBody.put("bookingType", "HOTEL");
        BookingItem bookingItem = record.createBookingItem(requestBody);
        String title = (String) requestBody.get("title");
        String imageUrl = (String) requestBody.get("imageUrl");
        String location = (String) requestBody.get("location");
        String facilities = (String) requestBody.get("facilities");
        BookingItem hotel = (BookingItem) bookingItemFactory.createBookingItem(
                "OnlineTicketing.bookingitem.hotel.BookingItemImpl", bookingItem, title, imageUrl, location,
                facilities);

        bookingItemRepository.saveObject(hotel);

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
                recordBookingItemId, "HOTEL");

        BookingItemImpl hotel = (BookingItemImpl) bookingItemFactory.createBookingItem(
                "OnlineTicketing.bookingitem.hotel.BookingItemImpl", id, wrappee, title, imageUrl, location,
                facilities);

        bookingItemRepository.updateObject(wrappee);
        bookingItemRepository.updateObject(hotel);

        return hotel;
    }

    public BookingItem getBookingItem(UUID id) {
        return bookingItemRepository.getObject(id);
    }

    public List<BookingItem> getAllBookingItem() {
        List<BookingItem> list = bookingItemRepository.getAllObject("bookingitem_hotel");
        return list;
    }

    public List<HashMap<String, Object>> searchHotels(VMJExchange vmjExchange) {
        Map<String, String> params;

        try {
            params = vmjExchange.queryToMap();
        } catch (Exception e) {
            params = new HashMap<>();
        }
        
        String keyword = params.get("keyword");
        String startDate = params.get("start_date");
        String endDate = params.get("end_date");
        String roomCountStr = params.get("room_count");
        int roomCount = roomCountStr != null ? Integer.parseInt(roomCountStr) : 0;

        // Search keyword from title and location
        List<BookingItem> hotels = getAllBookingItem();
        List<BookingItem> filteredHotels = new ArrayList<>();

        for (BookingItem bookingItem : hotels) {
            BookingItemImpl hotel = (BookingItemImpl) bookingItem;
            String title = hotel.getTitle().toLowerCase();
            String location = hotel.getLocation().toLowerCase();
            if ((keyword == null || keyword.isEmpty() || title.contains(keyword.toLowerCase())
                    || location.contains(keyword.toLowerCase()))) {
                filteredHotels.add(hotel);
            }
        }

        // TODO: Implement date and room availability filtering logic

        List<HashMap<String, Object>> result = new ArrayList<>();
        for (BookingItem hotel : filteredHotels) {
            List<BookingOption> rooms = roomRepository.getListObject("bookingoption_roomoption", "bookingitem_id", hotel.getId());;
            Long startPrice = Long.MAX_VALUE;
            for (BookingOption room : rooms) {
                if (room.getPrice() < startPrice) {
                    startPrice = room.getPrice();
                }
            }
            HashMap<String, Object> hotelMap = hotel.toHashMap();
            hotelMap.put("startPrice", startPrice);
            result.add(hotelMap);
        }
        return result;
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
