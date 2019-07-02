package com.epam.tests;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;
import static com.epam.utils.PropertyProvider.getProperty;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;

public class BaseTest {

    static final Logger LOG = LogManager.getLogger(UITests.class);
    private static final String BROWSER = "browser";
    private static final String URL = "url";
    private static final int TIMEOUT = 10000;
    private static final boolean START_MAXIMIZED = true;

    @Before
    public void setUp() {
        String url = getProperty(URL);
        browser = getProperty(BROWSER);
        startMaximized = START_MAXIMIZED;
        timeout = TIMEOUT;
        open(url);
        LOG.debug("Navigated to " + url);
    }
}
