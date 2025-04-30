package OnlineTicketing.review.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ReviewServiceDecorator extends ReviewServiceComponent{
	protected ReviewServiceComponent record;

    public ReviewServiceDecorator(ReviewServiceComponent record) {
        this.record = record;
    }

	public ReviewImpl createReview(Map<String, Object> requestBody){
		return record.createReview(requestBody);
	}

    public Review createReview(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createReview(requestBody, response);
	}

	public HashMap<String, Object> getReview(Map<String, Object> requestBody){
		return record.getReview(requestBody);
	}

	public List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody){
		return record.getAllReview(requestBody);
	}

    public List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange){
		return record.saveReview(vmjExchange);
	}

    public HashMap<String, Object> updateReview(Map<String, Object> requestBody){
		return record.updateReview(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Review> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteReview(Map<String, Object> requestBody){
		return record.deleteReview(requestBody);
	}

	public HashMap<String, Object> getReviewById(int id){
        return record.getReviewById(id);
    }

}
