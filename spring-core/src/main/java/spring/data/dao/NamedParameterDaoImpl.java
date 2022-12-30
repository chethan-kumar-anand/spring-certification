package spring.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.lang.Nullable;

import spring.data.model.Circle;

public class NamedParameterDaoImpl extends NamedParameterJdbcDaoSupport implements CircleDao {

    @Override
    public Circle getCircle(int id) {
        String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
        return this.getJdbcTemplate().queryForObject(sql, new CircleMapper(), id);
    }

    @Override
    public Integer getCircleCount() {
        String sql = "SELECT COUNT(*) FROM CIRCLE";
        return this.getJdbcTemplate().queryForObject(sql, Integer.class);
    }

    @Override
    public String getCircleName(int id) {
        String sql = "SELECT NAME FROM CIRCLE WHERE ID=?";
        return this.getJdbcTemplate().queryForObject(sql, String.class, id);
    }

    @Override
    public List<Circle> getAllCircles() {
        String sql = "SELECT * FROM CIRCLE";
        return this.getJdbcTemplate().query(sql, new CircleMapper());
    }

    private static final class CircleMapper implements RowMapper<Circle> {

        @Override
        @Nullable
        public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Circle circle = new Circle(resultSet.getInt("id"), resultSet.getString("name"));
            return circle;
        }
        
    }

    @Override
    public int insertCircle(Circle circle) {
        String sql = "INSERT INTO CIRCLE VALUES (:id, :name)";
        SqlParameterSource namedParameterSource = 
                new MapSqlParameterSource()
                .addValue("id", circle.getId())
                .addValue("name", circle.getName());
        return this.getNamedParameterJdbcTemplate().update(sql, namedParameterSource);
    }

    @Override
    public int updateCircle(Circle circle) {
        String sql = "UPDATE CIRCLE SET NAME=? WHERE ID=?";
        return this.getJdbcTemplate().update(sql, circle.getName(), circle.getId());
    }

    @Override
    public int deleteCircle(Circle circle) {
        String sql = "DELETE FROM CIRCLE WHERE ID=?";
        return this.getJdbcTemplate().update(sql, circle.getId());
    }
    
}
