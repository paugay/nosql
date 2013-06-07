package mynosql;

import mynosql.domain.Database;

/**
 * @author paugay
 */
public class MyNoSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Database db = new Database();

        db.set("key", "value");

        if (!"value".equals(db.get("key"))) {
            System.out.println("Incorrect value fetched from 'key'.");
            System.exit(99);
        }
        
        System.out.println("Finish.");
    }
}
