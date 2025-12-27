import java.util.Scanner;

public class GPAPercentRange {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean recurInput = true;

        while (recurInput) {
            System.out.print("Enter GPA (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                recurInput = false;}
            else {
                try {
                    double gpa = Math.round(Double.parseDouble(input) * 10)/10.0;
                    if (gpa < 1.0 && gpa >= 0.0) {gpa = 0.0;}
                    
                    int gpaIdx = (int) (gpa * 10) - 9;
                    if (gpaIdx < 0 && gpaIdx >= -9) {gpaIdx = 0;}
                    
                    if (gpaIdx >= 0 && gpaIdx <= 31) {
                        switch (gpaIdx) {
                            case 0:  System.out.println(gpa +"   < 65.0% to 0.0%"); break;
                            case 1:  System.out.println(gpa +"   < 66.0% to 65.0%"); break;
                            case 2:  System.out.println(gpa +"   < 67.0% to 66.0%"); break;
                            case 3:  System.out.println(gpa +"   < 68.0% to 67.0%"); break;
                            case 4:  System.out.println(gpa +"   < 69.0% to 68.0%"); break;
                            case 5:  System.out.println(gpa +"   < 70.0% to 69.0%"); break;
                            case 6:  System.out.println(gpa +"   < 71.0% to 70.0%"); break;
                            case 7:  System.out.println(gpa +"   < 72.0% to 71.0%"); break;
                            case 8:  System.out.println(gpa +"   < 73.0% to 72.0%"); break;
                            case 9:  System.out.println(gpa +"   < 74.0% to 73.0%"); break;
                            case 10: System.out.println(gpa +"   < 75.0% to 74.0%"); break;
                            case 11: System.out.println(gpa +"   < 76.0% to 75.0%"); break;
                            case 12: System.out.println(gpa +"   < 77.0% to 76.0%"); break;
                            case 13: System.out.println(gpa +"   < 78.0% to 77.0%"); break;
                            case 14: System.out.println(gpa +"   < 79.0% to 78.0%"); break;
                            case 15: System.out.println(gpa +"   < 80.0% to 79.0%"); break;
                            case 16: System.out.println(gpa +"   < 81.0% to 80.0%"); break;
                            case 17: System.out.println(gpa +"   < 82.0% to 81.0%"); break;
                            case 18: System.out.println(gpa +"   < 83.0% to 82.0%"); break;
                            case 19: System.out.println(gpa +"   < 84.0% to 83.0%"); break;
                            case 20: System.out.println(gpa +"   < 85.0% to 84.0%"); break;
                            case 21: System.out.println(gpa +"   < 86.0% to 85.0%"); break;
                            case 22: System.out.println(gpa +"   < 87.0% to 86.0%"); break;
                            case 23: System.out.println(gpa +"   < 88.0% to 87.0%"); break;
                            case 24: System.out.println(gpa +"   < 89.0% to 88.0%"); break;
                            case 25: System.out.println(gpa +"   < 90.0% to 89.0%"); break;
                            case 26: System.out.println(gpa +"   < 91.0% to 90.0%"); break;
                            case 27: System.out.println(gpa +"   < 92.0% to 91.0%"); break;
                            case 28: System.out.println(gpa +"   < 93.0% to 92.0%"); break;
                            case 29: System.out.println(gpa +"   < 94.0% to 93.0%"); break;
                            case 30: System.out.println(gpa +"   < 95.0% to 94.0%"); break;
                            case 31: System.out.println(gpa +"   100%    to 95.0%"); break;
                        }
                    } 
                    else {
                        System.out.println("Invalid GPA.");
                    }    
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid GPA or 'exit'.");
                }
            }
        }
        scanner.close();
    }
}
