package com.epam.console;

import com.epam.service.IDataProvider;

import java.util.Date;

public class ConsoleProvider implements IDataProvider {
    private ConsoleDateFormat consoleDateFormat = new ConsoleDateFormat();
    private IConsoleManager consoleManager;

    public ConsoleProvider(IConsoleManager consoleManager) {
        this.consoleManager = consoleManager;
    }

    @Override
    public Date getStartDate() {
        System.out.println("Input start date: ");
        return consoleDateFormat.toDate(consoleManager.readNextLine());
    }

    @Override
    public Date getEndDate() {
        System.out.println("Input end date: ");
        return consoleDateFormat.toDate(consoleManager.readNextLine());
    }
}
