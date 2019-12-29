package lesson22_23.ConnectionManager;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJdbcImpl implements ConnectionManager {
  private static Logger LOGGER = LogManager.getLogger(ConnectionManagerJdbcImpl.class);

  private static ConnectionManager connectionManager;

  private ConnectionManagerJdbcImpl() {
  }

  public static ConnectionManager getInstance() {
    if (connectionManager == null) {
      connectionManager = new ConnectionManagerJdbcImpl();
    }
    return connectionManager;
  }

  @Override
  public Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/postgres",
          "postgres",
          "postgres");
    } catch (ClassNotFoundException | SQLException e) {
      LOGGER.error("Some thing wrong in getConnection method", e);
    }
    return connection;
  }

  @Override public int get15() {
    return 15;
  }
}
