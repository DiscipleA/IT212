/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

//import java.lang.Math;

public class Rectangle extends Shape {

    private Double length;
    private Double width;

    public Rectangle(Double length, Double width) {
        setLength(length);
        setWidth(width);
    }

    public Double getLength() {return length;}

    public Double getWidth() {return width;}

    public void setLength(Double length) {
        if (length == null || length <=0) {
            throw new IllegalArgumentException(getSubclassName() + " can not have null or negative length.");
        }  
        this.length = length;
    }

    public void setWidth(Double width) {
        if (width == null || width <=0) {
            throw new IllegalArgumentException(getSubclassName() + " can not have null or negative width.");
        }  
        this.width = width;
    }

    public Double calculateArea() {
        return calculateArea(length, width);
    }    

    public Double calculateArea(Double length, Double width) {
        Double area = length * width;
        return Math.round(area * 100.0)/100.0;
    }

    public Double calculatePerimeter() {
        return calculatePerimeter(length, width);
    }

    public Double calculatePerimeter(Double length, Double width) {
        Double perimeter = 2 * (length + width);
        return Math.round(perimeter * 100.0)/100.0;
    }

    public String toString() {return super.toString();}
    
}