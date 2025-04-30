package OnlineTicketing.bookingitem.hotel;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class RoomOptionResourceDecorator extends RoomOptionResourceComponent{
	protected RoomOptionResourceComponent record;

    public RoomOptionResourceDecorator(RoomOptionResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		return record.save(vmjExchange);
	}

    public  create(VMJExchange vmjExchange){
		return record.create(vmjExchange);
	}

    public HashMap<String, Object> update(VMJExchange vmjExchange){
		return record.update(vmjExchange);
	}

    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.get(vmjExchange);
	}

    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return record.getAll(vmjExchange);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> delete(VMJExchange vmjExchange){
		return record.delete(vmjExchange);
	}

}
