package OnlineTicketing.bookingoption.core;

import java.util.*;
import java.util.logging.Logger;

import OnlineTicketing.bookingoption.BookingOptionFactory;
import OnlineTicketing.bookingitem.core.*;
//add other required packages

public class BookingOptionServiceImpl extends BookingOptionServiceComponent{
	private BookingOptionFactory bookingOptionFactory = new BookingOptionFactory();

	public BookingOption createBookingOption(Map<String, Object> requestBody) {
		String bookingType = (String) requestBody.get("bookingType");
		String priceStr = (String) requestBody.get("price");
		Long price = Long.valueOf(priceStr);
		String bookingItemIdStr = (String) requestBody.get("bookingItemId");

		BookingItem bookingItem = null;
		if (bookingItemIdStr != null) {
			UUID bookingItemId = UUID.fromString(bookingItemIdStr);
			bookingItem = bookingOptionRepository.getProxyObject(OnlineTicketing.bookingitem.core.BookingItemComponent.class, bookingItemId);
		}

		BookingOption bookingOption = bookingOptionFactory.createBookingOption(
			"OnlineTicketing.bookingoption.core.BookingOptionImpl", price, bookingType, bookingItem);
		bookingOptionRepository.saveObject(bookingOption);

		return bookingOption;
	}

	public BookingOption updateBookingOption(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		String priceStr = (String) requestBody.get("price");
		Long price = Long.valueOf(priceStr);
		String bookingItemIdStr = (String) requestBody.get("bookingItemId");

		BookingOption bookingOption = bookingOptionRepository.getObject(id);

		BookingItem bookingItem = null;
		if (bookingItemIdStr != null) {
			UUID bookingItemId = UUID.fromString(bookingItemIdStr);
			bookingItem = bookingOptionRepository.getProxyObject(OnlineTicketing.bookingitem.core.BookingItemComponent.class, bookingItemId);
		}

		bookingOption.setBookingType((String) requestBody.get("bookingType"));
		bookingOption.setPrice(price);
		bookingOption.setBookingItem(bookingItem);

		bookingOptionRepository.updateObject(bookingOption);
		bookingOption = bookingOptionRepository.getObject(id);

		return bookingOption;

	}

	public BookingOption getBookingOption(UUID id) {
		BookingOption bookingOption = bookingOptionRepository.getObject(id);
		return bookingOption;
	}

	public List<BookingOption> getAllBookingOption() {
		List<BookingOption> list = bookingOptionRepository.getAllObject("bookingoption_impl", BookingOptionImpl.class.getName());
		return list;
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
