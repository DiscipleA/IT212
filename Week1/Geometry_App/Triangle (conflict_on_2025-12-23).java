/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

//import java.lang.Math;

public class Triangle extends Shape {

    private Double leftside;
    private Double rightside;
    private Double base;

    public Triangle(Double leftside, Double rightside, Double base) {
        setLeftSide(leftside);
        setRightSide(rightside);
        setBase(base);
    }

    public Double getLeftSide() {return leftside;}

    public Double getRightSide() {return rightside;}

    public Double getBase() {return base;}

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

    public Double calculateArea() {
        return calculateArea(leftside, rightside, base);
    }    

    public Double calculateArea(Double leftside, Double rightside, Double base) {
        Double s = (leftside + rightside + base) / 2.0;
        Double area = Math.sqrt(s * (s - leftside) * (s - rightside) * (s - base));
        return Math.round(area * 100.0)/100.0;
    }

    public Double calculatePerimeter() {
        return calculatePerimeter(leftside, rightside, base);
    }

    public Double calculatePerimeter(Double leftside, Double rightside, Double base) {
        Double perimeter = leftside + rightside + base;
        return Math.round(perimeter * 100.0)/100.0;
    }

    public String toString() {return super.toString();}
    
}