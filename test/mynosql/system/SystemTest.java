package mynosql.system;

import java.util.logging.Level;
import java.util.logging.Logger;
import mynosql.domain.Database;
import mynosql.domain.Node;
import mynosql.domain.exception.KeyNotFoundException;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author paugay
 */
public class SystemTest {

    Database db;

    public SystemTest() {
        db = new Database();

        String nodeNames = "ABC";

        for (int i = 0; i < nodeNames.length(); i++) {
            String nodeName = nodeNames.substring(i, i + 1);
            Node node = new Node(nodeName);
            db.addNode(node);
        }
    }

    @BeforeMethod
    @AfterMethod
    public void resetDatabase() {
        db.reset();
    }

    @Test
    public void testGet() throws KeyNotFoundException {
        db.set("Pau", "1985");
        assertEquals("1985", db.get("Pau"));
    }

    @Test
    public void testMultiGet() throws KeyNotFoundException {
        db.set("Pau", "1985");
        db.set("Elisabeth", "1984");
        db.set("Annas", "1994");
        db.set("Siddharta", "1981");

        assertEquals("1985", db.get("Pau"));
        assertEquals("1984", db.get("Elisabeth"));
        assertEquals("1994", db.get("Annas"));
        assertEquals("1981", db.get("Siddharta"));
    }

    @Test(expectedExceptions = KeyNotFoundException.class)
    public void testGetWithNotFoundException() throws KeyNotFoundException {
        db.set("Pau", "1985");
        assertEquals("1985", db.get("Paus"));
    }

    @Test
    public void testMeasureDatabaseMisses() {
        Integer maxNumToInsert = 100000;
        Integer missCount;
        Double missRate;
        
        for (Integer i = 0; i < maxNumToInsert; i++) {
            db.set(i.toString(), i.toString());
        }
        
        missCount = 0;
        for (Integer i = 0; i < maxNumToInsert; i++) {
            try {
                assertEquals(i.toString(), db.get(i.toString()));
            } catch (KeyNotFoundException ex) {
                missCount++;
            }
        }
        
        missRate = missCount.doubleValue()/maxNumToInsert.doubleValue() * 100;
        System.out.println("Misses before adding a new node: " + missRate);

        Node node = new Node("D");
        db.addNode(node);

        missCount = 0;
        for (Integer i = 0; i < maxNumToInsert; i++) {
            try {
                assertEquals(i.toString(), db.get(i.toString()));
            } catch (KeyNotFoundException ex) {
                missCount++;
            }
        }
        
        missRate = missCount.doubleValue()/maxNumToInsert.doubleValue() * 100;
        System.out.println("Misses after adding a new node: " + missRate);
    }
}