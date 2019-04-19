package com.epam.console;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConsoleDateFormatTests {
    ConsoleDateFormat consoleDateFormat = new ConsoleDateFormat();

    @Test
    public void dateCanContainPointsInFormat() {
        String dateString = "22.05.2019";
        assertNotNull(consoleDateFormat.toDate(dateString));
    }

    @Test
    public void dateCanContainSlashInFormat() {
        String dateString = "22/05/2019";
        assertNotNull(consoleDateFormat.toDate(dateString));
    }

    @Test
    public void dateCanContainDashInFormat() {
        String dateString = "22-05-2019";
        assertNotNull(consoleDateFormat.toDate(dateString));
    }

}
