/**
* Monkey class extends Animal abstract class and inherits methods attributes
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class Monkey extends Animal {

    //inherited constructor
    public Monkey(String name) {
        super(name);
        
    }

    //makeSound method extention to abstraction
    public String makeSound() {
       return "Ooh!";
    }

    //inherited to String output
    public String toString() {return super.toString();}

}