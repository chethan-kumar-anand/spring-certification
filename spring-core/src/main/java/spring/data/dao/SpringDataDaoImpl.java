package spring.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import spring.data.model.Circle;

@Component("spring-data-dao")
public class SpringDataDaoImpl implements CircleDao {
    
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Circle getCircle(int id) {
        Circle circle = null;
        try (Connection connection = dataSource.getConnection()) {
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
        }
        
        return circle;
    }

    @Override
    public Integer getCircleCount() {
        String sql = "SELECT COUNT(*) FROM CIRCLE";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    
}
