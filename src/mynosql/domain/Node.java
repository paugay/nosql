package mynosql.domain;

import java.util.HashMap;
import java.util.Map;
import mynosql.domain.exception.KeyNotFoundException;

/**
 * @author paugay
 */
public class Node {

    String name;
    Map<String, String> map;

    public Node(String name) {
        this.name = name;
        this.map = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void set(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) throws KeyNotFoundException {
        if (!map.containsKey(key)) {
            throw new KeyNotFoundException("Key '" + key + "' not found in node '" + getName() + "'.");
        }
        
        return map.get(key);
    }

    public void reset() {
        map.clear();
    }
}
