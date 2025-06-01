package OnlineTicketing.review.reviewrating;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import OnlineTicketing.review.core.ReviewResourceDecorator;
import OnlineTicketing.review.core.ReviewImpl;
import OnlineTicketing.review.core.ReviewResourceComponent;
import OnlineTicketing.review.core.*;

public class ReviewResourceImpl extends ReviewResourceDecorator {
    public ReviewResourceImpl (ReviewResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/reviewrating/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Review review = create(vmjExchange);
		Repository.saveObject(review);
		return getAll(vmjExchange);
	}

    public Review create(VMJExchange vmjExchange){
		
		Review recordReview = record.create(vmjExchange);
		EFloat rating = new EFloat((String) vmjExchange.getRequestBodyForm("rating"));

		Review deco = Factory.create("OnlineTicketing.review.reviewrating.ReviewImpl", recordReview, rating);
		return deco;
	}

    // public Review create(VMJExchange vmjExchange, int id){
	// 	  = Repository.getObject(id);
	// 	int recordId = (((Decorator) saved.getRecord()).getId();
		
	// 	  = record.create(vmjExchange);
	// 	 deco = Factory.create("OnlineTicketing.reviewrating.core.ReviewImpl", id, , rating);
	// 		return deco;
	// }

    // @Restriced(permission = "")
    @Route(url="call/reviewrating/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("reviewId");
		int id = Integer.parseInt(idStr);

		Review saved = Repository.getObject(id);
		Review updated = create(vmjExchange);

		Repository.updateObject(updated);
		Review refreshed = Repository.getObject(id);

		return refreshed.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewrating/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getReview(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewrating/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<Review> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Review> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/reviewrating/delete")
    public List<HashMap<String,Object>> deleteReview(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
