package OnlineTicketing.bookingoption.roomoption;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import OnlineTicketing.bookingoption.core.BookingOptionResourceDecorator;
import OnlineTicketing.bookingoption.core.BookingOptionImpl;
import OnlineTicketing.bookingoption.core.BookingOptionResourceComponent;

public class BookingOptionResourceImpl extends BookingOptionResourceDecorator {
    public BookingOptionResourceImpl (BookingOptionResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/roomoption/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public BookingOption create(VMJExchange vmjExchange){
		String roomType = (String) vmjExchange.getRequestBodyForm("roomType");
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.roomoption.core.BookingOptionImpl", , roomType);
			return deco;
	}

    public BookingOption create(VMJExchange vmjExchange, int id){
		String roomType = (String) vmjExchange.getRequestBodyForm("roomType");
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.roomoption.core.BookingOptionImpl", id, , roomType);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/roomoption/update")
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
    @Route(url="call/roomoption/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getBookingOption(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/roomoption/list")
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
    @Route(url="call/roomoption/delete")
    public List<HashMap<String,Object>> deleteBookingOption(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
