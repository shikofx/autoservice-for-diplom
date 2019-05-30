package com.epam.utils;

import static com.epam.utils.ScreenshotsMaker.SCREENSHOTS_PATH;
import static com.epam.utils.ScreenshotsMaker.makeScreenshot;

import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ReportPortalManager {

    protected static void screenShotToReportPortal(Logger log, String text_message) throws AWTException, IOException {
        Date currentDate = new Date();
        String fileName = SCREENSHOTS_PATH + currentDate.getTime() + ".png";
        makeScreenshot(fileName, "png");
        fileToReportPortal(log, fileName, text_message);
    }

    private static void fileToReportPortal(Logger log, String fileName, String rp_message) throws IOException {
        ReportPortalMessage message = new ReportPortalMessage(new File(fileName), rp_message);
        log.info(message);
    }
}
