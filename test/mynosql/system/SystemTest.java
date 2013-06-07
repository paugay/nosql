package mynosql.system;

import mynosql.domain.Database;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author paugay
 */
public class SystemTest {

    Database db;

    public SystemTest() {
        db = new Database();
    }

    @Test
    public void testBasic() {
        String key = "key";
        String value = "value";
        
        db.set(key, value);
        
        assertEquals(value, db.get(key));
    }
}