package lk.sliit.inventorycontrolsystem.projectse2030se.config.db.credentials;

import java.io.InputStream;
import java.util.Properties;

public class DBCredentialPropertiesConfig {

    private static final Properties properties = new Properties();

    public static void loadProperties() {
        try (InputStream input = DBCredentialPropertiesConfig.class.getClassLoader().getResourceAsStream("dbCredentials.properties")) {
            if (input == null) {
                throw new RuntimeException("'dbCredentials.properties' - File not found!");
            }
            properties.load(input);
        }
        catch (Exception e) {
            throw new RuntimeException("Error when try to load the 'dbCredentials.properties' Config File!\n", e);
        }
    }

    public static void setProperty(String PROPERTY, String value) {
        DBCredentialPropertiesConfig.loadProperties();
        properties.setProperty(PROPERTY, value);
    }

    public static String getProperty(String key) {
        DBCredentialPropertiesConfig.loadProperties();
        return properties.getProperty(key);
    }
}
