package OnlineTicketing.review.reviewrating;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.review.core.ReviewDecorator;
import OnlineTicketing.review.core.Review;
import OnlineTicketing.review.core.ReviewComponent;

@Entity(name="review_reviewrating")
@Table(name="review_reviewrating")
public class ReviewImpl extends ReviewDecorator {

	public EFloat rating;
	public ReviewImpl(
        super();
        this.objectName = ReviewImpl.class.getName();
    }
    
    public ReviewImpl(EFloat rating) {
    	super();
		this.rating = rating;
		this.objectName = ReviewImpl.class.getName();
    }
	
	public ReviewImpl(ReviewComponent record, EFloat rating) {
		super(record);
		this.rating = rating;
		this.objectName = ReviewImpl.class.getName();
	}



}
