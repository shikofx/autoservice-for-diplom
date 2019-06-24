package application;

import device.MobileDevice;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class MobileApplication {

    public AndroidDriver getAppDriver() {
        DesiredCapabilities capabilities = MobileDevice.getCapabilities();
        URL serverURL = null;
        try {
            serverURL = new URL(MobileDevice.getAppiumServer());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new AndroidDriver(serverURL, capabilities);
    }
}
