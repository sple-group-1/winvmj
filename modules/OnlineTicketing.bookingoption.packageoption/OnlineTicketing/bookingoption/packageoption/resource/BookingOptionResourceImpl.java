package OnlineTicketing.bookingoption.packageoption;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;

import OnlineTicketing.bookingoption.core.*;

public class BookingOptionResourceImpl extends BookingOptionResourceDecorator {
	private BookingOptionService bookingOptionService;

    public BookingOptionResourceImpl (BookingOptionResourceComponent recordController, BookingOptionServiceComponent recordService) {
        super(recordController);
		this.bookingOptionService = new BookingOptionServiceImpl(recordService);
    }

  	@Restricted(permissionName = "CreatePackage")
  	@Route(url="call/package/save")
    public HashMap<String,Object> createBookingOption(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			BookingOption result = bookingOptionService.createBookingOption(requestBody);
			return result.toHashMap();
		}
		return null;
	}

    @Restricted(permissionName = "UpdatePackage")
    @Route(url="call/package/update")
    public HashMap<String, Object> updateBookingOption(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		BookingOption result = bookingOptionService.updateBookingOption(requestBody);
		return result.toHashMap();
		
	}

  	@Restricted(permissionName = "ReadPackage")
    @Route(url="call/package/detail")
    public HashMap<String, Object> getBookingOption(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("packageId");
		if(idStr == null) {
		throw new IllegalArgumentException("Invalid UUID");
		}
		UUID id = UUID.fromString(idStr);

		BookingOption result = bookingOptionService.getBookingOption(id);
		return result.toHashMap();
	}

  	@Restricted(permissionName = "ReadPackage")
    @Route(url="call/package/list")
    public List<HashMap<String,Object>> getAllBookingOption(VMJExchange vmjExchange){
		List<BookingOption> result = bookingOptionService.getAllBookingOption();
		return bookingOptionService.transformListToHashMap(result);
	}

	@Restricted(permissionName = "ReadPackage")
  	@Route(url = "call/package/filter")
  	public List<HashMap<String, Object>> filterBookingOption(VMJExchange vmjExchange) {
		String by = (String) vmjExchange.getGETParam("by");

		if (by.equals("event")) {
		String idStr = (String) vmjExchange.getGETParam(by + "Id");
		if(idStr == null) {
			throw new IllegalArgumentException("Invalid UUID");
		}

		UUID id = UUID.fromString(idStr);

		String columnName = by.toLowerCase() + "_id";

		List<BookingOption> bookingOptionList = ((BookingOptionServiceImpl) bookingOptionService).filterCapaian(columnName, id);
		return bookingOptionService.transformListToHashMap(bookingOptionList);
		}

		return new ArrayList<>();
	}

  	@Restricted(permissionName = "DeletePackage")
    @Route(url="call/package/delete")
    public List<HashMap<String,Object>> deleteBookingOption(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		String idStr = (String) vmjExchange.getRequestBodyForm("id");
    	UUID id = UUID.fromString(idStr);
		
		List<BookingOption> result = bookingOptionService.deleteBookingOption(id);
		return bookingOptionService.transformListToHashMap(result);
	}

}
