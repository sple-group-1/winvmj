package OnlineTicketing.review.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewResource {
    List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange);
    HashMap<String, Object> updateReview(VMJExchange vmjExchange);
    HashMap<String, Object> getReview(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange);
	HashMap<String, Object> createReview(VMJExchange vmjExhange);
}
