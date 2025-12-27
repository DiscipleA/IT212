/**
* Circle class extends Shape abstract class and inherits abstract methods
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

//import java.lang.Math;

public class Circle extends Shape {

    // instance variables
    private Double radious;

    // constructor
    public Circle(Double radious) {
        setRadious(radious);
    }

    // accessors
    public Double getRadious() {return radious;}

    // mutators
    public void setRadious(Double radious) {
        if (radious == null || radious <=0) {
            throw new IllegalArgumentException(getSubclassName() + " can not have null or negative radious.");
        }  
        this.radious = radious;
    }

    // abstract method inherited from parent Shape
    public Double calculateArea() {
        return calculateArea(radious);
    }    

    // overloaded method to make area calculations 
    public Double calculateArea(Double radious) {
        Double area = Math.PI * Math.pow(radious, 2);
        return Math.round(area * 100.0)/100.0;
    }

    // abstract method inherited from parent Shape
    public Double calculatePerimeter() {
        return calculatePerimeter(radious);
    }

    // overloaded method to make perimeter calculations
    public Double calculatePerimeter(Double radious) {
        Double perimeter = 2 * Math.PI * radious;
        return Math.round(perimeter * 100.0)/100.0;
    }

    //inherited to String output
    public String toString() {return super.toString();}
    
}