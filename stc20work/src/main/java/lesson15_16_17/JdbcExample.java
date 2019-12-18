package lesson15_16_17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class JdbcExample {

    private static Logger LOGGER = LogManager.getLogger(JdbcExample.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");

        insertAndBatch(connection);

        paramInsert(connection);

        paramSelect(connection);

        SavePoints(connection);

        connection.close();


    }

    /**
     * batch insert method
     *
     * @param conn
     * @throws SQLException
     */
    static void insertAndBatch(Connection conn) throws SQLException {
        conn.setAutoCommit(false);
        Statement statement = conn.createStatement();
        statement.addBatch("INSERT INTO public.\"user\" VALUES(DEFAULT, 'test3', '2019-12-13', 3, 'msk', '1@3.com', 'test_user')");
        statement.addBatch("INSERT INTO public.\"user\" VALUES(DEFAULT, 'test4', '2019-12-13', 4, 'msk', '1@4.com', 'test_user')");

        int[] count = statement.executeBatch();
        LOGGER.info("add rows - " + count.toString());

        conn.commit();
        conn.setAutoCommit(true);

    }

    /**
     * Insert to DB with Param
     *
     * @param conn
     */
    static void paramInsert(Connection conn) {
        String query = "INSERT INTO public.\"user\" VALUES (DEFAULT , ?, ?, ?, ?, ?,?)";

        PreparedStatement prep = null;
        try {
            prep = conn.prepareStatement(query);

            // prep.setInt(1, 5);
            prep.setString(1, "test5");
            prep.setDate(2, Date.valueOf("2019-12-13"));
            prep.setInt(3, 5);
            prep.setString(4, "msk");
            prep.setString(5, "1@5.com");
            prep.setString(6, "test_param_user");

            conn.setAutoCommit(false);
            prep.executeUpdate();
            LOGGER.info("executeUpdate  - ok ");
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.error("Error - " + e);
        }


    }

    /**
     * select from db with param
     *
     * @param conn
     * @throws SQLException
     */
    static void paramSelect(Connection conn) throws SQLException {
        String query = "SELECT * FROM public.\"user\" WHERE name = ? and login_id = ?";

        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, "test5");
        prep.setInt(2, 5);

        ResultSet resultSet = prep.executeQuery();
        LOGGER.info("---- Param select ----");
        while (resultSet.next()) {
            LOGGER.info(" name=" + resultSet.getString("name") + "; login_id=" + resultSet.getInt("login_id"));
        }

    }

    static void SavePoints(Connection conn) throws SQLException {

      //  final String INSERT_SQL = ;
        //"INSERT INTO public.\"user\" VALUES (DEFAULT, 'don't be1', '2019-12-11', 66, 'Tagil', 'real@t66.com', 'real_user')";
        conn.setAutoCommit(false);
        try (PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO public.\"user\" VALUES(DEFAULT, '?', '?', 6, '?', '?', '?')")) {

            insertStmt.setString(1, "test6");
            insertStmt.setDate(2, Date.valueOf("2019-12-13"));
            insertStmt.setString(3, "msk");
            insertStmt.setString(4, "1@6.com");
            insertStmt.setString(5, "test_savePoint_user");

            //            insertStmt.setString(1, "test7");
            //            insertStmt.setDate(2, Date.valueOf("2019-12-13"));
            //            insertStmt.setString(3, "msk");
            //            insertStmt.setString(4, "1@7.com");
            //            insertStmt.setString(5, "test_savePoint_user");


            Savepoint savepoint = conn.setSavepoint();

            insertStmt.setString(1, "Jonn Smith");
            insertStmt.setDate(2, Date.valueOf("2019-11-01"));
            insertStmt.setString(3, "Tokio");
            insertStmt.setString(4, "JonnSmithJapanVarior@jp.com");
            insertStmt.setString(5, "real_user");

            conn.rollback(savepoint);

            // Commit statement
            conn.commit();


        } catch (SQLException e) {
            LOGGER.error(e);
            if (conn != null) {
                try {
                    LOGGER.warn("Transaction is being rolled back.");
                    conn.rollback();
                } catch (Exception ex) {
                    LOGGER.warn(ex);
                }
            }

            //Statement statement = conn.createStatement();


        }
    }

}
