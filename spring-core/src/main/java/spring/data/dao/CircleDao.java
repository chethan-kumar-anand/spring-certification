package spring.data.dao;

import java.util.List;

import spring.data.model.Circle;

public interface CircleDao {
    Circle getCircle(int id);

    Integer getCircleCount();

    String getCircleName(int id);

    List<Circle> getAllCircles();
}
