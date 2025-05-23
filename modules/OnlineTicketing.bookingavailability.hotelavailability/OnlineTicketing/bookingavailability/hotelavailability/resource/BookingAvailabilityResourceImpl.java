package OnlineTicketing.bookingavailability.hotelavailability;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import OnlineTicketing.bookingavailability.core.BookingAvailabilityResourceDecorator;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityServiceComponent;
import OnlineTicketing.bookingavailability.core.BookingAvailability;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityImpl;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityResourceComponent;

public class BookingAvailabilityResourceImpl extends BookingAvailabilityResourceDecorator {
	private BookingAvailabilityImpl hotelAvailabilityService;

	public BookingAvailabilityResourceImpl(BookingAvailabilityResourceComponent recordController,
			BookingAvailabilityServiceComponent recordService) {
		super(recordController);
		this.hotelAvailabilityService = new BookingAvailabilityServiceImpl(recordService);
	}

	@Route(url = "call/hotelavailability/save")
	public BookingAvailability createBookingAvailability(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			BookingAvailability result = this.hotelAvailabilityService.createBookingAvailability(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotelavailability/update")
	public HashMap<String, Object> updateBookingAvailability(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		BookingAvailability result = this.hotelAvailabilityService.updateBookingAvailability(requestBody);
		return result.toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotelavailability/detail")
	public HashMap<String, Object> getBookingAvailability(VMJExchange vmjExchange) {
		BookingAvailability result = this.hotelAvailabilityService.getBookingAvailability(vmjExchange);
		return result.toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/hotelavailability/list")
	public List<HashMap<String, Object>> getAllBookingAvailability(VMJExchange vmjExchange) {
		List<BookingAvailability> result = this.hotelAvailabilityService.getAllBookingAvailability(vmjExchange);
		return this.hotelAvailabilityService.transformListToHashMap(result);
	}


	// @Restriced(permission = "")
	@Route(url = "call/hotelavailability/delete")
	public List<HashMap<String, Object>> deleteBookingAvailability(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		List<BookingAvailability> result = this.hotelAvailabilityService.deleteBookingAvailability(requestBody);
		return this.hotelAvailabilityService.transformListToHashMap(result);
	}

}
