package OnlineTicketing.bookingoption.packageoption;

import java.util.*;

import OnlineTicketing.bookingitem.BookingItemServiceFactory;
import OnlineTicketing.bookingitem.core.*;
import OnlineTicketing.bookingoption.core.*;
import OnlineTicketing.bookingitem.event.BookingItemServiceImpl;
import OnlineTicketing.bookingoption.BookingOptionFactory;

public class BookingOptionServiceImpl extends BookingOptionServiceDecorator {
    private BookingOptionFactory bookingOptionFactory = new BookingOptionFactory();
    private BookingItemService eventService;

    public BookingOptionServiceImpl (BookingOptionServiceComponent record) {
        super(record);
        this.eventService = BookingItemServiceFactory.createBookingItemService(
            "OnlineTicketing.bookingitem.event.BookingItemServiceImpl", 
            BookingItemServiceFactory.createBookingItemService(
                "OnlineTicketing.bookingitem.core.BookingItemServiceImpl"
        ));
    }

	public BookingOption createBookingOption(Map<String, Object> requestBody) {
		String priceStr = (String) requestBody.get("price");
		Long price = Long.valueOf(priceStr);
        String packageName = (String) requestBody.get("packageName");
		String eventIdStr = (String) requestBody.get("eventId");
		UUID eventId = UUID.fromString(eventIdStr);
        BookingItem event = ((BookingItemServiceImpl) eventService).getBookingItem(eventId);

		BookingItem bookingItem = null;

		BookingOption bookingOption = bookingOptionFactory.createBookingOption(
			"OnlineTicketing.bookingoption.core.BookingOptionImpl", price, "event", bookingItem);

        BookingOption packageOption = bookingOptionFactory.createBookingOption(
			"OnlineTicketing.bookingoption.packageoption.BookingOptionImpl", bookingOption, packageName, event);
		bookingOptionRepository.saveObject(bookingOption);
		bookingOptionRepository.saveObject(packageOption);

		return packageOption;
	}

	public BookingOption updateBookingOption(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);

		String priceStr = (String) requestBody.get("price");
		Long price = Long.valueOf(priceStr);
        String packageName = (String) requestBody.get("packageName");
		String eventIdStr = (String) requestBody.get("eventId");
		UUID eventId = UUID.fromString(eventIdStr);
        BookingItem event = ((BookingItemServiceImpl) eventService).getBookingItem(eventId);

		BookingItem bookingItem = null;

		BookingOption savedBookingOption = bookingOptionRepository.getObject(id);
		UUID recordBookingOptionId = (((BookingOptionDecorator) savedBookingOption).getRecord()).getId();

		BookingOption bookingOption = bookingOptionFactory.createBookingOption(
			"OnlineTicketing.bookingoption.core.BookingOptionImpl", recordBookingOptionId, price, "event", bookingItem);

        BookingOption packageOption = bookingOptionFactory.createBookingOption(
			"OnlineTicketing.bookingoption.packageoption.BookingOptionImpl", id, bookingOption, packageName, event);

		bookingOptionRepository.updateObject(bookingOption);
		bookingOptionRepository.updateObject(packageOption);
		packageOption = bookingOptionRepository.getObject(id);

		return packageOption;

	}

	public BookingOption getBookingOption(UUID id) {
		return record.getBookingOption(id);
	}

	public List<BookingOption> getAllBookingOption() {
		List<BookingOption> list = bookingOptionRepository.getAllObject("bookingoption_packageoption");
		return list;
	}

	public List<BookingOption> filterCapaian(String columnName, UUID id) {
		List<BookingOption> bookingOption = bookingOptionRepository.getListObject("bookingoption_packageoption", columnName, id);
		return bookingOption;
	}

	public List<BookingOption> deleteBookingOption(UUID id) {
		bookingOptionRepository.deleteObject(id);
		return getAllBookingOption();
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingOption> list) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			resultList.add(list.get(i).toHashMap());
		}

		return resultList;
	}
    
}
