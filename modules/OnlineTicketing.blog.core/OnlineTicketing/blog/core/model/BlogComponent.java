package OnlineTicketing.blog.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity(name="blog_comp")
@Table(name="blog_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BlogComponent implements Blog{
	@Id
	public UUID id; 
	public String title;

	@Column(columnDefinition = "TEXT")
	public String content;
	public Date createdAt;
	protected String objectName = BlogComponent.class.getName();

	public BlogComponent() {

	} 

	public BlogComponent(
        UUID id, String title, String content, Date createdAt
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

	public UUID getId(){return this.id;}
	public void setId(UUID id){this.id = id;}
	
	public String getTitle(){return this.title;}
	public void setTitle(String title){this.title = title;}
	
	public String getContent(){return this.content;}
	public void setContent(String content){this.content = content;}
	
	public Date getCreatedAt(){return this.createdAt;}
	public void setCreatedAt(Date createdAt){this.content = content;}
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " title='" + getTitle() + "'" +
            " content='" + getContent() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            "}";
    }
	
}
