package com.epam.Controller;

import com.epam.service.IDateFormatService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleController implements IFilterController, IDateFormatService<String> {
    @Override
    public Date readStartDate() {
        return null;
    }

    @Override
    public Date readEndDate() {
        return null;
    }

    @Override
    public Date toDate(String dateString) {
        String date = dateString.replaceAll("[\\.\\/]", "-");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
