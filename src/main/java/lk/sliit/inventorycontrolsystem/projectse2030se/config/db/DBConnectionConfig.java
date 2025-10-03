package lk.sliit.inventorycontrolsystem.projectse2030se.config.db;

import lk.sliit.inventorycontrolsystem.projectse2030se.config.db.credentials.DBCredentialPropertiesConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.db.credentials.DBCredentialSecurityConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionConfig {
    public static final String url = DBCredentialPropertiesConfig.getProperty("db.url");
    public static final String username = DBCredentialPropertiesConfig.getProperty("db.username");
    public static final String password = DBCredentialPropertiesConfig.getProperty("db.password");
//    public static final String username = DBCredentialSecurityConfig.decryptUsername();
//    public static final String password = DBCredentialSecurityConfig.decryptPassword();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
