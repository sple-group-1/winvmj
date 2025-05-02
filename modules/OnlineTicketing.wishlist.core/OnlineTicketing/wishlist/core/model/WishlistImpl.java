package OnlineTicketing.wishlist.core;

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


@Entity(name = "wishlist_impl")
@Table(name = "wishlist_impl")
public class WishlistImpl extends WishlistComponent {

  public WishlistImpl(UUID wishlistId, Date addedAt) {
    this.wishlistId = wishlistId;
    this.addedAt = addedAt;
  }


  public WishlistImpl() {}



  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> wishlistMap = new HashMap<String, Object>();
    wishlistMap.put("wishlistId", getWishlistId());
    wishlistMap.put("addedAt", getAddedAt());

    return wishlistMap;
  }
  
  public UUID getWishlistId() {
	  return this.wishlistId;
  }
  public void setWishlistId(UUID wishlistId) {
	  this.wishlistId = wishlistId;
  }
  
  public Date getAddedAt() {
	  return this.addedAt;
  }
  
  public void setAddedAt(Date addedAt) {
	  this.addedAt = addedAt;
  }
  
  
}

