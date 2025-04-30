package OnlineTicketing.bookingitem.hotel;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class RoomOptionResourceComponent implements Resource{
	protected RepositoryUtil<> Repository;

    public RoomOptionResourceComponent(){
        this.Repository = new RepositoryUtil<>(OnlineTicketing.hotel.core.RoomOptionComponent.class);
    }	

    public abstract List<HashMap<String,Object>> save(VMJExchange vmjExchange);
    public abstract  create(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> update(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> get(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAll(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<> List);
    public abstract List<HashMap<String,Object>> delete(VMJExchange vmjExchange);

}
