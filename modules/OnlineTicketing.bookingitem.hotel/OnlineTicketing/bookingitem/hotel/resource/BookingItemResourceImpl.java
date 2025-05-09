package OnlineTicketing.bookingitem.hotel;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import OnlineTicketing.bookingitem.core.BookingItemResourceDecorator;
import OnlineTicketing.bookingitem.core.BookingItem;
import OnlineTicketing.bookingitem.core.BookingItemComponent;
import OnlineTicketing.bookingitem.core.BookingItemResourceComponent;
import OnlineTicketing.bookingitem.hotel.BookingItemImpl;
import OnlineTicketing.bookingitem.hotel.BookingItemServiceImpl;

public class BookingItemResourceImpl extends BookingItemResourceDecorator {

	private BookingItemServiceImpl hotelService;

	public BookingItemResourceImpl(BookingItemResourceComponent record) {
		super(record);
		this.hotelService = new BookingItemServiceImpl(new OnlineTicketing.bookingitem.core.BookingItemServiceImpl());
	}

	@Route(url = "call/hotel/save")
	public HashMap<String, Object> createBookingItem(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			BookingItem result = this.hotelService.createBookingItem(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// public BookingItem create(VMJExchange vmjExchange, int id){
	// String title = (String) vmjExchange.getRequestBodyForm("title");
	// String imageUrl = (String) vmjExchange.getRequestBodyForm("imageUrl");
	// String location = (String) vmjExchange.getRequestBodyForm("location");
	// = Repository.getObject(id);
	// int recordId = (((Decorator) saved.getRecord()).getId();

	// = record.create(vmjExchange);
	// deco = Factory.create("OnlineTicketing.hotel.core.BookingItemImpl", id, ,
	// title, imageUrl, location, facilities);
	// return deco;
	// }

	// @Restriced(permission = "")
	@Route(url = "call/hotel/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return this.hotelService.updateBookingItem(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotel/detail")
	public HashMap<String, Object> get(VMJExchange vmjExchange) {
		return this.hotelService.getBookingItem(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotel/list")
	public List<HashMap<String, Object>> getAll(VMJExchange vmjExchange) {
		return this.hotelService.getAllBookingItem(vmjExchange.getPayload());
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingItemImpl> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotel/delete")
	public List<HashMap<String, Object>> deleteBookingItem(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		return this.hotelService.deleteBookingItem(vmjExchange.getPayload());
	}

}
