public class StringProcessor_P1 implements Processor_P1<String> {
    
    @Override
    public String process(String input) {
         if (input == null) {
        return null;
        }

        int length = input.length();
        String reversed = "";

        for (int i = length - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        return reversed;
    }
}