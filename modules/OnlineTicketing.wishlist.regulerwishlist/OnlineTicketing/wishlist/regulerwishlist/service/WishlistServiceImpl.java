package OnlineTicketing.wishlist.regulerwishlist;

import java.util.*;

import vmj.routing.route.VMJExchange;

import OnlineTicketing.wishlist.core.WishlistServiceDecorator;
import OnlineTicketing.wishlist.core.WishlistImpl;
import OnlineTicketing.wishlist.core.WishlistServiceComponent;

public class WishlistServiceImpl extends WishlistServiceDecorator {
    public WishlistServiceImpl (WishlistServiceComponent record) {
        super(record);
    }

    
}
