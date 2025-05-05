package org.example.design.pattern.creational.factory;

public interface Shape {
    public void area();
}

class Circle implements Shape {

    private int radius;

    @Override
    public void area() {
        int area = (22 / 7) * (radius * radius);
        System.out.println("Area = " + area);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

class Rectangle implements Shape {
    private int length;
    private int breadth;

    @Override
    public void area() {
        int area = length * breadth;
        System.out.println("Area Rectangle = " + area);
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}
