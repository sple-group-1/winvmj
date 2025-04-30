package OnlineTicketing.review.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewServiceComponent implements ReviewService{
	protected RepositoryUtil<Review> Repository;

    public ReviewServiceComponent(){
        this.Repository = new RepositoryUtil<Review>(OnlineTicketing.review.core.ReviewComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange);
    public abstract Review createReview(Map<String, Object> requestBodye);
	public abstract Review createReview(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateReview(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getReview(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllReview(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Review> List);
    public abstract List<HashMap<String,Object>> deleteReview(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getReviewById(int id);

}
