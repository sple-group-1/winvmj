package OnlineTicketing.bookingitem.event;
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
    @Route(url="call/event/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public BookingItem create(VMJExchange vmjExchange){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		String location = (String) vmjExchange.getRequestBodyForm("location");
		String description = (String) vmjExchange.getRequestBodyForm("description");
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.event.core.BookingItemImpl", , title, location, imageUrls, facilities, description, packageOptions);
			return deco;
	}

    public BookingItem create(VMJExchange vmjExchange, int id){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		String location = (String) vmjExchange.getRequestBodyForm("location");
		String description = (String) vmjExchange.getRequestBodyForm("description");
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.event.core.BookingItemImpl", id, , title, location, imageUrls, facilities, description, packageOptions);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/event/update")
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
    @Route(url="call/event/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getBookingItem(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/event/list")
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
    @Route(url="call/event/delete")
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
