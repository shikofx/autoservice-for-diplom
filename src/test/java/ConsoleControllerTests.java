import com.epam.Controller.ConsoleController;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConsoleControllerTests {
    ConsoleController cc = new ConsoleController();

    @Test
    public void dateCanContainPointsInFormat() {
        String dateString = "22.05.2019";
        assertNotNull(cc.toDate(dateString));
    }

    @Test
    public void dateCanContainSlashInFormat() {
        String dateString = "22/05/2019";
        assertNotNull(cc.toDate(dateString));
    }

    @Test
    public void dateCanContainDashInFormat() {
        String dateString = "22-05-2019";
        assertNotNull(cc.toDate(dateString));
    }
}
