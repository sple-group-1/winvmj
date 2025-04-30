package OnlineTicketing.blog.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Blog {
	public UUID getId();
	public void setId(UUID id);
	public String getTitle();
	public void setTitle(String title);
	public String getContent();
	public void setContent(String content);
	public Date getCreatedAt();
	public void setCreatedAt(Date createdAt);
	HashMap<String, Object> toHashMap();
}
