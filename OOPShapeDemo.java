abstract class Shape {
    protected double area;

    abstract void calculateArea();

    void displayArea() {
        System.out.println("Area = " + area);
    }
}

class Rectangle extends Shape {
    private double length;
    private double breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void calculateArea() {
        area = length * breadth;
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        area = Math.PI * radius * radius;
    }
}

public class OOPShapeDemo {
    public static void main(String[] args) {

        Shape s1 = new Rectangle(10, 5);   // Polymorphism
        s1.calculateArea();
        s1.displayArea();

        Shape s2 = new Circle(7);         // Polymorphism
        s2.calculateArea();
        s2.displayArea();
    }
}
