package com.epam.console;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.console.ConsoleDataFormat.DATE_FORMAT;
import static org.junit.Assert.assertThat;

public class ConsoleDataFormatTests {
    ConsoleDataFormat consoleDataFormat;

    @Before
    public void setUp() {
        consoleDataFormat = new ConsoleDataFormat();
    }

    @Test
    public void dateCanContainPointsInFormat() throws ParseException {
        String dateString = "22.05.2019";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = simpleDateFormat.parse(dateString.replaceAll("\\.", "-"));
        assertThat(date, Is.is(consoleDataFormat.toDate(dateString)));
    }

    @Test
    public void dateCanContainSlashInFormat() throws ParseException {
        String dateString = "22/05/2019";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = simpleDateFormat.parse(dateString.replaceAll("\\/", "-"));
        assertThat(date, Is.is(consoleDataFormat.toDate(dateString)));
    }

    @Test
    public void dateCanContainDashInFormat() throws ParseException {
        String dateString = "22-05-2019";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = simpleDateFormat.parse(dateString);
        assertThat(date, Is.is(consoleDataFormat.toDate(dateString)));
    }

}
