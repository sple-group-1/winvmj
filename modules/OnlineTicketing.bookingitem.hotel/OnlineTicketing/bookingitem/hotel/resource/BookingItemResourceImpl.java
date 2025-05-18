package OnlineTicketing.bookingitem.hotel;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import OnlineTicketing.bookingitem.core.BookingItemResourceDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemComponent;
import OnlineTicketing.bookingitem.core.BookingItemResourceComponent;
import OnlineTicketing.bookingitem.core.BookingItemService;
import OnlineTicketing.bookingitem.core.BookingItemServiceComponent;
import OnlineTicketing.bookingitem.hotel.BookingItemImpl;
import OnlineTicketing.bookingitem.hotel.BookingItemServiceImpl;

public class BookingItemResourceImpl extends BookingItemResourceDecorator {
	private BookingItemService bookingItemService;

	public BookingItemResourceImpl(BookingItemResourceComponent recordController,
			BookingItemServiceComponent recordService) {
		super(recordController);
		this.bookingItemService = new BookingItemServiceImpl(recordService);
	}

	@Route(url = "call/hotel/save")
	public HashMap<String, Object> createBookingItem(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			BookingItem hotel = bookingItemService.createBookingItem(requestBody);
			return hotel.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotel/update")
	public HashMap<String, Object> updateBookingItem(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		BookingItem hotel = bookingItemService.updateBookingItem(requestBody);
		return hotel.toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotel/detail")
	public HashMap<String, Object> getBookingItem(VMJExchange vmjExchange) {
		String idStr = vmjExchange.getGETParam("id");
		UUID id = UUID.fromString(idStr);
		BookingItem hotel = bookingItemService.getBookingItem(id);
		return hotel.toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotel/list")
	public List<HashMap<String, Object>> getAllBookingItem(VMJExchange vmjExchange) {
		List<BookingItem> result = this.bookingItemService.getAllBookingItem();
		return bookingItemService.transformListToHashMap(result);
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotel/delete")
	public List<HashMap<String, Object>> deleteBookingItem(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = vmjExchange.getGETParam("id");
		UUID id = UUID.fromString(idStr);
		List<BookingItem> result = this.bookingItemService.deleteBookingItem(id);
		return bookingItemService.transformListToHashMap(result);
	}

}
