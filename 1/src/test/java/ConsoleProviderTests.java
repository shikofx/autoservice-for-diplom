import com.epam.Controller.ConsoleProvider;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ConsoleProviderTests {
    ConsoleProvider cc = new ConsoleProvider();

    @Test
    public void dateCanContainPointsInFormat() throws ParseException {
        String dateString = "22.05.2019";
        assertNotNull(cc.toDate(dateString));
    }

    @Test
    public void dateCanContainSlashInFormat() throws ParseException {
        String dateString = "22/05/2019";
        assertNotNull(cc.toDate(dateString));
    }

    @Test
    public void dateCanContainDashInFormat() throws ParseException {
        String dateString = "22-05-2019";
        assertNotNull(cc.toDate(dateString));
    }

    @Test(expected = ParseException.class)
    public void failWhenIllegalDateFormat() throws ParseException {
        String dateString = "22*05+2019";
        cc.toDate(dateString);
        fail();
    }

}
