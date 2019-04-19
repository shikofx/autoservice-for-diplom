package com.epam.service;

import com.epam.Controller.IFilterProvider;

import java.util.Date;

public class DataFilterService {

    private Date startDate = new Date((new Date()).getTime() - 5000);
    private Date endDate = new Date();
    private IFilterProvider userInterface;


    public DataFilterService(IFilterProvider userInterface) {
        this.userInterface = userInterface;
    }

    public Date currentDate() {
        return new Date();
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean readStartDate() {
        startDate = userInterface.readStartDate();
        return verifyDates();
    }

    public boolean readEndDate() {
        endDate = userInterface.readEndDate();
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
