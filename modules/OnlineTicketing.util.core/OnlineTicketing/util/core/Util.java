package OnlineTicketing.util.core;

import java.util.*;

public class Util {
  public static HashMap<String, Object> combine(HashMap<String, Object> sourceMap,
      HashMap<String, Object> data,
      String sourceName) {

    for (Map.Entry<String, Object> i : data.entrySet()) {
      sourceMap.put(sourceName + i.getKey().substring(0, 1).toUpperCase() + i.getKey().substring(1),
          i.getValue());
    }

    return sourceMap;
  }

}
