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

	public Blog getBlog(UUID id){
		return record.getBlog(id);
	}

	public List<Blog> getAllBlog(){
		return record.getAllBlog();
	}

    public Blog updateBlog(HashMap<String, Object> requestBody){
		return record.updateBlog(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Blog> List){
		return record.transformListToHashMap(List);
	}

    public List<Blog> deleteBlog(UUID id){
		return record.deleteBlog(id);
	}

	public HashMap<String, Object> getBlogById(UUID id){
        return record.getBlogById(id);
    }

}
