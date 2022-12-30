package spring.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.data.dao.CircleDao;
import spring.data.dao.JdbcDaoImpl;
import spring.data.model.Circle;

public class SpringDataDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        
        //CircleDao dao = context.getBean("jdbc-dao", CircleDao.class);
        CircleDao dao = context.getBean("spring-data-dao", CircleDao.class);
        
        Circle circle = dao.getCircle(1);
        System.out.println("Circle with id 1: " + circle.getName());
        
        System.out.println("Circle name with id 1: " + dao.getCircleName(1));
        System.out.println("All circles size: " + dao.getAllCircles().size());

        Circle circle2 = new Circle(3, "Third Circle");
        int rowsAffected = dao.insertCircle(circle2);
        System.out.println("Circle count after insert: " + dao.getCircleCount());

        circle2.setName("Updated Circle");
        rowsAffected = dao.updateCircle(circle2);
        rowsAffected = dao.deleteCircle(circle2);
        System.out.println("Circle count after deletion: " + dao.getCircleCount());
    }
}
