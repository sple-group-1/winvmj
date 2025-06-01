package OnlineTicketing.blog.likeblog;
import java.util.*;
import java.util.logging.Logger;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import vmj.auth.annotations.Restricted;

import OnlineTicketing.blog.core.BlogResourceDecorator;
import OnlineTicketing.blog.core.BlogImpl;
import OnlineTicketing.blog.core.BlogResourceComponent;
import OnlineTicketing.blog.core.BlogService;
import OnlineTicketing.blog.likeblog.BlogServiceImpl;
import OnlineTicketing.blog.core.BlogServiceComponent;
import OnlineTicketing.blog.core.Blog;

public class BlogResourceImpl extends BlogResourceDecorator {
  private BlogService blogService;

    public BlogResourceImpl (BlogResourceComponent recordController, BlogServiceComponent recordservice) {
      super(recordController);
      this.blogService = new BlogServiceImpl(recordservice);
 }

	@Restricted(permissionName = "CreateBlog")
    @Route(url="call/likeblog/create")
    public HashMap<String,Object> createBlog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Blog result = blogService.createBlog(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

 	@Restricted(permissionName = "ReadBlog")
    @Route(url="call/likeblog/list")
    public List<HashMap<String,Object>> getAllBlog(VMJExchange vmjExchange){
		List<Blog> blogList = blogService.getAllBlog();
    	return blogService.transformListToHashMap(blogList);
	}


@Route(url="call/blog/like")
public HashMap<String, Object> like(VMJExchange vmjExchange) {
    if (!vmjExchange.getHttpMethod().equals("POST")) {
        throw new NotFoundException("Route tidak ditemukan");
    }
    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    Blog blog = blogService.getBlog(id);
    if (blog == null) {
        throw new NotFoundException("Blog tidak ditemukan");
    }

    if (blogService instanceof BlogServiceImpl) {
        ((BlogServiceImpl) blogService).like(id); 
    }
    Blog updatedBlog = blogService.getBlog(id);
    return updatedBlog.toHashMap();
}




}
