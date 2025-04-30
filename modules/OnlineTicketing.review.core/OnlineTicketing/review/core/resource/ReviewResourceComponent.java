package OnlineTicketing.review.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReviewResourceComponent implements ReviewResource{
	
	public ReviewResourceComponent() { }
 
    public abstract Review createReview(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateReview(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReview(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange);

}
