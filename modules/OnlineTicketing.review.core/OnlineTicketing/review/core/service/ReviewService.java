package OnlineTicketing.review.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReviewService {
	Review createReview(Map<String, Object> requestBody);
	Review createReview(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getReview(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveReview(Map<String, Object> requestBody);
    HashMap<String, Object> updateReview(Map<String, Object> requestBody);
    HashMap<String, Object> getReviewById(int id);
    List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteReview(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
