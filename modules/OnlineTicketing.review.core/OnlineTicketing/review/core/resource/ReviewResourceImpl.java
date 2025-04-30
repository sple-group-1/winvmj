package OnlineTicketing.review.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.review.ReviewFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ReviewResourceImpl extends ReviewResourceComponent{
	
	private ReviewServiceImpl reviewServiceImpl = new ReviewServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/review")
    public HashMap<String,Object> createreview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Review result = reviewServiceImpl.createReview(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/review/update")
    public HashMap<String, Object> updateReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return reviewServiceImpl.updateReview(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/review/detail")
    public HashMap<String, Object> getReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewServiceImpl.getReview(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/review/list")
    public List<HashMap<String,Object>> getAllReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return reviewServiceImpl.getAllReview(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/review/delete")
    public List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return reviewServiceImpl.deleteReview(requestBody);
	}

}
