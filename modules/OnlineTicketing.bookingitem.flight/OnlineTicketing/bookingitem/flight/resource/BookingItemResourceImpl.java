package OnlineTicketing.bookingitem.flight;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import OnlineTicketing.bookingitem.core.BookingItemResourceDecorator;
import OnlineTicketing.bookingitem.core.BookingItemImpl;
import OnlineTicketing.bookingitem.core.BookingItemResourceComponent;

public class BookingItemResourceImpl extends BookingItemResourceDecorator {
    public BookingItemResourceImpl (BookingItemResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/flight/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public BookingItem create(VMJExchange vmjExchange){
		String departureLocation = (String) vmjExchange.getRequestBodyForm("departureLocation");
		String arrivalLocation = (String) vmjExchange.getRequestBodyForm("arrivalLocation");
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.flight.core.BookingItemImpl", , departureLocation, arrivalLocation, departureTime, arrivalTime, price, , bookingavailbilityimpl);
			return deco;
	}

    public BookingItem create(VMJExchange vmjExchange, int id){
		String departureLocation = (String) vmjExchange.getRequestBodyForm("departureLocation");
		String arrivalLocation = (String) vmjExchange.getRequestBodyForm("arrivalLocation");
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.flight.core.BookingItemImpl", id, , departureLocation, arrivalLocation, departureTime, arrivalTime, price, , bookingavailbilityimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/flight/update")
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
    @Route(url="call/flight/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getBookingItem(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/flight/list")
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
    @Route(url="call/flight/delete")
    public List<HashMap<String,Object>> deleteBookingItem(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
