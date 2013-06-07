package mynosql.domain;

import java.util.LinkedList;
import java.util.List;
import mynosql.domain.exception.KeyNotFoundException;

/**
 * @author paugay
 */
public class Database {

    List<Node> nodes;
    Boolean log = false;

    public Database() {
        if (log) System.out.println("Created database.");
        this.nodes = new LinkedList<>();
    }

    public void addNode(Node node) {
        if (log) System.out.println("Node '" + node.getName() + "' added to the database node cluster.");
        this.nodes.add(node);
    }

    public void set(String key, String value) {
        Node node = hash(key);
        if (log) System.out.println("Storing '" + value + "' at key '" + key + "' from node '" + node.getName() + "'.");
        node.set(key, value);
    }

    public String get(String key) throws KeyNotFoundException {
        Node node = hash(key);
        if (log) System.out.println("Fetching at key '" + key + "' from node '" + node.getName() + "'.");
        return node.get(key);
    }

    public void reset() {
        if (log) System.out.println("Database reset.");
        for (Node node : nodes) {
            node.reset();
        }
    }

    private Node hash(String key) {
        return nodes.get(key.hashCode() % nodes.size());
    }
}
