package OnlineTicketing.wishlist.collectionwishlist;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity(name = "collection_impl")
@Table(name = "collection_impl")
public class CollectionImpl {
  @Id
  private UUID collectionId;
  private String name;
  private String description;

  public CollectionImpl() {
    this.collectionId = UUID.randomUUID();
  }

  public CollectionImpl(String name, String description) {
    this();
    this.name = name;
    this.description = description;
  }

  public CollectionImpl(UUID collectionId, String name, String description) {
    this.collectionId = collectionId;
    this.name = name;
    this.description = description;
  }

  public UUID getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(UUID collectionId) {
    this.collectionId = collectionId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public HashMap<String, Object> toHashMap() {
    HashMap<String, Object> collectionMap = new HashMap<String, Object>();
    collectionMap.put("collectionId", getCollectionId());
    collectionMap.put("name", getName());
    collectionMap.put("description", getDescription());
    return collectionMap;
  }
}
