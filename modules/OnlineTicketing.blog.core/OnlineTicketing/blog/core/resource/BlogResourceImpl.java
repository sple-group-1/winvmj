package OnlineTicketing.blog.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.blog.BlogFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BlogResourceImpl extends BlogResourceComponent{
	
	private BlogServiceImpl blogServiceImpl = new BlogServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/blog")
    public HashMap<String,Object> createblog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Blog result = blogServiceImpl.createBlog(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/blog/update")
    public HashMap<String, Object> updateBlog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return blogServiceImpl.updateBlog(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/blog/detail")
    public HashMap<String, Object> getBlog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return blogServiceImpl.getBlog(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/blog/list")
    public List<HashMap<String,Object>> getAllBlog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return blogServiceImpl.getAllBlog(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/blog/delete")
    public List<HashMap<String,Object>> deleteBlog(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return blogServiceImpl.deleteBlog(requestBody);
	}

}
