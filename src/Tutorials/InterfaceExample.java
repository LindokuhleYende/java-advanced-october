package Tutorials;

interface Shape {
    double area();
}

class Circle implements Shape {
    double r;
    Circle(double r) { this.r = r; }
    public double area() { return Math.PI * r * r; }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Shape s = new Circle(5);
        System.out.println(s.area()); // 78.5398
    }
}
