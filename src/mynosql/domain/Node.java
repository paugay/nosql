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

    public void set(String key, String value) {
        this.map.put(key, value);
    }

    public String get(String key) {
        return this.map.get(key);
    }
}
