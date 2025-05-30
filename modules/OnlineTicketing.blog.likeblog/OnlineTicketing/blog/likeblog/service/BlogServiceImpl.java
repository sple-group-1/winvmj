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
    int likeCount = 0; 

    // TODO: fix association attributes
Blog baseBlog = BlogFactory.createBlog(
        "OnlineTicketing.blog.core.BlogImpl",
        title,
        content,
        createdAt
    );

    Blog blog = BlogFactory.createBlog(
        "OnlineTicketing.blog.likeblog.BlogImpl",
        baseBlog,
        likeCount
    );

    blogRepository.saveObject(blog);
    return blog;
}

    public List<Blog> getAllBlog(){
		List<Blog> BlogList = blogRepository.getAllObject("blog_likeblog");
		return BlogList;
	}

public void like(UUID id) {
    Blog blog = blogRepository.getObject(id);

if (blog instanceof BlogImpl) {
    ((BlogImpl) blog).like();
    blogRepository.updateObject(blog);
}

}
}
