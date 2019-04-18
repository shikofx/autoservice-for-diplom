package com.epam.service;

import java.util.Date;

public interface IDateFormatService<T> {
    Date toDate(T t);
}
