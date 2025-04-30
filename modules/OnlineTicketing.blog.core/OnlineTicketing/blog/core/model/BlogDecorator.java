package OnlineTicketing.blog.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BlogDecorator extends BlogComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BlogComponent record;

	public BlogDecorator () {
		super();
		this.record = record;
		this.id =  id.randomUUID();
		
	public BlogDecorator (BlogComponent record) {
		this.id =  id.randomUUID();
		this.record = record;
	}

	public BlogDecorator (UUID id, BlogComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public BlogDecorator (BlogComponent record, String objectName) {
		this.id =  id.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public BlogDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
