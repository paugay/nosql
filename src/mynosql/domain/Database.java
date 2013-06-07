package mynosql.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author paugay
 */
public class Database {

    List<Node> nodes;

    public Database() {
        this.nodes = new LinkedList<>();
        Node nodeA = new Node("A");
        this.nodes.add(nodeA);
    }
    
    public void set(String key, String value) {
        this.nodes.get(0).set(key, value);
    }

    public String get(String key) {
        return this.nodes.get(0).get(key);
    }
}
