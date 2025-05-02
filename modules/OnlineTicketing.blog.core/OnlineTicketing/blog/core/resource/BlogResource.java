package OnlineTicketing.blog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BlogResource {
    HashMap<String, Object> updateBlog(VMJExchange vmjExchange);
    HashMap<String, Object> getBlog(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBlog(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBlog(VMJExchange vmjExchange);
	HashMap<String, Object> createBlog(VMJExchange vmjExhange);
}
