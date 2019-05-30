package com.epam.console;

import com.epam.service.DataProvider;

import java.util.Date;

public class ConsoleDataProvider implements DataProvider {

    private ConsoleDataFormat consoleDataFormat = new ConsoleDataFormat();
    private IConsoleManager consoleManager;

    public ConsoleDataProvider(IConsoleManager consoleManager) {
        this.consoleManager = consoleManager;
    }

    @Override
    public Date getStartDate() {
        System.out.println("Input start date: ");
        return consoleDataFormat.dateStringToDate(consoleManager.readNextLine());
    }

    @Override
    public Date getEndDate() {
        System.out.println("Input end date: ");
        return consoleDataFormat.dateStringToDate(consoleManager.readNextLine());
    }
}
