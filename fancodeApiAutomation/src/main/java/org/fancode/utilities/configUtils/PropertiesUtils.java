package org.fancode.utilities.configUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesUtils {

    private final Properties properties;


    public PropertiesUtils() {
        properties = new Properties();
    }

    public String getProperty(String key) throws IOException {
        properties.load(Files.newInputStream(Paths.get(getConfigFilePath())));
        return properties.getProperty(key);
    }

    protected String getConfigFilePath(){
        String resourceDirectory = Paths.get("src", "main", "resources").toString();
        File configFile = new File(resourceDirectory, "global.properties");
        if (configFile.exists()) {
            return configFile.getAbsolutePath(); // Return the absolute path to the file
        } else {
            return "Error: File not found!";
        }
    }
}
