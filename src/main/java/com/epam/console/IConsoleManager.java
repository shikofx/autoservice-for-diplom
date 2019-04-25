package com.epam.console;


import java.util.Scanner;

public interface IConsoleManager {
    static Scanner consoleScanner = new Scanner(System.in);
    String readNextLine();
}
