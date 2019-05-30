package com.epam.service;

import java.text.ParseException;
import java.util.Date;

public interface DateFormat<T> {

    Date dateStringToDate(T t) throws ParseException;

    Date fullDateStringToDate(String dateString);
}
