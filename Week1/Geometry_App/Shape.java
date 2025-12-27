/**
*Abstract class Shape with abstract methods to calculate area and perimeter.
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public abstract class Shape {

    // abstract method to calculate Area of a subclass Shape
    public abstract Double calculateArea();

    // abstract method to calculate Perimeter of a subclass shape
    public abstract Double calculatePerimeter();

    // method to return string with subclass name.
    public String getSubclassName() {
        return getClass().getSimpleName();
    }

    // to String standardized output on all instances of child classes    
    public String toString() {
        String output = "";
        output += "\nShape: " + getSubclassName();
        output += "\nArea: " + calculateArea();
        output += "\nPerimeter: " + calculatePerimeter() + "\n";
        return output;

    }
    
}
