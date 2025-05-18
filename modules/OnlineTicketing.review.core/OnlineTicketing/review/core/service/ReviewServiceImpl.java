package OnlineTicketing.review.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.review.ReviewFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages
import OnlineTicketing.bookingitem.core.*;
import OnlineTicketing.customer.core.*;

public class ReviewServiceImpl extends ReviewServiceComponent {

	// public List<HashMap<String,Object>> saveReview(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	Review review = createReview(vmjExchange);
	// 	reviewRepository.saveObject(review);
	// 	return getAllReview(vmjExchange);
	// }

	public Review createReview(Map<String, Object> requestBody) {
		String reviewContent = (String) requestBody.get("reviewContent");
		UUID reviewId = UUID.randomUUID();
		Date createdAt = new Date();

		// Get customer
		String customerIdStr = (String) requestBody.get("customerId");
		UUID customerId = UUID.fromString(customerIdStr);
		Customer customer = reviewRepository.getProxyObject(OnlineTicketing.customer.core.CustomerComponent.class,
				customerId);

		// Get booking item
		String bookingItemIdStr = (String) requestBody.get("bookingItemId");
		UUID bookingItemId = UUID.fromString(bookingItemIdStr);
		BookingItem bookingitem = reviewRepository.getProxyObject(OnlineTicketing.bookingitem.core.BookingItemComponent.class,
				bookingItemId);

		//to do: fix association attributes
		Review review = ReviewFactory.createReview(
				"OnlineTicketing.review.core.ReviewImpl",
				reviewId, reviewContent, createdAt, customer, bookingitem);
		reviewRepository.saveObject(review);
		return review;
	}

	// public Review createReview(Map<String, Object> requestBody, int id){
	// 	String reviewContent = (String) vmjExchange.getRequestBodyForm("reviewContent");

	// 	//to do: fix association attributes

	// 	Review review = ReviewFactory.createReview("OnlineTicketing.review.core.ReviewImpl", reviewId, reviewContent, createdAt, customerimpl, bookingitemimpl);
	// 	return review;
	// }

	public HashMap<String, Object> updateReview(Map<String, Object> requestBody) {
		String idStr = (String) requestBody.get("reviewId");
		int id = Integer.parseInt(idStr);
		Review review = reviewRepository.getObject(id);

		review.setReviewContent((String) requestBody.get("reviewContent"));

		reviewRepository.updateObject(review);

		//to do: fix association attributes

		return review.toHashMap();

	}

	public HashMap<String, Object> getReview(Map<String, Object> requestBody) {
		Map<String, Object> tableMap = new HashMap<>();
		tableMap.put("table_name", "review_impl");

		List<HashMap<String, Object>> reviewList = getAllReview(tableMap);

		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);

		for (HashMap<String, Object> review : reviewList) {
			UUID record_id = UUID.fromString(review.get("record_id").toString());
			if (record_id.equals(id)) { // ✅ compare UUIDs properly
				return review;
			}
		}
		return null;
	}

	// public HashMap<String, Object> getReviewById(int id){
	// 	String idStr = vmjExchange.getGETParam("reviewId"); 
	// 	int id = Integer.parseInt(idStr);
	// 	Review review = reviewRepository.getObject(id);
	// 	return review.toHashMap();
	// }
	public HashMap<String, Object> getReviewById(int id){
		Review review = reviewRepository.getObject(id);
		return review.toHashMap();
	}

	public List<HashMap<String, Object>> getAllReview(Map<String, Object> requestBody) {
		String table = (String) requestBody.get("table_name");
		List<Review> List = reviewRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

	public List<HashMap<String, Object>> transformListToHashMap(List<Review> List) {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < List.size(); i++) {
			resultList.add(List.get(i).toHashMap());
		}

		return resultList;
	}

	public List<HashMap<String, Object>> deleteReview(Map<String, Object> requestBody) {
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		reviewRepository.deleteObject(id);
		return getAllReview(requestBody);
	}

}
