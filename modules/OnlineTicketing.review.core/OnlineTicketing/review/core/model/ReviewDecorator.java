package OnlineTicketing.review.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ReviewDecorator extends ReviewComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ReviewComponent record;

	public ReviewDecorator () {
		super();
		this.record = record;
		this.reviewId =  reviewId.randomUUID();
		
	public ReviewDecorator (ReviewComponent record) {
		this.reviewId =  reviewId.randomUUID();
		this.record = record;
	}

	public ReviewDecorator (UUID reviewId, ReviewComponent record) {
		this.reviewId =  reviewId;
		this.record = record;
	}
	
	public ReviewDecorator (ReviewComponent record, String objectName) {
		this.reviewId =  reviewId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public ReviewDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
