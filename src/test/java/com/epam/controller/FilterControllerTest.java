package com.epam.controller;

import com.epam.service.DataProvider;
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
        Date currentDate = filterController.currentDate();
        Date startDate = getDateLessThan(currentDate, 1000);
        when(dataProvider.getStartDate()).thenReturn(currentDate).thenReturn(startDate);
        Assert.assertTrue(filterController.readAndVerifyStartDate());
        Assert.assertTrue(filterController.readAndVerifyStartDate());
    }

    @Test
    public void endDateLessOrEqualsThanCurrentDate() {
        Date currentDate = filterController.currentDate();
        Date endDate = getDateLessThan(currentDate, 1000);
        when(dataProvider.getEndDate()).thenReturn(currentDate).thenReturn(endDate);
        Assert.assertTrue(filterController.readAndVerifyEndDate());
        Assert.assertTrue(filterController.readAndVerifyEndDate());
    }

    @Test
    public void startDateLessThanEndDate() {
        Date startDate = getDateLessThan(filterController.currentDate(), 1000);
        Date endDate = filterController.currentDate();
        when(dataProvider.getStartDate()).thenReturn(startDate);
        when(dataProvider.getEndDate()).thenReturn(endDate);
        Assert.assertTrue(filterController.readAndVerifyStartDate() && filterController.readAndVerifyEndDate());
    }

    @Test
    public void startDateEqualToEndDate() {
        Date date = filterController.currentDate();
        when(dataProvider.getStartDate()).thenReturn(date);
        when(dataProvider.getEndDate()).thenReturn(date);
        Assert.assertTrue(filterController.readAndVerifyStartDate() && filterController.readAndVerifyEndDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failWhenStartDateGraterThanEndDate() {
        Date startDate = filterController.currentDate();
        Date endDate = getDateLessThan(startDate, 1000);
        when(dataProvider.getStartDate()).thenReturn(startDate);
        when(dataProvider.getEndDate()).thenReturn(endDate);
        filterController.readAndVerifyStartDate();
        filterController.readAndVerifyEndDate();
    }


    @Test(expected = IllegalArgumentException.class)
    public void failWhenStartDateGraterThanCurrentDate() {
        Date currentDate = filterController.currentDate();
        Date startDate = getDateGreaterThan(currentDate, 1000);
        when(dataProvider.getStartDate()).thenReturn(startDate);
        filterController.readAndVerifyStartDate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failWhenEndDateGraterThanCurrentDate() {
        Date currentDate = filterController.currentDate();
        Date endDate = getDateGreaterThan(currentDate, 1000);
        when(dataProvider.getEndDate()).thenReturn(endDate);
        filterController.readAndVerifyEndDate();
    }

    private Date getDateLessThan(Date currentDate, int deviation) {
        return new Date(currentDate.getTime() - deviation);
    }

    private Date getDateGreaterThan(Date currentDate, int deviation) {
        return new Date(currentDate.getTime() + deviation);
    }
}
