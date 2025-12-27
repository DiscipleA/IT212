/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class Main {
    public static void main(String[] arg){
        Shape circle = new Circle(5.0);
        System.out.println(circle.toString());

        Shape rectangle = new Rectangle(2.6, 3.0);
        System.out.println(rectangle.toString());

        Shape triangle = new Triangle(2.6, 3.0, 5.5);
        System.out.println(triangle.toString());

        
    }
}