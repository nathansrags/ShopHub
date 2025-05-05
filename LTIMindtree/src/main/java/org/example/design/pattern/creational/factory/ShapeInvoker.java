package org.example.design.pattern.creational.factory;

public class ShapeInvoker {
    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Circle shape= (Circle) sf.getShape("CIRCLE");
        shape.setRadius(12);
        shape.area();

        //
        Rectangle rectangle = (Rectangle) sf.getShape("RECTANGLE");
        rectangle.setLength(15);
        rectangle.setBreadth(10);
        rectangle.area();
    }
}
