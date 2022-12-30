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
        System.out.println("Circle count: " + dao.getCircleCount());
    }
}
