/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public class Monkey extends Animal {

    public Monkey(String name) {
        super(name);
        
    }

    public String makeSound() {
       return "Ooh!";
    }

    public String toString() {return super.toString();}

}