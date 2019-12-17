package lesson17;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static lesson15_16_17.ConnectionFactory.getConnection;

public class CRUDTest {

    private static Connection connection = null;

    @BeforeClass
    public static void beforeAllTests() throws SQLException {
        connection = getConnection();
        connection.setAutoCommit(false);
       // personsDao = new JdbcPersonsDao(JdbcEmbeddedConnection.getConnection());
    }


    @Test
    void Create_rud() throws SQLException {
        try (PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO public.\"user\" VALUES(DEFAULT, '?', '?', 6, '?', '?', '?')")) {
            insertStmt.setString(1, "Jonn Smith");
            insertStmt.setDate(2, Date.valueOf("2019-11-01"));
            insertStmt.setString(3, "Tokio");
            insertStmt.setString(4, "JonnSmithJapanVarior@jp.com");
            insertStmt.setString(5, "real_user");
        }


       // Assert.assertEquals();
    }
    @Test
    void c_Read_ud(){

    }

    @Test
    void cr_Update_d(){

    }

    @Test
    void cru_Delete(){

    }

    @AfterClass
    public static void afterAllTest() throws SQLException {
        connection.close();
        connection.rollback();
    }
}
