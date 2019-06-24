package application;

import device.MobileDevice;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class MobileApplication {

    public AndroidDriver getAppDriver() {
        try {
            return new AndroidDriver(new URL(MobileDevice.getAppiumServer()), MobileDevice.getCapabilities());
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
