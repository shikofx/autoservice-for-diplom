package com.epam.menu;

import java.io.IOException;

import static java.lang.Runtime.getRuntime;

public class ConsoleManager {
    public final static void clearConsole() throws IOException {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }
}
