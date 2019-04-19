package com.epam.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleProvider implements IFilterProvider, IDateFormat<String> {
    @Override
    public Date readStartDate() {
        return null;
    }

    @Override
    public Date readEndDate() {
        return null;
    }

    @Override
    public Date toDate(String dateString) throws ParseException {
        String date = dateString.replaceAll("[\\.\\/]", "-");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.parse(date);

    }
}
