package com.epam.controller;

import com.epam.service.IDataProvider;

import java.util.Date;

public class FilterController {

    private Date startDate = new Date((new Date()).getTime() - 5000);
    private Date endDate = new Date();
    private IDataProvider dataProvider;


    public FilterController(IDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public Date currentDate() {
        return new Date();
    }


    public boolean readAndVerifyStartDate() {
        startDate = dataProvider.getStartDate();
        return verifyDates();
    }

    public boolean readAndVerifyEndDate() {
        endDate = dataProvider.getEndDate();
        return verifyDates();
    }

    private boolean verifyDates() {
        if (startDate.getTime() > currentDate().getTime())
            throw new IllegalArgumentException("Start filter date must be less or equal than current date");
        if (endDate.getTime() > currentDate().getTime())
            throw new IllegalArgumentException("End filter date must be less or equal than current date");
        if (startDate.getTime() > endDate.getTime()) {
            throw new IllegalArgumentException("Start filter date must be less or equal than end filter date");
        }
        return true;
    }
}
