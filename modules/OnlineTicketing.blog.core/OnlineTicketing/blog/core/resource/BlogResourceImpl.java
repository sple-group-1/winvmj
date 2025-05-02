package OnlineTicketing.blog.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.blog.BlogFactory;
import vmj.auth.annotations.Restricted;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BlogResourceImpl extends BlogResourceComponent{	
	private BlogService blogService = new BlogServiceImpl();

	@Restricted(permissionName = "CreateBlog")
    @Route(url="call/blog/create")
    public HashMap<String,Object> createBlog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Blog result = blogService.createBlog(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    @Restricted(permissionName = "UpdateBlog")
    @Route(url="call/blog/update")
    public HashMap<String, Object> updateBlog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return blogService.updateBlog(requestBody);
		
	}

	@Restricted(permissionName = "ReadBlog")
    @Route(url="call/blog/detail")
    public HashMap<String, Object> getBlog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return blogService.getBlog(requestBody);
	}

	@Restricted(permissionName = "ReadBlog")
    @Route(url="call/blog/list")
    public List<HashMap<String,Object>> getAllBlog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return blogService.getAllBlog(requestBody);
	}

	@Restricted(permissionName = "DeleteBlog")
    @Route(url="call/blog/delete")
    public List<HashMap<String,Object>> deleteBlog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return blogService.deleteBlog(requestBody);
	}

}
