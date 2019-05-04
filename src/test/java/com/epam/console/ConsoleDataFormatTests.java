package com.epam.console;

import com.nordstrom.automation.junit.ArtifactParams;
import com.nordstrom.automation.junit.AtomIdentity;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import static com.epam.console.ConsoleDataFormat.DATE_FORMAT;
import static org.junit.Assert.assertThat;

//@RunWith(Parameterized.class)
public class ConsoleDataFormatTests{//} implements ArtifactParams {
//    @Rule
//    public final AtomIdentity identity = new AtomIdentity(this);
    ConsoleDataFormat consoleDataFormat;

//    private String input;

//    public ConsoleDataFormatTests(String input) {
//        this.input = input;
//    }
//
//    @Parameterized.Parameters
//    public static Object[] data() {
//        return new Object[] { "first test", "second test" };
//    }

//    @Override
//    public Description getDescription() {
//        return null;
//    }

//    @Override
//    public Optional<Map<String, Object>> getParameters() {
//        return Optional.empty();
//    }

    @Before
    public void setUp() {
        consoleDataFormat = new ConsoleDataFormat();
    }

    @Test
    public void dateCanContainPointsInFormat() throws ParseException {
        String dateString = "22.05.2019";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = simpleDateFormat.parse(dateString.replaceAll("\\.", "-"));
        assertThat(date, Is.is(consoleDataFormat.dateStringToDate(dateString)));
    }

    @Test
    public void dateCanContainSlashInFormat() throws ParseException {
        String dateString = "22/05/2019";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = simpleDateFormat.parse(dateString.replaceAll("\\/", "-"));
        assertThat(date, Is.is(consoleDataFormat.dateStringToDate(dateString)));
    }

    @Test
    public void dateCanContainDashInFormat() throws ParseException {
        String dateString = "22-05-2019";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = simpleDateFormat.parse(dateString);
        assertThat(date, Is.is(consoleDataFormat.dateStringToDate(dateString)));
    }
}
