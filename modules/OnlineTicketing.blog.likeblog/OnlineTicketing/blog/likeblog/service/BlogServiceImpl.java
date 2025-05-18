package OnlineTicketing.blog.likeblog;

import java.util.*;

import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;

import OnlineTicketing.customer.core.*;
import OnlineTicketing.blog.core.BlogServiceDecorator;
// import OnlineTicketing.blog.core.BlogImpl;
import OnlineTicketing.blog.core.BlogServiceComponent;
import OnlineTicketing.blog.BlogFactory;
import OnlineTicketing.blog.core.Blog;
import OnlineTicketing.blog.likeblog.BlogImpl;



public class BlogServiceImpl extends BlogServiceDecorator {
    private CustomerService customerService;
	private BlogFactory blogFactory = new BlogFactory();

    public BlogServiceImpl (BlogServiceComponent record) {
        super(record);
    }

    public Blog createBlog(Map<String, Object> requestBody) {
    String title = (String) requestBody.get("title");
    String content = (String) requestBody.get("content");
    Date createdAt = new Date();
    int like = 0; 

    // TODO: fix association attributes
    Blog blog = BlogFactory.createBlog(
        "OnlineTicketing.blog.core.BlogImpl",
        title,
        content,
        createdAt,
        like 
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

    public List<Blog> getAllBlog(){
		List<Blog> BlogList = blogRepository.getAllObject("blog_likeblog");
		return BlogList;
	}

    public List<Blog> deleteBlog(UUID id){
		blogRepository.deleteObject(id);
		return getAllBlog();
	}

public void like(UUID id, String email) {
    Customer customer = customerService.getCustomerByEmail(email);
    Blog blog = blogRepository.getObject(id);

    if (blog instanceof BlogImpl) {
        BlogImpl blogImpl = (BlogImpl) blog;
        // Customer customerImpl = (Customer) customer;

        blogImpl.like(customer);
        blogRepository.updateObject(blogImpl);
    }

}
}
