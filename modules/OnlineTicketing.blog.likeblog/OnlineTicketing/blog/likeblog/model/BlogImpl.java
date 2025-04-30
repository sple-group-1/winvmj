package OnlineTicketing.blog.likeblog;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import OnlineTicketing.blog.core.BlogDecorator;
import OnlineTicketing.blog.core.Blog;
import OnlineTicketing.blog.core.BlogComponent;

@Entity(name="blog_likeblog")
@Table(name="blog_likeblog")
public class BlogImpl extends BlogDecorator {

	public int likeCount;
	public BlogImpl(
        super();
        this.objectName = BlogImpl.class.getName();
    }
    
    public BlogImpl(int likeCount, CustomerImpl customerimpl) {
    	super();
		this.likeCount = likeCount;
		this.objectName = BlogImpl.class.getName();
    }
	
	public BlogImpl(BlogComponent record, int likeCount, CustomerImpl customerimpl) {
		super(record);
		this.likeCount = likeCount;
		this.objectName = BlogImpl.class.getName();
	}


	public void Like() {
		// TODO: implement this method
	}

}
