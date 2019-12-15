package lesson15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class JdbcExample {


    private static Logger LOGGER = LoggerFactory.getLogger(JdbcExample.class);


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");

        insertAndBatch(connection);

        paramInsert(connection);

      //  paramSelect(connection);
        connection.close();
    }

    static void insertAndBatch(Connection conn) throws SQLException {
        conn.setAutoCommit(false);
        Statement statement = conn.createStatement();
        statement.addBatch("INSERT INTO public.\"user\" VALUES(3, 'test3', '2019-12-13', 3, 'msk', '1@3.com', 'test_user')");
        statement.addBatch("INSERT INTO public.\"user\" VALUES(4, 'test4', '2019-12-13', 4, 'msk', '1@4.com', 'test_user')");

        int[] count = statement.executeBatch();
        LOGGER.info("add rows - " + count.toString());

        conn.commit();
        conn.setAutoCommit(true);

        //String insertStr = "INSERT INTO public.\"user\" (id, name, birthday, login_id, city, email, description) VALUES (2, 'test2', '2019-12-12', 1, 'msk', '1@1.com', 'test_user')";
        // statement.executeQuery(insertStr);
    }

    static void paramInsert(Connection conn)  {
        String query = "INSERT INTO public.\"user\" VALUES (?, ?, ?, ?, ?, ?,?)";

        PreparedStatement prep = null;
        try {
            prep = conn.prepareStatement(query);

            prep.setInt(1, 5);
            prep.setString(2, "test5");
            prep.setDate(3, Date.valueOf("2019-12-13"));
            prep.setInt(4, 5);
            prep.setString(5, "msk");
            prep.setString(6, "1@5.com");
            prep.setString(7, "test_param_user");

            conn.setAutoCommit(false);
            prep.executeUpdate();
            LOGGER.info("executeUpdate  - ok " );
            WriteToLogerTable(conn,"info","executeUpdate - ok" ,"null");
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.error("Error - "+e);
        }



    }

    static void paramSelect(Connection conn) throws SQLException {
        String query = "SELECT * FROM public.\"user\" WHERE name = ? and login_id = ?";

        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, "test5");
        prep.setInt(2, 5);

        ResultSet resultSet = prep.executeQuery();
        LOGGER.info("---- Param select ----");
        while (resultSet.next()) {
            LOGGER.info(" name=" + resultSet.getString("name")+ "; login_id=" + resultSet.getInt("login_id")) ;
        }

    }

    static void WriteToLogerTable(Connection conn,String level,String message,String ex) {
       // String query = "INSERT INTO public.\"logs\" VALUES (?, ?, ?, ?, ?, ?,?)";

        String logRecord = "INSERT INTO public.logs (id, date, log_level, message, exception) VALUES (DEFAULT, ?, ?, ?, ?)";
        PreparedStatement prep = null;
        try {
            prep = conn.prepareStatement(logRecord);

            prep.setDate(1, getDate());
            prep.setString(2, level);
            prep.setString(3, message);
            prep.setString(4, ex);

            conn.setAutoCommit(false);
            //prep.executeUpdate();
            LOGGER.info("executeUpdate " + prep.executeUpdate());
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.error("Error - "+e);
        }
    }

    private static Date getDate() {
        LocalDate localDate = LocalDate.now();
        return Date.valueOf( localDate );
    }


}
