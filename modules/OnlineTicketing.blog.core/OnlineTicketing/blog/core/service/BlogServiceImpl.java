package OnlineTicketing.blog.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import OnlineTicketing.blog.BlogFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BlogServiceImpl extends BlogServiceComponent{

    public List<HashMap<String,Object>> saveBlog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Blog blog = createBlog(vmjExchange);
		blogRepository.saveObject(blog);
		return getAllBlog(vmjExchange);
	}

    public Blog createBlog(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		String content = (String) requestBody.get("content");
		
		//to do: fix association attributes
		Blog Blog = BlogFactory.createBlog(
			"OnlineTicketing.blog.core.BlogImpl",
		id
		, title
		, content
		, createdAt
		);
		Repository.saveObject(blog);
		return blog;
	}

    public Blog createBlog(Map<String, Object> requestBody, int id){
		String title = (String) vmjExchange.getRequestBodyForm("title");
		String content = (String) vmjExchange.getRequestBodyForm("content");
		
		//to do: fix association attributes
		
		Blog blog = BlogFactory.createBlog("OnlineTicketing.blog.core.BlogImpl", title, content, createdAt);
		return blog;
	}

    public HashMap<String, Object> updateBlog(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id");
		int id = Integer.parseInt(idStr);
		Blog blog = Repository.getObject(id);
		
		blog.setTitle((String) requestBody.get("title"));
		blog.setContent((String) requestBody.get("content"));
		
		Repository.updateObject(blog);
		
		//to do: fix association attributes
		
		return blog.toHashMap();
		
	}

    public HashMap<String, Object> getBlog(Map<String, Object> requestBody){
		List<HashMap<String, Object>> blogList = getAllBlog("blog_impl");
		for (HashMap<String, Object> blog : blogList){
			int record_id = ((Double) blog.get("record_id")).intValue();
			if (record_id == id){
				return blog;
			}
		}
		return null;
	}

	public HashMap<String, Object> getBlogById(int id){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Blog blog = blogRepository.getObject(id);
		return blog.toHashMap();
	}

    public List<HashMap<String,Object>> getAllBlog(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Blog> List = Repository.getAllObject(table);
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
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBlog(requestBody);
	}

}
