package lesson15_16_17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class UserDao {

    public User getUser(Long id,Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM public.\"user\" WHERE id=" + id);
            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean createUser(User user,Connection conn) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO public.\"user\" VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setLong(1, user.getId());
            ps.setString(2, user.getName());
            ps.setDate(3, user.getBirthday());
            ps.setInt(4, user.getLogin_id());
            ps.setString(5,user.getCity());
            ps.setString(6,user.getEmail());
            ps.setString(7,user.getDescr());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User user,Connection conn) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE public.\"user\" SET name=?, birthday=?, city=?,email=?,description=?  WHERE id=?");
            ps.setString(1, user.getName());
            ps.setDate(2, user.getBirthday());
            ps.setString(3,user.getCity());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getDescr());
            ps.setLong(6, user.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(Long id,Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            int i = stmt.executeUpdate("DELETE FROM public.\"user\" WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId( rs.getLong("id") );
        user.setName( rs.getString("name") );
        user.setBirthday( rs.getDate("birthday") );
        user.setLogin_id( rs.getInt("login_id") );
        user.setCity( rs.getString("city") );
        user.setEmail( rs.getString("email") );
        user.setDescr( rs.getString("description") );
        return user;
    }
}
