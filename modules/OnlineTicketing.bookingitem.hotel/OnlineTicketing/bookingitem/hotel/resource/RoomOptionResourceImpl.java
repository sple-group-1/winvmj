package OnlineTicketing.bookingitem.hotel;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import OnlineTicketing.hotel.RoomOptionFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class RoomOptionResourceImpl extends RoomOptionResourceComponent{
	protected RoomOptionResourceComponent record;

	// @Restriced(permission = "")
    @Route(url="call/hotel/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		RoomOption roomoption = createRoomOption(vmjExchange);
		roomoptionRepository.saveObject(roomoption);
		return getAllRoomOption(vmjExchange);
	}

    public  create(VMJExchange vmjExchange){
		String name = (String) vmjExchange.getRequestBodyForm("name");
		
		//to do: fix association attributes
		
		RoomOption roomoption = RoomOptionFactory.createRoomOption("OnlineTicketing.hotel.core.RoomOptionImpl", id, name, price, bookingavailabilityimpl);
			return roomoption;
	}

    // @Restriced(permission = "")
    @Route(url="call/hotel/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		RoomOption roomoption = roomoptionRepository.getObject(id);
		roomoption.setName((String) vmjExchange.getRequestBodyForm("name"));
		
		roomoptionRepository.updateObject(roomoption);
		roomoption = roomoptionRepository.getObject(id);
		//to do: fix association attributes
		
		return roomoption.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/hotel/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		RoomOption roomoption = roomoptionRepository.getObject(id);
		return roomoption.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/hotel/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<RoomOption> roomoptionList = roomoptionRepository.getAllObject("roomoption_impl");
		return transformRoomOptionListToHashMap(roomoptionList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/hotel/delete")
    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		roomoptionRepository.deleteObject(id);
		return getAllRoomOption(vmjExchange);
	}

}
