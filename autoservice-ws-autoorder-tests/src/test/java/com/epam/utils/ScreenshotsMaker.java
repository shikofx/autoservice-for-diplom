package com.epam.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScreenshotsMaker {

    public static final String SCREENSHOTS_PATH = "logs/screenshot";

    public static void makeScreenshot(String pathname, String formatName) throws AWTException, IOException {
        BufferedImage
            image =
            new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, formatName, new File(pathname));
    }

}
