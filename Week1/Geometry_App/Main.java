/**
* ZooDemo class with main method to demostrate program functionality
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class Main {
    //
    public static void main(String[] arg){

        //circle Objec instantiation and toString output
        Shape circle = new Circle(250.0);
        System.out.println(circle.toString());

        //Rectangle Objec instantiation and toString output
        Shape rectangle = new Rectangle(1.6, 10.3);
        System.out.println(rectangle.toString());

        //Triangle Objec instantiation and toString output
        Shape triangle = new Triangle(11.6, 12.0, 5.3);
        System.out.println(triangle.toString());

        
    }
}