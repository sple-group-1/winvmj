package OnlineTicketing.bookingoption.roomoption;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import OnlineTicketing.bookingoption.core.BookingOptionResourceDecorator;
import OnlineTicketing.bookingoption.core.BookingOptionResourceComponent;
import OnlineTicketing.bookingoption.core.BookingOption;


import OnlineTicketing.bookingoption.roomoption.BookingOptionImpl;

public class BookingOptionResourceImpl extends BookingOptionResourceDecorator {

	private BookingOptionServiceImpl roomOptionService;

	public BookingOptionResourceImpl(BookingOptionResourceComponent record) {
		super(record);
		this.roomOptionService = new BookingOptionServiceImpl(
				new OnlineTicketing.bookingoption.core.BookingOptionServiceImpl());
	}

	// @Restriced(permission = "")
	// @Route(url="call/roomoption/save")
	// public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
	// if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// return null;
	// }
	// = create(vmjExchange);
	// Repository.saveObject();
	// return getAll(vmjExchange);
	// }

	@Route(url = "call/roomoption/save")
	public HashMap<String, Object> create(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("POST")) {
			Map<String, Object> requestBody = vmjExchange.getPayload();
			BookingOption result = this.roomOptionService.createBookingOption(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// public BookingOption create(VMJExchange vmjExchange, int id){
	// String roomType = (String) vmjExchange.getRequestBodyForm("roomType");
	// = Repository.getObject(id);
	// int recordId = (((Decorator) saved.getRecord()).getId();

	// = record.create(vmjExchange);
	// deco = Factory.create("OnlineTicketing.roomoption.core.BookingOptionImpl",
	// id, , roomType);
	// return deco;
	// }

	// @Restriced(permission = "")
	@Route(url = "call/roomoption/update")
	public HashMap<String, Object> update(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return this.roomOptionService.updateBookingOption(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
	@Route(url = "call/roomoption/detail")
	public HashMap<String, Object> get(VMJExchange vmjExchange) {
		return this.roomOptionService.getBookingOption(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
	@Route(url = "call/roomoption/list")
	public List<HashMap<String, Object>> getAll(VMJExchange vmjExchange) {
		return this.roomOptionService.getAllBookingOption(vmjExchange.getPayload());
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<BookingOptionImpl> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	// @Restriced(permission = "")
	@Route(url = "call/roomoption/delete")
	public List<HashMap<String, Object>> deleteBookingOption(VMJExchange vmjExchange) {
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}

		return this.roomOptionService.deleteBookingOption(vmjExchange.getPayload());
	}

}
