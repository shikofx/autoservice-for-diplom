package application;

import device.MobileDevice;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileApplication {

    protected MobileDevice device;

    public void launchDevice(String devicePropertiesFile) {
        device = new MobileDevice(devicePropertiesFile);
    }

    public AndroidDriver getDriver() {
        try {
            return new AndroidDriver(new URL(device.getAppiumServer()), device.getCapabilities());
        } catch (MalformedURLException e) {
            return null;
        }
    }

}
