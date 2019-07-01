package com.epam.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
public class PropertyProvider {

    private static final Logger LOG = Logger.getLogger(PropertyProvider.class);

    private static final String filePath = ".\\src\\test\\resources\\testData.properties";

    private static Properties properties = null;

    public static String getProperty(String property)
    {
        if (properties == null)
        {
            loadProperties(filePath);
        }
        String value = properties.getProperty(property);
        return value;
    }

    private static Properties loadProperties(String filePath)
    {
        File file = new File(filePath);
        properties = new Properties();
        if (!file.isDirectory())
        {
            FileInputStream input = null;
            try
            {
                input = new FileInputStream(file.getAbsolutePath());
                properties.load(input);
            }
            catch (IOException e)
            {
                LOG.error("Exception while trying to load props from: " + filePath.toString());
            }
            finally
            {
                if (input != null)
                {
                    try {
                        input.close();
                    } catch (IOException e) {
                        LOG.error("Error on closing the stream");
                    }
                }
            }
        }
        return properties;
    }
}
