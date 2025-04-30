package OnlineTicketing.blog.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="blog_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BlogComponent implements Blog{
	@Id
	public UUID id; 
	public String title;
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

	public abstract UUID getId();
	public abstract void setId(UUID id);
	
	public abstract String getTitle();
	public abstract void setTitle(String title);
	
	public abstract String getContent();
	public abstract void setContent(String content);
	
	public abstract Date getCreatedAt();
	public abstract void setCreatedAt(Date createdAt);
	
 

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
