package OnlineTicketing.blog.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="blog_impl")
@Table(name="blog_impl")
public class BlogImpl extends BlogComponent {

	public BlogImpl(UUID id, String title, String content, Date createdAt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}

	public BlogImpl(String title, String content, Date createdAt) {
		this.id =  UUID.randomUUID();
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}

	public BlogImpl() { 
		this.id =  UUID.randomUUID();
		this.title = "";
		this.content = "";
		this.createdAt = new Date();
	}


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> blogMap = new HashMap<String,Object>();
		blogMap.put("id",getId());
		blogMap.put("title",getTitle());
		blogMap.put("content",getContent());
		blogMap.put("createdAt",getCreatedAt());

        return blogMap;
    }

}
