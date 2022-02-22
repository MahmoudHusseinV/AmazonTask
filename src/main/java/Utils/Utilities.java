package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Utilities {

    public static Properties readProperties(String filePath) {

        try (FileInputStream testProperties = new FileInputStream(filePath)) {
            Properties tempProp = new Properties();
            tempProp.load(testProperties);
            System.out.println("Properties file reading done: " + filePath);
            return tempProp;
        } catch (IOException e) {
            System.out.println("Properties file error: " + e.getMessage());
        }
        return null;
    }
}
