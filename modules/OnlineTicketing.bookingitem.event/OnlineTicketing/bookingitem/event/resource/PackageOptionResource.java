package OnlineTicketing.bookingitem.event;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PackageOptionResource {
    List<HashMap<String,Object>> savePackageOption(VMJExchange vmjExchange);
    HashMap<String, Object> updatePackageOption(VMJExchange vmjExchange);
    HashMap<String, Object> getPackageOption(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPackageOption(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePackageOption(VMJExchange vmjExchange);
}
