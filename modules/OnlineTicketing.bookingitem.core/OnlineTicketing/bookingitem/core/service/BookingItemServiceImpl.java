package OnlineTicketing.bookingitem.core;

import java.util.*;

import OnlineTicketing.bookingitem.BookingItemFactory;
//add other required packages

public class BookingItemServiceImpl extends BookingItemServiceComponent {
	private BookingItemFactory bookingItemFactory = new BookingItemFactory();

	public BookingItem createBookingItem(Map<String, Object> requestBody) {
		String bookingType = (String) requestBody.get("bookingType");

		BookingItem bookingItem = bookingItemFactory.createBookingItem(
				"OnlineTicketing.bookingitem.core.BookingItemImpl", bookingType);
		bookingItemRepository.saveObject(bookingItem);
		return bookingItem;
	}

	public BookingItem updateBookingItem(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		BookingItem bookingitem = bookingItemRepository.getObject(id);

		bookingitem.setBookingType((String) requestBody.get("bookingType"));

		bookingItemRepository.updateObject(bookingitem);
		bookingitem = bookingItemRepository.getObject(id);

		return bookingitem;

	}

	public BookingItem getBookingItem(UUID id) {
		BookingItem bookingItem = bookingItemRepository.getObject(id);
		return bookingItem;
	}

	public List<BookingItem> getAllBookingItem() {
		List<BookingItem> list = bookingItemRepository.getAllObject("bookingitem_impl", BookingItemImpl.class.getName());
		return list;
	}

	public List<BookingItem> deleteBookingItem(UUID id) {
		bookingItemRepository.deleteObject(id);
		return getAllBookingItem();
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingItem> list) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < list.size(); i++) {
			resultList.add(list.get(i).toHashMap());
		}

		return resultList;
	}

}
