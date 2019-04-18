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
        Date currentDate = new Date();
        Date lessThenCurrentDate = new Date(currentDate.getTime() - 1000);
        when(userInterface.readStartDate()).thenReturn(currentDate).thenReturn(lessThenCurrentDate);
        Assert.assertTrue(dataFilter.readAndVerifyStartDate());
        Assert.assertTrue(dataFilter.readAndVerifyStartDate());
    }

    @Test
    public void endDateLessOrEqualsThanCurrentDate() {
        Date currentDate = new Date();
        Date lessThanCurrentDate = new Date(currentDate.getTime() - 1000);
        when(userInterface.readEndDate()).thenReturn(currentDate).thenReturn(lessThanCurrentDate);
        Assert.assertTrue(dataFilter.readAndVerifyEndDate());
        Assert.assertTrue(dataFilter.readAndVerifyEndDate());
    }
}
