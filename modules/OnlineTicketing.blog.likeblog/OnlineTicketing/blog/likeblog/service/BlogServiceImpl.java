package OnlineTicketing.blog.likeblog;

import java.util.*;

import vmj.routing.route.VMJExchange;

import OnlineTicketing.blog.core.BlogServiceDecorator;
import OnlineTicketing.blog.core.BlogImpl;
import OnlineTicketing.blog.core.BlogServiceComponent;

public class BlogServiceImpl extends BlogServiceDecorator {
    public BlogServiceImpl (BlogServiceComponent record) {
        super(record);
    }

    
	public void Like() {
		// TODO: implement this method
	}
}
