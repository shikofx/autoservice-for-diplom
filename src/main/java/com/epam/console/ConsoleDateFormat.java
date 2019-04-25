package com.epam.console;

import com.epam.service.IDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleDateFormat implements IDateFormat<String> {
    public static final String LEGAL_DEVIDERS = "[\\.\\/]";
    public static final String COMMON_DEVIDER = "-";
    public static final String DATE_FORMAT = "dd-MM-yyyy";

    @Override
    public Date toDate(String dateString) {
        String date = dateString.replaceAll(LEGAL_DEVIDERS, COMMON_DEVIDER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
