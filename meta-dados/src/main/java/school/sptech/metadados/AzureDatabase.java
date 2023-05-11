package school.sptech.metadados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AzureDatabase {
    private static final String SERVER_NAME = "<nome-do-servidor>.database.windows.net";
    private static final String DATABASE_NAME = "<nome-do-banco-de-dados>";
    private static final String USERNAME = "<nome-do-usuario>";
    private static final String PASSWORD = "<senha-do-usuario>";

    public static Connection getConnection() throws SQLException {
        String connectionUrl = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", SERVER_NAME, DATABASE_NAME, USERNAME, PASSWORD);
        return DriverManager.getConnection(connectionUrl);
    }
}
