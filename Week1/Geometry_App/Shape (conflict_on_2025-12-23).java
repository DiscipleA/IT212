/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public abstract class Shape {

    public abstract Double calculateArea();

    public abstract Double calculatePerimeter();

    public String getSubclassName() {
        return getClass().getSimpleName();
    }

    public String toString() {
        String output = "";
        output += "\nShape: " + getSubclassName();
        output += "\nArea: " + calculateArea();
        output += "\nPerimeter: " + calculatePerimeter() + "\n";
        return output;

    }
    
}
