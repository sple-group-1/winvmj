package OnlineTicketing.blog.likeblog;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.ElementCollection;

// import OnlineTicketing.customer.core.*;
import OnlineTicketing.customer.core.Customer;
import OnlineTicketing.blog.core.BlogDecorator;
import OnlineTicketing.blog.core.Blog;
import OnlineTicketing.blog.core.BlogComponent;

@Entity(name="blog_likeblog")
@Table(name="blog_likeblog")
public class BlogImpl extends BlogDecorator {

	public int likeCount;

	@ElementCollection
	@Column(name = "liked_customer_id")
	private Set<UUID> likedCustomerId = new HashSet<>();

	
	public BlogImpl(){
        super();
        this.objectName = BlogImpl.class.getName();
    }
    
    public BlogImpl(int likeCount, Customer customer) {
    	super();
		this.likeCount = likeCount;
		// this.customerImpl = customer;
		this.objectName = BlogImpl.class.getName();
    }
	
	public BlogImpl(BlogComponent record, int likeCount, Customer customer) {
		super(record);
		this.likeCount = likeCount;
		// this.customerImpl = customer;
		this.objectName = BlogImpl.class.getName();
	}


public void like(Customer customer) {
    if (likedCustomerId.contains(customer.getCustomerId())) {
        return; 
    }
    likedCustomerId.add(customer.getCustomerId());
    likeCount += 1;
}


public int getLike() {
    return this.likeCount;
}

public void setLike(int likeCount) {
    this.likeCount = likeCount;
}


	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> blogMap = record.toHashMap();
		blogMap.put("id", this.getId());
		blogMap.put("likeCount", this.likeCount);
		blogMap.put("likedCustomerId", this.likedCustomerId);
		return blogMap;
	}


}
