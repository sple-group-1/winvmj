package OnlineTicketing.blog.core;
import java.util.*;

public abstract class BlogServiceDecorator extends BlogServiceComponent{
	protected BlogServiceComponent record;

    public BlogServiceDecorator(BlogServiceComponent record) {
        this.record = record;
    }

	public Blog createBlog(Map<String, Object> requestBody){
		return record.createBlog(requestBody);
	}

	public HashMap<String, Object> getBlog(Map<String, Object> requestBody){
		return record.getBlog(requestBody);
	}

	public List<HashMap<String,Object>> getAllBlog(Map<String, Object> requestBody){
		return record.getAllBlog(requestBody);
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

	public HashMap<String, Object> getBlogById(UUID id){
        return record.getBlogById(id);
    }

}
