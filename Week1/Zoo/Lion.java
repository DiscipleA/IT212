/**
* Lion class extends Animal abstract class and inherits methods attributes
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class Lion extends Animal {

    //inherited constructor
    public Lion(String name) {
        super(name);
        
    }

    //makeSound method extention to abstraction
    public String makeSound() {
       return "Roar!";
    }

    //inherited to String output
    public String toString() {return super.toString();}

}  