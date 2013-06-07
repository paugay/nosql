package mynosql.domain;

import java.util.HashMap;
import java.util.Map;

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

    public String get(String key) {
        return map.get(key);
    }
}
