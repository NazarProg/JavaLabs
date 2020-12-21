package lab5.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TimeZone;

class DBConnect {
    private static final String URL = "jdbc:mysql://127.0.0.1/game?serverTimezone=" + TimeZone.getDefault().getID();
    private static final String USER = "dragon";
    private static final String PASSWORD = "DraganNazar0005";

    static Connection getConnect() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        return DriverManager.getConnection(URL, properties);
    }
}
