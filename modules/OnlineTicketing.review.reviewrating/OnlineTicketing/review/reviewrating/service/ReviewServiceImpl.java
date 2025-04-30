package OnlineTicketing.review.reviewrating;

import java.util.*;

import vmj.routing.route.VMJExchange;

import OnlineTicketing.review.core.ReviewServiceDecorator;
import OnlineTicketing.review.core.ReviewImpl;
import OnlineTicketing.review.core.ReviewServiceComponent;

public class ReviewServiceImpl extends ReviewServiceDecorator {
    public ReviewServiceImpl (ReviewServiceComponent record) {
        super(record);
    }

    
}
