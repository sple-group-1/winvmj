package OnlineTicketing.blog.core;

import java.util.*;
import java.util.logging.Logger;
import java.time.Instant;
import java.text.SimpleDateFormat;

import OnlineTicketing.blog.BlogFactory;
//add other required packages

public class BlogServiceImpl extends BlogServiceComponent{
	private BlogFactory blogFactory = new BlogFactory();


    public Blog createBlog(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		String content = (String) requestBody.get("content");
		Date createdAt = new Date();

		//to do: fix association attributes
		Blog blog = BlogFactory.createBlog(
			"OnlineTicketing.blog.core.BlogImpl",
		title
		,content
		,createdAt
		);
		blogRepository.saveObject(blog);
		return blog;
	}


	public Blog updateBlog(HashMap<String, Object> requestBody) {
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);

		String title = (String) requestBody.get("title");
		String content = (String) requestBody.get("content");
		Blog blog = blogRepository.getObject(id);
		blog.setTitle(title);
		blog.setContent(content);
	
		blogRepository.updateObject(blog);

		blog = blogRepository.getObject(id);
		return blog;
	}


    public Blog getBlog(UUID id){
	Blog blog = blogRepository.getObject(id);
	return blog;
	}

	public HashMap<String, Object> getBlogById(UUID id){
		Blog blog = blogRepository.getObject(id);
		return blog.toHashMap();
	}

    public List<Blog> getAllBlog(){
		// String table = (String) requestBody.get("table_name");
		List<Blog> BlogList = blogRepository.getAllObject("blog_impl",BlogImpl.class.getName());
		// return transformListToHashMap(List);
		return BlogList;
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Blog> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<Blog> deleteBlog(UUID id){
		// String idStr = ((String) requestBody.get("id"));
		// // int id = Integer.parseInt(idStr);
		// UUID id = UUID.fromString(idStr);
		blogRepository.deleteObject(id);
		return getAllBlog();
	}

}
