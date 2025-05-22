package OnlineTicketing.bookingavailability.dailyavailability;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import OnlineTicketing.bookingavailability.core.BookingAvailabilityResourceDecorator;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityImpl;
import OnlineTicketing.bookingavailability.core.BookingAvailabilityResourceComponent;

public class BookingAvailabilityResourceImpl extends BookingAvailabilityResourceDecorator {
    public BookingAvailabilityResourceImpl (BookingAvailabilityResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/dailyavailability/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public BookingAvailability create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.dailyavailability.core.BookingAvailabilityImpl", , date, , bookingoptionimpl, bookingoptionimpl);
			return deco;
	}

    public BookingAvailability create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.dailyavailability.core.BookingAvailabilityImpl", id, , date, , bookingoptionimpl, bookingoptionimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/dailyavailability/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		 = create(vmjExchange, id);
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/dailyavailability/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getBookingAvailability(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/dailyavailability/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/dailyavailability/delete")
    public List<HashMap<String,Object>> deleteBookingAvailability(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
