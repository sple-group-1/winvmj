package OnlineTicketing.bookingitem.flight;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import OnlineTicketing.flight.AirlineFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AirlineResourceImpl extends AirlineResourceComponent{
	protected AirlineResourceComponent record;

	// @Restriced(permission = "")
    @Route(url="call/flight/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Airline airline = createAirline(vmjExchange);
		airlineRepository.saveObject(airline);
		return getAllAirline(vmjExchange);
	}

    public  create(VMJExchange vmjExchange){
		String name = (String) vmjExchange.getRequestBodyForm("name");
		
		//to do: fix association attributes
		
		Airline airline = AirlineFactory.createAirline("OnlineTicketing.flight.core.AirlineImpl", id, name);
			return airline;
	}

    // @Restriced(permission = "")
    @Route(url="call/flight/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Airline airline = airlineRepository.getObject(id);
		airline.setName((String) vmjExchange.getRequestBodyForm("name"));
		
		airlineRepository.updateObject(airline);
		airline = airlineRepository.getObject(id);
		//to do: fix association attributes
		
		return airline.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/flight/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Airline airline = airlineRepository.getObject(id);
		return airline.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/flight/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Airline> airlineList = airlineRepository.getAllObject("airline_impl");
		return transformAirlineListToHashMap(airlineList);
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
    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		airlineRepository.deleteObject(id);
		return getAllAirline(vmjExchange);
	}

}
