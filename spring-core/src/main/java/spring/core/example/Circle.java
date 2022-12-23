package spring.core.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("default-shape")
public class Circle implements Shape {
    
    @Autowired
    @Qualifier(value = "center")
    private Point center;

    public Circle() {}

    public Circle(int x, int y) {
        this.center = new Point();
        this.center.setX(x);
        this.center.setY(y);
    }

    public Point getCenter() {
        return center;
    }

    /* public void setCenter(Point center) {
        this.center = center;
    } */

    @PostConstruct
    private void contruct() {
        System.out.println("Circle bean created!");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Circle bean destroying...");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle from point: " + this.center.toString());
    }
    
}
