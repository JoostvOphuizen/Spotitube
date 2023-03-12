package nl.han.dea.joost.datasource.connection;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseProperties {

    private Properties properties;

    public DatabaseProperties() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(inputStream);
            Class.forName(this.getDriver());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDriver() {
        return properties.getProperty("driver");
    }

    public String getConnectionString() {
        return properties.getProperty("connectionstring");
    }
}

