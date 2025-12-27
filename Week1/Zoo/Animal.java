/**
*Abstract class Animal with constructor, accessor, mutators and overloaded methodl
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public abstract class Animal {

    //Instance variable
    private String name;

    //constructor
    public Animal(String name) {
        setName(name);
    }

    //accessor
    public String getName() {return name;}
    
    //mutator
    public void setName(String name) {
        if (name == null || name.isEmpty()) {//validation for mutator to value
            throw new IllegalArgumentException("Name can not be null or Empty.");
        }
        this.name = name;
    }

    //abstract method
    public abstract String makeSound();

    //overloaded method
    public String makeSound(int num) {
        if (num <= 0) {num = 1;}
        String sound = "";
        for(int i = 0; i < num; i++) {
            sound += makeSound()+" ";
        }
        return sound;
    }

    //to String standardized output on all instances of child classes 
    public String toString() {
        String output = "";
        output += "\nWhat animal by the name " + name; 
        output += " makes a sound: " + makeSound() + "???\n";
        return output;
    }
}
