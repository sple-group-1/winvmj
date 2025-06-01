package OnlineTicketing.bookingoption.roomoption;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

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
        String roomType = (String) requestBody.get("roomType");
        String imageUrl = (String) requestBody.get("imageUrl");
        BookingOption deco = BookingOptionFactory.createBookingOption(
                "OnlineTicketing.bookingoption.roomoption.BookingOptionImpl", wrappee, roomType, imageUrl);
        this.bookingOptionRepository.saveObject(deco);
        return deco;
    }

    public BookingOption updateBookingOption(Map<String, Object> requestBody) {
        record.updateBookingOption(requestBody);

        String idStr = (String) requestBody.get("id");
        UUID id = UUID.fromString(idStr);
        
        BookingOptionImpl roomOption = (BookingOptionImpl) this.bookingOptionRepository.getObject(id);
        roomOption.setRoomType((String) requestBody.get("roomType"));
        roomOption.setImageUrl((String) requestBody.get("imageUrl"));
        this.bookingOptionRepository.updateObject(roomOption);
        return roomOption;
    }

    public BookingOption getBookingOption(UUID id) {
        BookingOption roomOption = this.bookingOptionRepository.getObject(id);
        return roomOption;
    }

    public List<BookingOption> getAllBookingOption() {
        List<BookingOption> list = bookingOptionRepository.getAllObject("bookingoption_roomoption");
        return list;
    }

    public List<BookingOption> getListBookingOptionByHotelId(UUID hotelId) {
        List<BookingOption> list = bookingOptionRepository.getListObject("bookingoption_roomoption", "bookingitem_id", hotelId);
        return list;
    }

    public List<BookingOption> deleteBookingOption(UUID id) {
        BookingOption roomOption = this.bookingOptionRepository.getObject(id);
        BookingOption bookingOption = ((BookingOptionDecorator) roomOption).getRecord();
        bookingOptionRepository.deleteObject(id);
        record.deleteBookingOption(bookingOption.getId());
        return getAllBookingOption();
    }

    public HashMap<String, Object> getBookingFeeReview(VMJExchange vmjExchange) {
        String roomIdStr = (String) vmjExchange.getGETParam("roomId");
        String startDateStr = (String) vmjExchange.getGETParam("start_date");
        String endDateStr = (String) vmjExchange.getGETParam("end_date");
        String roomCountStr = (String) vmjExchange.getGETParam("room_count");
        UUID roomId = UUID.fromString(roomIdStr);
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        int roomCount = Integer.parseInt(roomCountStr);
        
        long duration = ChronoUnit.DAYS.between(startDate, endDate);

        BookingOption roomOption = this.bookingOptionRepository.getObject(roomId);
        Long price = roomOption.getPrice();

        Long totalPrice = price * duration * roomCount;

        Map<String, String> queryParams = vmjExchange.queryToMap();
        HashMap<String, Object> response = new HashMap<>();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            response.put(entry.getKey(), entry.getValue());
        }

        response.put("duration_days", duration);
        response.put("total_price", totalPrice); 

        return response;
    }

    public List<HashMap<String, Object>> transformListToHashMap(List<BookingOption> List) {
        return record.transformListToHashMap(List);
    }

}
