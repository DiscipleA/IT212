/**
* Eliphant class extends Animal abstract class and inherits methods attributes
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class Eliphant extends Animal {

    //inherited constructor
    public Eliphant(String name) {
        super(name);
        
    }

    //makeSound method extention to abstraction
    public String makeSound() {
       return "Trump!";
    }

    //inherited to String output
    public String toString() {return super.toString();}

}