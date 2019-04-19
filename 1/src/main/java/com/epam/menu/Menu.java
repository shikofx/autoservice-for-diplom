package com.epam.menu;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void mainMenu() throws IOException {
        System.out.println("!-----------------Main menu-----------------!");
        System.out.println("1:    Search orders menu");
        System.out.println("2:    Add order menu");
        System.out.println("3:    Exit");
        System.out.println("Select item: ");
    }
}
