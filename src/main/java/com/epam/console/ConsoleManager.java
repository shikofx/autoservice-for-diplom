package com.epam.console;

import java.util.Scanner;

public class ConsoleManager implements IConsoleManager {
    public static Scanner consoleScanner = new Scanner(System.in);

    @Override
    public String readNextLine() {
        return consoleScanner.nextLine();
    }
}
