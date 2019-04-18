import com.epam.Controller.ConsoleController;
import com.epam.Controller.IFilterController;
import com.epam.menu.DataFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchOrdersByDateRangeTests {
    IFilterController userInterface;
    ConsoleController consoleController = new ConsoleController();
    DataFilter dataFilter;

    @Before
    public void setUp() {
        userInterface = mock(IFilterController.class);
        dataFilter = new DataFilter(userInterface);
    }

    @After
    public void tearDown() {
        dataFilter = null;
    }

    @Test
    public void startDateLessOrEqualsThanCurrentDate() {
        Date currentDate = dataFilter.currentDate();
        Date dateLessThanCurrent = getDateLessThan(currentDate);
        when(userInterface.readStartDate()).thenReturn(currentDate).thenReturn(dateLessThanCurrent);
        Assert.assertTrue(dataFilter.readStartDate());
        Assert.assertTrue(dataFilter.readStartDate());
    }

    @Test
    public void endDateLessOrEqualsThanCurrentDate() {
        Date currentDate = dataFilter.currentDate();
        Date dateLessThanCurrent = getDateLessThan(currentDate);
        when(userInterface.readEndDate()).thenReturn(currentDate).thenReturn(dateLessThanCurrent);
        Assert.assertTrue(dataFilter.readEndDate());
        Assert.assertTrue(dataFilter.readEndDate());
    }

    @Test
    public void startDateLessThanEndDate() {
        when(userInterface.readStartDate()).thenReturn(consoleController.toDate("22-02-2019"));
        when(userInterface.readEndDate()).thenReturn(consoleController.toDate("22-03-2019"));
        Assert.assertTrue(dataFilter.readStartDate() && dataFilter.readEndDate());
    }

    @Test
    public void startDateEqualToEndDate() {
        when(userInterface.readStartDate()).thenReturn(consoleController.toDate("22-03-2019"));
        when(userInterface.readEndDate()).thenReturn(consoleController.toDate("22-03-2019"));
        Assert.assertTrue(dataFilter.readStartDate() && dataFilter.readEndDate());
    }


    private Date getDateLessThan(Date currentDate) {
        return getDateLessThan(currentDate, 1000);
    }

    private Date getDateLessThan(Date currentDate, int deviation) {
        return new Date(currentDate.getTime() - deviation);
    }

    //Fail тесты на дату

}
