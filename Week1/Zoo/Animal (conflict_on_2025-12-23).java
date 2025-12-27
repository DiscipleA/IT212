/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

public abstract class Animal {

    private String name;

    public Animal(String name) {
        setName(name);
    }

    public String getName() {return name;}
    
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be null or Empty.");
        }
        this.name = name;
    }

    public abstract String makeSound();

    
    public String makeSound(int num) {
        if (num <= 0) {num = 1;}
        String sound = "";
        for(int i = 0; i < num; i++) {
            sound += makeSound()+" ";
        }
        return sound;
    }

    public String toString() {
        String output = "";
        output += "\nWhat animal by the name " + name; 
        output += " makes a sound: " + makeSound() + "???\n";
        return output;
    }
}
