package OnlineTicketing.bookingavailability.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
// import OnlineTicketing.bookingavailability.BookingAvailabilityFactory;
// import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BookingAvailabilityResourceImpl extends BookingAvailabilityResourceComponent {

	private BookingAvailabilityServiceImpl service = new BookingAvailabilityServiceImpl();


	// @Restriced(permission = "")
	@Route(url = "call/bookingavailability/save")
	public HashMap<String, Object> createBookingAvailability(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			BookingAvailability result = service.createBookingAvailability(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
	@Route(url = "call/bookingavailability/update")
	public HashMap<String, Object> updateBookingAvailability(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BookingAvailability result = service.updateBookingAvailability(requestBody);
		return result.toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/bookingavailability/detail")
	public HashMap<String, Object> getBookingAvailability(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		BookingAvailability result = service.getBookingAvailability(requestBody);
		return result.toHashMap();
	}

	// @Restriced(permission = "")
	@Route(url = "call/bookingavailability/list")
	public List<HashMap<String, Object>> getAllBookingAvailability(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		List<BookingAvailability> results = service.getAllBookingAvailability(requestBody);
		return service.transformListToHashMap(results);
	}

	// @Restriced(permission = "")
	@Route(url = "call/bookingavailability/delete")
	public List<HashMap<String, Object>> deleteBookingAvailability(VMJExchange vmjExchange) {
		Map<String, Object> requestBody = vmjExchange.getPayload();
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		List<BookingAvailability> results = service.deleteBookingAvailability(requestBody);
		return service.transformListToHashMap(results);
	}

}
