package ex6_5;

public class Circle implements GeometricObject{
    final double pi = 3.14;
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ']';
    }

    @Override
    public double getPerimeter() {

        return 2*radius*pi;
    }

    @Override
    public double getArea() {
        return radius*radius*pi;
    }
}
