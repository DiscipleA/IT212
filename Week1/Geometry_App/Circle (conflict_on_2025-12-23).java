/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

//import java.lang.Math;

public class Circle extends Shape {

    private Double radious;

    public Circle(Double radious) {
        setRadious(radious);
    }

    public Double getRadious() {return radious;}

    public void setRadious(Double radious) {
        if (radious == null || radious <=0) {
            throw new IllegalArgumentException(getSubclassName() + " can not have null or negative radious.");
        }  
        this.radious = radious;
    }

    public Double calculateArea() {
        return calculateArea(radious);
    }    

    public Double calculateArea(Double radious) {
        Double area = Math.PI * Math.pow(radious, 2);
        return Math.round(area * 100.0)/100.0;
    }

    public Double calculatePerimeter() {
        return calculatePerimeter(radious);
    }

    public Double calculatePerimeter(Double radious) {
        Double perimeter = 2 * Math.PI * radious;
        return Math.round(perimeter * 100.0)/100.0;
    }

    public String toString() {return super.toString();}
    
}