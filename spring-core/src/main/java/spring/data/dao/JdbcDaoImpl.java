package spring.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.data.model.Circle;

@Component("jdbc-dao")
public class JdbcDaoImpl implements CircleDao {
    
    @Override
    public Circle getCircle(int id) {
        Circle circle = null;

        Connection connection = null;
        String driver = "org.apache.derby.jdbc.ClientDriver";
        
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/db");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM circle where id = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                circle = new Circle(rs.getInt("id"), rs.getString("name"));
            }
            rs.close();
            ps.close();
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return circle;
    }

    @Override
    public Integer getCircleCount() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCircleName(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Circle> getAllCircles() {
        // TODO Auto-generated method stub
        return null;
    }
}
