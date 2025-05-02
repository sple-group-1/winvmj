package OnlineTicketing.blog.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BlogServiceComponent implements BlogService{
	protected RepositoryUtil<Blog> blogRepository;

    public BlogServiceComponent(){
        this.blogRepository = new RepositoryUtil<Blog>(OnlineTicketing.blog.core.BlogComponent.class);
    }	

	public abstract Blog createBlog(Map<String, Object> requestBody);    
	public abstract HashMap<String, Object> updateBlog(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBlog(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllBlog(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Blog> List);
    public abstract List<HashMap<String,Object>> deleteBlog(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBlogById(UUID id);

}
