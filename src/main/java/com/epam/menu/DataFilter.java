package com.epam.menu;

import com.epam.Controller.IFilterController;

import java.util.Date;

public class DataFilter {

    private Date startDate = new Date((new Date()).getTime() - 5000);
    private Date endDate = new Date();
    private IFilterController userInterface;


    public DataFilter(IFilterController userInterface) {
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
            return false;
        if (endDate.getTime() > currentDate().getTime())
            return false;
        if (startDate.getTime() > endDate.getTime())
            return false;
        return true;
    }
}
