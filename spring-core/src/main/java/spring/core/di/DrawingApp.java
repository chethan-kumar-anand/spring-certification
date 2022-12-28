package spring.core.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        
        Shape shape = context.getBean("default-shape", Shape.class);
        shape.draw();

        Shape s2 = context.getBean("triangle", Shape.class);
        s2.draw();

        context.close();
    }
}
