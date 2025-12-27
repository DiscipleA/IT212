import java.util.ArrayList;

public class Java_Generics_Basics {
    public static void main(String[] args) {
        // -- Part 1: StringProcessor_P1 demonstration --
        Processor_P1<String> p = new StringProcessor_P1();
        String input = "Generics Are Fun";
        String output = p.process(input);
        System.out.println("Original: " + input);
        System.out.println("Reveresed: " + output);


        // -- Part 2: Box_P2 and NumberBox_P2 demonstration --
        Box_P2<Integer> intBox = new Box_P2<>();
        intBox.setBox_P2(42);
        System.out.println("Integer Box: " + intBox.getBox_P2());

        Box_P2<String> strBox = new Box_P2<>("Hello Generics");
        System.out.println("String Box: " + strBox.getBox_P2());

        Box_P2.printBox(intBox);
        Box_P2.printBox(strBox);

        NumberBox_P2<Integer> numberBox = new NumberBox_P2<>(100);
        NumberBox_P2<Double> doubleBox = new NumberBox_P2<>(99.99);

        Box_P2.printNumberBox(numberBox);
        Box_P2.printNumberBox(doubleBox);

        // -- Part 3: Library with Book_P3 and Dvd_P3 demonstration --
        //Library_P3<Book_P3> bookLibrary = new Library_P3<>(new Book_P3());
        Library_P3 <Book_P3> bookLibrary = new Library_P3<>(new Book_P3());
        bookLibrary.addItem(new Book_P3("Java for Dummies"));
        bookLibrary.addItem(new Book_P3("Java Programming"));
        System.out.println("Books in Library:");
        System.out.print(bookLibrary.toString());

        System.out.println(bookLibrary.findItemByName("Java Programming"));

        
        bookLibrary.removeItem(new Book_P3("Java for Dummies"));
        System.out.println("Books after removal:");
        System.out.print(bookLibrary.toString());
    }
}