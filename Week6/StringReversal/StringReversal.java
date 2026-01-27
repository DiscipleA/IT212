public class StringReversal {

    public static void main(String[] args) {

        //3 Test Cases Basic
        System.out.println("3 Basic Test Cases:");
        System.out.println(reverseString("Dmitriy"));
        System.out.println(reverseString("yirtimd"));
        System.out.println(reverseString("ABCXYZ"));

        //3 Test Cases Edge
        System.out.println("3 Edge Test Cases:");
        System.out.println(reverseString(""));
        System.out.println(reverseString("q"));
        System.out.println(reverseString("racecar"));


    }

    public static String reverseString(String input) {

        if (input.length() <= 1) {
            return input;
        }

        char lastChar = input.charAt(input.length() - 1);

        String remPortion = input.substring(0, input.length() - 1);

        return lastChar + remPortion;
    }

}

