package com.epam.tests;

import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.epam.utils.PropertyProvider;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;

public class BaseTest {

    protected static final Logger LOG = LogManager.getLogger(UITests.class);

    @Before
    public void setUp() {
        String url = PropertyProvider.getProperty("url");
        String browser = PropertyProvider.getProperty("browser");
        Configuration.browser = browser;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        open(url);
        LOG.debug("Navigated to " + url);
    }
}
