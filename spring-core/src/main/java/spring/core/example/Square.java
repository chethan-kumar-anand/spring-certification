package spring.core.example;

public class Square implements Shape {

    private int length;

    public Square() {}

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a square with length: " + this.length);
    }
    
}
