package com.epam.menu;

import com.epam.Controller.IFilterController;

import java.util.Date;

public class DataFilter {

    private Date startDate;
    private Date endDate;
    private IFilterController userInterface;


    public DataFilter(IFilterController userInterface) {
        this.userInterface = userInterface;
    }

    private Date currentDate() {
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

    public boolean readAndVerifyStartDate() {
        startDate = userInterface.readStartDate();
        if (startDate.getTime() < currentDate().getTime())
            return true;
        return false;
    }

    public boolean readAndVerifyEndDate() {
        endDate = userInterface.readEndDate();
        if (endDate.getTime() < currentDate().getTime())
            return true;
        return false;
    }
}
