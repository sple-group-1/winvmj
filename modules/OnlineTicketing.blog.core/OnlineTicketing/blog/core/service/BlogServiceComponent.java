package OnlineTicketing.blog.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BlogServiceComponent implements BlogService{
	protected RepositoryUtil<Blog> Repository;

    public BlogServiceComponent(){
        this.Repository = new RepositoryUtil<Blog>(OnlineTicketing.blog.core.BlogComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveBlog(VMJExchange vmjExchange);
    public abstract Blog createBlog(Map<String, Object> requestBodye);
	public abstract Blog createBlog(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateBlog(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getBlog(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllBlog(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Blog> List);
    public abstract List<HashMap<String,Object>> deleteBlog(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getBlogById(int id);

}
