package com.epam.controller;

import com.epam.service.DataProvider;

import java.util.Date;

public class FilterController {

    private Date startDate = new Date((new Date()).getTime() - 5000);
    private Date endDate = new Date();
    private DataProvider dataProvider;

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public FilterController(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }


    public boolean readAndVerifyStartDate(Date currentDate) throws IllegalArgumentException {
        startDate = dataProvider.getStartDate();
        return verifyDates(currentDate);
    }

    public boolean readAndVerifyEndDate(Date currentDate) throws IllegalArgumentException {
        endDate = dataProvider.getEndDate();
        return verifyDates(currentDate);
    }

    private boolean verifyDates(Date currentDate) throws IllegalArgumentException {
        if (startDate.getTime() > currentDate.getTime()) {
            throw new IllegalArgumentException("Start filter date must be less or equal than current date");
        }
        if (endDate.getTime() > currentDate.getTime()) {
            throw new IllegalArgumentException("End filter date must be less or equal than current date");
        }
        if (startDate.getTime() > endDate.getTime()) {
//            throw new IllegalArgumentException("Start filter date must be less or equal than end filter date");
        }
        return true;
    }
}
