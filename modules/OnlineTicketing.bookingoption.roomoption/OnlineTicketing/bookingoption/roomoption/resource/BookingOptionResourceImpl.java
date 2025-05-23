package OnlineTicketing.bookingoption.roomoption;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import OnlineTicketing.bookingoption.core.BookingOptionResourceDecorator;
import OnlineTicketing.bookingoption.core.BookingOptionResourceComponent;
import OnlineTicketing.bookingoption.core.BookingOptionServiceComponent;
import OnlineTicketing.bookingoption.core.BookingOptionService;
import OnlineTicketing.bookingoption.core.BookingOption;

import OnlineTicketing.bookingoption.roomoption.BookingOptionImpl;

public class BookingOptionResourceImpl extends BookingOptionResourceDecorator {
	private BookingOptionServiceImpl roomOptionService;

	public BookingOptionResourceImpl(BookingOptionResourceComponent recordController,
			BookingOptionServiceComponent recordService) {
		super(recordController);
		this.roomOptionService = new BookingOptionServiceImpl(recordService);
	}

	@Restriced(permission = "CreateRoomOption")
	@Route(url = "call/roomoption/save")
	public HashMap<String, Object> create(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			BookingOption result = this.roomOptionService.createBookingOption(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	@Restriced(permission = "UpdateRoomOption")
	@Route(url = "call/roomoption/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		BookingOption result = this.roomOptionService.updateBookingOption(requestBody);
		return result.toHashMap();
	}

	@Restriced(permission = "ReadRoomOption")
	@Route(url = "call/roomoption/detail")
	public HashMap<String, Object> get(VMJExchange vmjExchange) {
		String idStr = (String) vmjExchange.getGETParam("id");
		UUID id = UUID.fromString(idStr);
		BookingOption result = this.roomOptionService.getBookingOption(id);
		return result.toHashMap();
	}

	@Restriced(permission = "ReadRoomOption")
	@Route(url = "call/roomoption/list")
	public List<HashMap<String, Object>> getAll(VMJExchange vmjExchange) {
		String hotelIdStr = (String) vmjExchange.getGETParam("hotelId");
		UUID hotelId = UUID.fromString(hotelIdStr);
		List<BookingOption> result = this.roomOptionService.getListBookingOptionByHotelId(hotelId);
		return this.roomOptionService.transformListToHashMap(result);
	}

	@Restriced(permission = "DeleteRoomOption")
	@Route(url = "call/roomoption/delete")
	public List<HashMap<String, Object>> deleteBookingOption(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		String idStr = (String) vmjExchange.getGETParam("id");
		UUID id = UUID.fromString(idStr);
		List<BookingOption> result = this.roomOptionService.deleteBookingOption(id);
		return this.roomOptionService.transformListToHashMap(result);
	}

}
