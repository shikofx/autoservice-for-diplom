package com.epam.console;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.console.ConsoleDateFormat.DATE_FORMAT;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleProviderTests {
    SimpleDateFormat simpleDateFormat;
    IConsoleManager consoleManager;
    ConsoleProvider consoleProvider;

    @Before
    public void setUp() {
        simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        consoleManager = mock(IConsoleManager.class);
        consoleProvider = new ConsoleProvider(consoleManager);
    }

    @Test
    public void readStartDateFromConsole() throws ParseException {
        String dateString = "20-12-2019";
        Date date = simpleDateFormat.parse(dateString);
        when(consoleManager.readNextLine()).thenReturn(dateString);
        Assert.assertEquals(date, consoleProvider.getStartDate());
    }

    @Test
    public void readEndDateFromConsole() throws ParseException {
        String dateString = "20-12-2019";
        Date date = simpleDateFormat.parse(dateString);
        when(consoleManager.readNextLine()).thenReturn(dateString);
        Assert.assertEquals(date, consoleProvider.getEndDate());
    }
}
