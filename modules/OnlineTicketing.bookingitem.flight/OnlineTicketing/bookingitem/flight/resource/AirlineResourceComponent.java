package OnlineTicketing.bookingitem.flight;

import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class AirlineResourceComponent implements Resource{
	protected RepositoryUtil<> Repository;

    public AirlineResourceComponent(){
        this.Repository = new RepositoryUtil<>(OnlineTicketing.flight.core.AirlineComponent.class);
    }	

    public abstract List<HashMap<String,Object>> save(VMJExchange vmjExchange);
    public abstract  create(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> update(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> get(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAll(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<> List);
    public abstract List<HashMap<String,Object>> delete(VMJExchange vmjExchange);

}
