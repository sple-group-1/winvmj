package OnlineTicketing.blog.core;

import java.util.*;
import java.util.logging.Logger;
import java.time.Instant;

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


    public HashMap<String, Object> updateBlog(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		String createdAtStr = (String) requestBody.get("createdAt");
		Date createdAt = Date.from(Instant.parse(createdAtStr));
		Blog blog = blogRepository.getObject(id);
		
		blog.setTitle((String) requestBody.get("title"));
		blog.setContent((String) requestBody.get("content"));
		blog.setCreatedAt(createdAt);

		blogRepository.updateObject(blog);
		
		//to do: fix association attributes
		
		return blog.toHashMap();
		
	}

    public HashMap<String, Object> getBlog(Map<String, Object> requestBody){
		Map<String, Object> map = new HashMap<>();
		map.put("table_name", "blog_impl");
		List<HashMap<String, Object>> blogList = getAllBlog(map);
		String idStr = (String) requestBody.get("id");
		UUID id = UUID.fromString(idStr);
		for (HashMap<String, Object> blog : blogList){
			UUID record_id = UUID.fromString(blog.get("record_id").toString());
			if (record_id.equals(id)){
				return blog;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBlogById(UUID id){
		Blog blog = blogRepository.getObject(id);
		return blog.toHashMap();
	}

    public List<HashMap<String,Object>> getAllBlog(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Blog> List = blogRepository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Blog> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBlog(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		// int id = Integer.parseInt(idStr);
		UUID id = UUID.fromString(idStr);
		blogRepository.deleteObject(id);
		return getAllBlog(requestBody);
	}

}
