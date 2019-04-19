import com.epam.Controller.ConsoleProvider;
import com.epam.Controller.IFilterProvider;
import com.epam.service.DataFilterService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchOrdersByDateRangeTests {
    IFilterProvider userInterface;
    ConsoleProvider consoleProvider = new ConsoleProvider();
    DataFilterService dataFilterService;

    @Before
    public void setUp() {
        userInterface = mock(IFilterProvider.class);
        dataFilterService = new DataFilterService(userInterface);
    }

    @After
    public void tearDown() {
        dataFilterService = null;
    }

    @Test
    public void startDateLessOrEqualsThanCurrentDate() {
        Date currentDate = dataFilterService.currentDate();
        Date startDate = getDateLessThan(currentDate, 1000);
        when(userInterface.readStartDate()).thenReturn(currentDate).thenReturn(startDate);
        Assert.assertTrue(dataFilterService.readStartDate());
        Assert.assertTrue(dataFilterService.readStartDate());
    }

    @Test
    public void endDateLessOrEqualsThanCurrentDate() {
        Date currentDate = dataFilterService.currentDate();
        Date endDate = getDateLessThan(currentDate, 1000);
        when(userInterface.readEndDate()).thenReturn(currentDate).thenReturn(endDate);
        Assert.assertTrue(dataFilterService.readEndDate());
        Assert.assertTrue(dataFilterService.readEndDate());
    }

    @Test
    public void startDateLessThanEndDate() {
        Date startDate = getDateLessThan(dataFilterService.currentDate(), 1000);
        Date endDate = dataFilterService.currentDate();
        when(userInterface.readStartDate()).thenReturn(startDate);
        when(userInterface.readEndDate()).thenReturn(endDate);
        Assert.assertTrue(dataFilterService.readStartDate() && dataFilterService.readEndDate());
    }

    @Test
    public void startDateEqualToEndDate() {
        Date date = dataFilterService.currentDate();
        when(userInterface.readStartDate()).thenReturn(date);
        when(userInterface.readEndDate()).thenReturn(date);
        Assert.assertTrue(dataFilterService.readStartDate() && dataFilterService.readEndDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failWhenStartDateGraterThanEndDate() {
        Date startDate = dataFilterService.currentDate();
        Date endDate = getDateLessThan(dataFilterService.currentDate(), 1000);
        ;
        when(userInterface.readStartDate()).thenReturn(startDate);
        when(userInterface.readEndDate()).thenReturn(endDate);
        dataFilterService.readStartDate();
        dataFilterService.readEndDate();
        fail();
    }


    @Test(expected = IllegalArgumentException.class)
    public void failWhenStartDateGraterThanCurrentDate() {
        Date currentDate = dataFilterService.currentDate();
        Date startDate = getDateGreaterThan(currentDate, 1000);
        when(userInterface.readStartDate()).thenReturn(startDate);
        dataFilterService.readStartDate();
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failWhenEndDateGraterThanCurrentDate() {
        Date currentDate = dataFilterService.currentDate();
        Date endDate = getDateGreaterThan(currentDate, 1000);
        when(userInterface.readEndDate()).thenReturn(endDate);
        dataFilterService.readEndDate();
        fail();
    }

    private Date getDateLessThan(Date currentDate, int deviation) {
        return new Date(currentDate.getTime() - deviation);
    }

    private Date getDateGreaterThan(Date currentDate, int deviation) {
        return new Date(currentDate.getTime() + deviation);
    }
}
