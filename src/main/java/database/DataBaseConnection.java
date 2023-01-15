package database;
import utils.ReadPropertiesFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final Logger LOG = LoggerFactory.getLogger(DataBaseConnection.class);

    private static Connection connection = null;
    private static final String DB_DRIVER;
    private static final String DB_URL;
    private static final String DB_NAME;
    private static final String DB_USERNAME;
    private static final String DB_PASSWORD;

    static {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        DB_DRIVER = propertyPage.getDbProperty("DB_DRIVER");
        DB_URL = propertyPage.getDbProperty("DB_URL");
        DB_NAME = propertyPage.getDbProperty("DB_NAME");
        DB_USERNAME = propertyPage.getDbProperty("DB_USERNAME");
        DB_PASSWORD = propertyPage.getDbProperty("dbPassword");
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USERNAME, DB_PASSWORD);
        } catch (Exception e) {
            LOG.error("Exception2: {}", e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public static Connection initialize() {
        return connection;
    }
}
