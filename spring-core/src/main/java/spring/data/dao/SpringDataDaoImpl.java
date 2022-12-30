package spring.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
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
        String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new CircleMapper(), id);
    }

    @Override
    public Integer getCircleCount() {
        String sql = "SELECT COUNT(*) FROM CIRCLE";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public String getCircleName(int id) {
        String sql = "SELECT NAME FROM CIRCLE WHERE ID=?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }

    @Override
    public List<Circle> getAllCircles() {
        String sql = "SELECT * FROM CIRCLE";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    private static final class CircleMapper implements RowMapper<Circle> {

        @Override
        @Nullable
        public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Circle circle = new Circle(resultSet.getInt("id"), resultSet.getString("name"));
            return circle;
        }
        
    }
    
}
