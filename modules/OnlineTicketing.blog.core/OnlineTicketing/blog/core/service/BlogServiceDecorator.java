package OnlineTicketing.blog.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BlogServiceDecorator extends BlogServiceComponent{
	protected BlogServiceComponent record;

    public BlogServiceDecorator(BlogServiceComponent record) {
        this.record = record;
    }

	public BlogImpl createBlog(Map<String, Object> requestBody){
		return record.createBlog(requestBody);
	}

    public Blog createBlog(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createBlog(requestBody, response);
	}

	public HashMap<String, Object> getBlog(Map<String, Object> requestBody){
		return record.getBlog(requestBody);
	}

	public List<HashMap<String,Object>> getAllBlog(Map<String, Object> requestBody){
		return record.getAllBlog(requestBody);
	}

    public List<HashMap<String,Object>> saveBlog(VMJExchange vmjExchange){
		return record.saveBlog(vmjExchange);
	}

    public HashMap<String, Object> updateBlog(Map<String, Object> requestBody){
		return record.updateBlog(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Blog> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteBlog(Map<String, Object> requestBody){
		return record.deleteBlog(requestBody);
	}

	public HashMap<String, Object> getBlogById(int id){
        return record.getBlogById(id);
    }

}
