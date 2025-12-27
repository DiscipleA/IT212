/**
*
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

import java.util.Scanner;

public class ZooDemo {
    public static void main(String[] args) {
        Animal dumbo = new Eliphant("Dumbo");
        Animal abu = new Monkey("Abu");
        Animal simba = new Lion("Simba");

        Animal[] zoo = {dumbo, abu, simba};

        Scanner sound = new Scanner(System.in);

        for (int i = 0; i < zoo.length; i++) {            
            System.out.println(zoo[i].toString());
            System.out.print("Please enter how many times " + zoo[i].getName() + 
                            " needs to make sound to guess right: ");
            int input = sound.nextInt();
            System.out.println(zoo[i].makeSound(input));
        }
        
    }
}