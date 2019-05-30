package com.epam.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.epam.service.DataProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class FilterControllerTest {

    DataProvider dataProvider;
    FilterController filterController;

    @Before
    public void setUp() {
        dataProvider = mock(DataProvider.class);
        filterController = new FilterController(dataProvider);
    }

    @After
    public void tearDown() {
        filterController = null;
    }

    @Test
    public void startDateLessOrEqualsThanCurrentDate() {
        Date currentDate = new Date();
        Date startDate = getDateLessThan(currentDate, 100000);
        when(dataProvider.getStartDate()).thenReturn(currentDate).thenReturn(startDate);
        Assert.assertTrue(filterController.readAndVerifyStartDate(currentDate));
        Assert.assertTrue(filterController.readAndVerifyStartDate(currentDate));
    }

    @Test
    public void endDateLessOrEqualsThanCurrentDate() {
        Date currentDate = new Date();
        Date endDate = getDateLessThan(currentDate, 100000);
        when(dataProvider.getEndDate()).thenReturn(currentDate).thenReturn(endDate);
        Assert.assertTrue(filterController.readAndVerifyEndDate(currentDate));
    }

    @Test
    public void startDateLessThanEndDate() {
        Date currentDate = new Date();
        Date startDate = getDateLessThan(currentDate, 100000);
        Date endDate = currentDate;
        when(dataProvider.getStartDate()).thenReturn(startDate);
        when(dataProvider.getEndDate()).thenReturn(endDate);
        Assert.assertTrue(
            filterController.readAndVerifyStartDate(currentDate) && filterController.readAndVerifyEndDate(currentDate));
    }

    @Test
    public void startDateEqualToEndDate() {
        Date currentDate = new Date();
        when(dataProvider.getStartDate()).thenReturn(currentDate);
        when(dataProvider.getEndDate()).thenReturn(currentDate);
        Assert.assertTrue(
            filterController.readAndVerifyStartDate(currentDate) && filterController.readAndVerifyEndDate(currentDate));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void failWhenStartDateGraterThanEndDate() {
//        Date startDate = new Date();
//        Date endDate = getDateLessThan(startDate, 100000);
//        when(dataProvider.getStartDate()).thenReturn(startDate);
//        when(dataProvider.getEndDate()).thenReturn(endDate);
//        filterController.readAndVerifyStartDate(startDate);
//        filterController.readAndVerifyEndDate(startDate);
//    }


    @Test(expected = IllegalArgumentException.class)
    public void failWhenStartDateGraterThanCurrentDate() {
        Date currentDate = new Date();
        Date startDate = getDateGreaterThan(currentDate, 100000);
        when(dataProvider.getStartDate()).thenReturn(startDate);
        filterController.readAndVerifyStartDate(currentDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failWhenEndDateGraterThanCurrentDate() {
        Date currentDate = new Date();
        Date endDate = getDateGreaterThan(currentDate, 100000);
        when(dataProvider.getEndDate()).thenReturn(endDate);
        filterController.readAndVerifyEndDate(currentDate);
    }

    private Date getDateLessThan(Date currentDate, int deviation) {
        return new Date(currentDate.getTime() - deviation);
    }

    private Date getDateGreaterThan(Date currentDate, int deviation) {
        return new Date(currentDate.getTime() + deviation);
    }
}
