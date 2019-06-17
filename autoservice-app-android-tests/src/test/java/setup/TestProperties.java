package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static final String RESOURCE_PATH = System.getProperty("user.dir") +
                                               "/src/test/resources/";
    private String propertiesFile;
    Properties currentProperties;

    public TestProperties(String propertiesFile) {
        currentProperties = new Properties();
        this.propertiesFile = propertiesFile;
    }

    public String getProperty(String propertyKey) {
        try {
            if (!currentProperties.containsKey(propertyKey)) {

                currentProperties = getCurrentProperties();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentProperties.getProperty(String.valueOf(propertyKey), null);
    }

    Properties getCurrentProperties() throws IOException {
        FileInputStream
            inputStream =
            new FileInputStream(RESOURCE_PATH + propertiesFile);
        currentProperties.load(inputStream);
        inputStream.close();
        return currentProperties;
    }


}
