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

        Node nodeB = new Node("B");
        this.nodes.add(nodeB);
        
        Node nodeC = new Node("C");
        this.nodes.add(nodeC);
    }
    
    public void set(String key, String value) throws Exception {
        Node node = hash(key);
        System.out.println("Storing '" + value + "' at key '" + key + "' from node '" + node.getName() + "'.");
        node.set(key, value);
    }

    public String get(String key) throws Exception {
        Node node = hash(key);
        System.out.println("Fetching at key '" + key + "' from node '" + node.getName() + "'.");
        return node.get(key);
    }

    public Node hash(String key) throws Exception {
        String first = key.substring(0, 1);

        if ("ABCDEFGHI".contains(first)) {
            return this.nodes.get(0);
        } else if ("JKLMNOPQR".contains(first)) {
            return this.nodes.get(1);
        } else if ("STUVXYZ".contains(first)) {
            return this.nodes.get(2);
        }

        throw new Exception("Couldn't assign a node for key '" + key + "'.");
    }
}
