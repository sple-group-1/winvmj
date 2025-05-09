package OnlineTicketing.review.core;

import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ReviewResourceDecorator extends ReviewResourceComponent {
	protected ReviewResourceComponent record;

	public ReviewResourceDecorator(ReviewResourceComponent record) {
		this.record = record;
	}

	public HashMap<String, Object> createReview(VMJExchange vmjExchange) {
		return record.createReview(vmjExchange);
	}

	public HashMap<String, Object> updateReview(VMJExchange vmjExchange) {
		return record.updateReview(vmjExchange);
	}

	public HashMap<String, Object> getReview(VMJExchange vmjExchange) {
		return record.getReview(vmjExchange);
	}

	public List<HashMap<String, Object>> getAllReview(VMJExchange vmjExchange) {
		return record.getAllReview(vmjExchange);
	}

	public List<HashMap<String, Object>> deleteReview(VMJExchange vmjExchange) {
		return record.deleteReview(vmjExchange);
	}

}
