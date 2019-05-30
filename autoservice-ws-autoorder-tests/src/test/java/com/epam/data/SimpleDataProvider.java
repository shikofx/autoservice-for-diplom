package com.epam.data;

import org.junit.runners.Parameterized.Parameters;

public class SimpleDataProvider {

    @Parameters
    public static Object[][] ordersWithEmptyFields() {
        return new Object[][]{
            {"", ""},
            {"", "Test Owner"},
            {"22-12-2019", ""}
        };
    }

    @Parameters
    public static Object[][] ordersWithNullFields() {
        return new Object[][]{
            {null, null},
            {null, "Test Owner"},
            {"22-12-2019", null}
        };
    }

    @Parameters
    public static Object[][] ordersForModify() {
        return new Object[][]{
            {"22-12-2019", "Test Albert"},
            {"22-12-2019", "Test Peter"},
            {"22-12-2019", "Test +-*/!@#$%^^&*()"},
            {"22-12-2019", "Test 1aA0654679"}
        };
    }
}
