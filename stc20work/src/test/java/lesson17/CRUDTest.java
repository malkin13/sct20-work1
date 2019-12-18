package lesson17;

import lesson15_16_17.User;
import lesson15_16_17.UserDao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import static lesson15_16_17.ConnectionFactory.getConnection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CRUDTest {

    private static Connection connection;
    private static User john = new User();
    private static UserDao userDao = new UserDao();

    @BeforeAll
    public static void before() throws SQLException {
        connection = getConnection();
        connection.setAutoCommit(false);

        // User john = new User();
        john.setId(266L);
        john.setName("John Smith");
        john.setBirthday(Date.valueOf("1989-05-02"));
        john.setLogin_id(1);
        john.setCity("California");
        john.setEmail("johnSmith@yandex.ru");
        john.setDescr("real User");

        System.out.println("== start connect and create user");
        boolean createStatus = userDao.createUser(john, connection);

        if (createStatus) {
            System.out.println("-- user created");
        } else {

        }


    }

    @Test
    public void c_Read_ud() {
        System.out.println("-- Read user test");

        String t1 = john.toString();
        String t2 = String.valueOf(userDao.getUser(266L, connection));
        assertEquals(t1,t2);
    }

    @Test
    public void cr_Update_d() {
        System.out.println("-- Update user test");

        john.setName("Mike Smith");
        john.setCity("Moscow");
        boolean updateStatus = userDao.updateUser(john, connection);


        assertTrue(updateStatus);

        String u1 = john.toString();
        String u2 = String.valueOf(userDao.getUser(266L, connection));
        assertEquals(u1,u2);
    }

    @Test
    public void cru_Delete() {
        System.out.println("-- Delete user test");
        boolean deleteStatus = userDao.deleteUser(266L, connection);
        assertTrue(deleteStatus);

    }

    @AfterAll
    public static void after() throws SQLException {
        System.out.println("== disconnect");
        connection.rollback();
        connection.close();
    }

}
