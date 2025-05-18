package OnlineTicketing.blog.likeblog;
import java.util.*;
import java.util.logging.Logger;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import OnlineTicketing.blog.core.BlogResourceDecorator;
import OnlineTicketing.blog.core.BlogImpl;
import OnlineTicketing.blog.core.BlogResourceComponent;
import OnlineTicketing.blog.core.BlogService;
import OnlineTicketing.blog.likeblog.BlogServiceImpl;
import OnlineTicketing.blog.core.BlogServiceComponent;
import OnlineTicketing.blog.core.Blog;

public class BlogResourceImpl extends BlogResourceDecorator {
  private BlogService blogService;
  // private BlogServiceImpl blogService = new BlogServiceImpl();
  private static final Logger LOGGER = Logger.getLogger(BlogResourceImpl.class.getName());

    public BlogResourceImpl (BlogResourceComponent record, BlogServiceComponent recordservice) {
      super(record);
      this.blogService = new BlogServiceImpl(recordservice);
 }

    // @Restriced(permission = "")
    // @Route(url="call/likeblog/save")
    // public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	  = create(vmjExchange);
	// 	Repository.saveObject();
	// 	return getAll(vmjExchange);
	// }

	// @Restricted(permissionName = "CreateBlog")
    @Route(url="call/likeblog/create")
    public HashMap<String,Object> createBlog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Blog result = blogService.createBlog(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // public Blog create(VMJExchange vmjExchange, int id){
	// 	String likeCountStr = (String) vmjExchange.getRequestBodyForm("likeCount");
	// 	int likeCount = Integer.parseInt(likeCountStr);
	// 	  = Repository.getObject(id);
	// 	int recordId = (((Decorator) saved.getRecord()).getId();
		
	// 	  = record.create(vmjExchange);
	// 	 deco = Factory.create("OnlineTicketing.likeblog.core.BlogImpl", id, , likeCount, customerimpl);
	// 		return deco;
	// }

    // @Restriced(permission = "")
    // @Restricted(permissionName = "UpdateBlog")
    @Route(url="call/likeblog/update")
    public HashMap<String, Object> updateBlog(VMJExchange vmjExchange){
		// Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		Blog blog = blogService.updateBlog((HashMap<String, Object>) vmjExchange.getPayload());
    return blog.toHashMap();
		
	}

	// @Restriced(permission = "")
 	// @Restricted(permissionName = "ReadBlog")
    @Route(url="call/likeblog/detail")
    public HashMap<String, Object> getBlog(VMJExchange vmjExchange){
    String idStr = vmjExchange.getGETParam("id");
    if(idStr == null) {
      throw new IllegalArgumentException("Invalid UUID");
    }
    UUID id = UUID.fromString(idStr);

    Blog blog = blogService.getBlog(id);
    return blog.toHashMap();
  }

	// @Restriced(permission = "")
	// @Restricted(permissionName = "ReadBlog")
    @Route(url="call/likeblog/list")
    public List<HashMap<String,Object>> getAllBlog(VMJExchange vmjExchange){
		// Map<String, Object> requestBody = vmjExchange.getPayload(); 
		// return blogService.getAllBlog(requestBody);
		List<Blog> blogList = blogService.getAllBlog();
    	return blogService.transformListToHashMap(blogList);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Blog> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
	// @Restricted(permissionName = "DeleteBlog")
    @Route(url="call/likeblog/delete")
    public List<HashMap<String, Object>> deleteBlog(VMJExchange vmjExchange) {
    if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
      return null;
    }

    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    List<Blog> blogList = blogService.deleteBlog(id);
    return blogService.transformListToHashMap(blogList);
  }


// @Restricted(permissionName = "LikeBlog")
@Route(url="call/likeblog/like")
public HashMap<String,Object> like(VMJExchange vmjExchange) {
    if (!vmjExchange.getHttpMethod().equals("POST")) {
        throw new NotFoundException("Route tidak ditemukan");
    }

    String email = vmjExchange.getAuthPayload().getEmail();
    String idStr = (String) vmjExchange.getRequestBodyForm("id");
    UUID id = UUID.fromString(idStr);

    Blog blog = blogService.getBlog(id);
    if (blog == null) {
        throw new NotFoundException("Blog tidak ditemukan");
    }

    if (blogService instanceof BlogServiceImpl) {
    ((BlogServiceImpl) blogService).like(id, email); 
}


    Blog updatedBlog = blogService.getBlog(id);
    return updatedBlog.toHashMap();
}



}
