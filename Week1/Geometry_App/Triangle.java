/**
* Triangle class extends Shape abstract class and inherits abstract methods
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

//import java.lang.Math;

public class Triangle extends Shape {

    // instance variables
    private Double leftside;
    private Double rightside;
    private Double base;

    // constructor
    public Triangle(Double leftside, Double rightside, Double base) {
        setLeftSide(leftside);
        setRightSide(rightside);
        setBase(base);
    }

    // accessors
    public Double getLeftSide() {return leftside;}

    public Double getRightSide() {return rightside;}

    public Double getBase() {return base;}

    // mutators
    public void setLeftSide(Double leftside) {
        if (leftside == null || leftside <=0) {
            throw new IllegalArgumentException(getSubclassName() + " can not have null or negative side.");
        }  
        this.leftside = leftside;
    }

    public void setRightSide(Double rightside) {
        if (rightside == null || rightside <=0) {
            throw new IllegalArgumentException(getSubclassName() + " can not have null or negative side.");
        }  
        this.rightside = rightside;
    }

    public void setBase(Double base) {
        if (base == null || base <=0) {
            throw new IllegalArgumentException(getSubclassName() + " can not have null or negative side.");
        }  
        this.base = base;
    }

    // abstract method inherited from parent Shape
    public Double calculateArea() {
        return calculateArea(leftside, rightside, base);
    }    

    // overloaded method to make area calculations
    public Double calculateArea(Double leftside, Double rightside, Double base) {
        Double s = (leftside + rightside + base) / 2.0;
        Double area = Math.sqrt(s * (s - leftside) * (s - rightside) * (s - base));
        return Math.round(area * 100.0)/100.0;
    }

    // abstract method inherited from parent Shape
    public Double calculatePerimeter() {
        return calculatePerimeter(leftside, rightside, base);
    }

    // overloaded method to make perimeter calculations
    public Double calculatePerimeter(Double leftside, Double rightside, Double base) {
        Double perimeter = leftside + rightside + base;
        return Math.round(perimeter * 100.0)/100.0;
    }

    //inherited to String output
    public String toString() {return super.toString();}
    
}