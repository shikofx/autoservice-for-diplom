package application;

import device.MobileDevice;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class MobileApplication {

    private MobileDevice device;

    public MobileApplication(String devicePropertiesFile) {
        this.device = MobileDevice.launchDevice(devicePropertiesFile);
    }

    public AndroidDriver getDriver() {
        try {
            return new AndroidDriver(new URL(device.getAppiumServer()), device.getCapabilities());
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public MobileDevice device() {
        return device;
    }
}
