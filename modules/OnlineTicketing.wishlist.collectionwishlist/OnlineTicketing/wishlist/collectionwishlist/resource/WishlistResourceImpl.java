package OnlineTicketing.wishlist.collectionwishlist;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import OnlineTicketing.wishlist.core.WishlistResourceDecorator;
import OnlineTicketing.wishlist.core.WishlistImpl;
import OnlineTicketing.wishlist.core.WishlistResourceComponent;

public class WishlistResourceImpl extends WishlistResourceDecorator {
    public WishlistResourceImpl (WishlistResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/collectionwishlist/save")
    public List<HashMap<String,Object>> saveWishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Wishlist wishlist = createWishlist(vmjExchange);
		wishlistRepository.saveObject(wishlist);
		return getAllWishlist(vmjExchange);
	}

    public Wishlist createWishlist(VMJExchange vmjExchange){
		
		Wishlist wishlist = record.createWishlist(vmjExchange);
		Wishlist wishlistdeco = WishlistFactory.createWishlist("OnlineTicketing.collectionwishlist.core.WishlistImpl", wishlist, collectionimpl);
			return wishlistdeco;
	}

    public Wishlist createWishlist(VMJExchange vmjExchange, int id){
		Wishlist wishlist = wishlistRepository.getObject(id);
		int recordWishlistId = (((WishlistDecorator) savedWishlist.getRecord()).getId();
		
		Wishlist wishlist = record.createWishlist(vmjExchange);
		Wishlist wishlistdeco = WishlistFactory.createWishlist("OnlineTicketing.collectionwishlist.core.WishlistImpl", id, wishlist, collectionimpl);
			return wishlistdeco;
	}

    // @Restriced(permission = "")
    @Route(url="call/collectionwishlist/update")
    public HashMap<String, Object> updateWishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		Wishlist wishlist = wishlistRepository.getObject(id);
		wishlist = createWishlist(vmjExchange, id);
		
		wishlistRepository.updateObject(wishlist);
		wishlist = wishlistRepository.getObject(id);
		//to do: fix association attributes
		
		return wishlist.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/collectionwishlist/detail")
    public HashMap<String, Object> getWishlist(VMJExchange vmjExchange){
		return record.getWishlist(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/collectionwishlist/list")
    public List<HashMap<String,Object>> getAllWishlist(VMJExchange vmjExchange){
		List<Wishlist> wishlistList = wishlistRepository.getAllObject("wishlist_impl");
		return transformWishlistListToHashMap(wishlistList);
	}

    public List<HashMap<String,Object>> transformWishlistListToHashMap(List<Wishlist> WishlistList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < WishlistList.size(); i++) {
            resultList.add(WishlistList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/collectionwishlist/delete")
    public List<HashMap<String,Object>> deleteWishlist(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		wishlistRepository.deleteObject(id);
		return getAllWishlist(vmjExchange);
	}

}
