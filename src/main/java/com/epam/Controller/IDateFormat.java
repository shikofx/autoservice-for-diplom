package com.epam.Controller;

import java.text.ParseException;
import java.util.Date;

public interface IDateFormat<T> {
    Date toDate(T t) throws ParseException;
}
