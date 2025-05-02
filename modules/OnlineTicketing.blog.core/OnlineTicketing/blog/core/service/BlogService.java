package OnlineTicketing.blog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BlogService {
	Blog createBlog(Map<String, Object> requestBody);
	HashMap<String, Object> getBlog(Map<String, Object> requestBody);
    HashMap<String, Object> updateBlog(Map<String, Object> requestBody);
    HashMap<String, Object> getBlogById(UUID id);
    List<HashMap<String,Object>> getAllBlog(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteBlog(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Blog> List);
}
