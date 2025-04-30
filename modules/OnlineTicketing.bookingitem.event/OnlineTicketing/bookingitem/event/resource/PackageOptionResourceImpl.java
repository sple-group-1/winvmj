package OnlineTicketing.bookingitem.event;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import OnlineTicketing.event.PackageOptionFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PackageOptionResourceImpl extends PackageOptionResourceComponent{
	protected PackageOptionResourceComponent record;

	// @Restriced(permission = "")
    @Route(url="call/event/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PackageOption packageoption = createPackageOption(vmjExchange);
		packageoptionRepository.saveObject(packageoption);
		return getAllPackageOption(vmjExchange);
	}

    public  create(VMJExchange vmjExchange){
		String name = (String) vmjExchange.getRequestBodyForm("name");
		
		//to do: fix association attributes
		
		PackageOption packageoption = PackageOptionFactory.createPackageOption("OnlineTicketing.event.core.PackageOptionImpl", id, price, name);
			return packageoption;
	}

    // @Restriced(permission = "")
    @Route(url="call/event/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		PackageOption packageoption = packageoptionRepository.getObject(id);
		packageoption.setName((String) vmjExchange.getRequestBodyForm("name"));
		
		packageoptionRepository.updateObject(packageoption);
		packageoption = packageoptionRepository.getObject(id);
		//to do: fix association attributes
		
		return packageoption.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/event/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		PackageOption packageoption = packageoptionRepository.getObject(id);
		return packageoption.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/event/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<PackageOption> packageoptionList = packageoptionRepository.getAllObject("packageoption_impl");
		return transformPackageOptionListToHashMap(packageoptionList);
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
    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		packageoptionRepository.deleteObject(id);
		return getAllPackageOption(vmjExchange);
	}

}
