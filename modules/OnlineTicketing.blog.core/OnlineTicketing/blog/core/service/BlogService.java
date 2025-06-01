package OnlineTicketing.blog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BlogService {
	Blog createBlog(Map<String, Object> requestBody);
	Blog getBlog(UUID id);
    Blog updateBlog(HashMap<String, Object> requestBody);
    HashMap<String, Object> getBlogById(UUID id);
    List<Blog> getAllBlog();
    List<Blog> deleteBlog(UUID id);
	List<HashMap<String, Object>> transformListToHashMap(List<Blog> List);
}
