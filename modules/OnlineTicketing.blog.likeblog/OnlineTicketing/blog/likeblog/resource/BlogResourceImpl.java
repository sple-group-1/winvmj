package OnlineTicketing.blog.likeblog;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import OnlineTicketing.blog.core.BlogResourceDecorator;
import OnlineTicketing.blog.core.BlogImpl;
import OnlineTicketing.blog.core.BlogResourceComponent;

public class BlogResourceImpl extends BlogResourceDecorator {
    public BlogResourceImpl (BlogResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/likeblog/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Blog create(VMJExchange vmjExchange){
		String likeCountStr = (String) vmjExchange.getRequestBodyForm("likeCount");
		int likeCount = Integer.parseInt(likeCountStr);
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.likeblog.core.BlogImpl", , likeCount, customerimpl);
			return deco;
	}

    public Blog create(VMJExchange vmjExchange, int id){
		String likeCountStr = (String) vmjExchange.getRequestBodyForm("likeCount");
		int likeCount = Integer.parseInt(likeCountStr);
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("OnlineTicketing.likeblog.core.BlogImpl", id, , likeCount, customerimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/likeblog/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		 = create(vmjExchange, id);
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/likeblog/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getBlog(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/likeblog/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/likeblog/delete")
    public List<HashMap<String,Object>> deleteBlog(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void Like() {
		// TODO: implement this method
	}
}
