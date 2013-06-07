package mynosql.system;

import mynosql.domain.Database;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
    public void testBasic() throws Exception {
        db.set("Pau", "1985");
        db.set("Elisabeth", "1984");
        db.set("Anna", "1994");
        db.set("Siddharta", "1981");

        assertEquals("1985", db.get("Pau"));
        assertEquals("1984", db.get("Elisabeth"));
        assertEquals("1994", db.get("Anna"));
        assertEquals("1981", db.get("Siddharta"));
    }
}