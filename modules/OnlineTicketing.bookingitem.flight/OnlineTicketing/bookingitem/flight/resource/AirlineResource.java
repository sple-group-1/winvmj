package OnlineTicketing.bookingitem.flight;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface AirlineResource {
    List<HashMap<String,Object>> saveAirline(VMJExchange vmjExchange);
    HashMap<String, Object> updateAirline(VMJExchange vmjExchange);
    HashMap<String, Object> getAirline(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAirline(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAirline(VMJExchange vmjExchange);
}
