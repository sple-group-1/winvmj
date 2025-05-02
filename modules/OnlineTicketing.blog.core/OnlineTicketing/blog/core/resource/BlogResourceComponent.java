package OnlineTicketing.blog.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BlogResourceComponent implements BlogResource{
    protected RepositoryUtil<Blog> blogRepository;

	public BlogResourceComponent() { 
        this.blogRepository = new RepositoryUtil<Blog>(OnlineTicketing.blog.core.BlogComponent.class);
    }
 
    public abstract HashMap<String, Object> createBlog(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateBlog(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBlog(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBlog(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBlog(VMJExchange vmjExchange);

}
