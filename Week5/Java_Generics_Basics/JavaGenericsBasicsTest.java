import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JavaGenericsBasicsTest {

    // ---------- Normal tests ----------

    @Test
    void normal_stringProcessor_reversesString() {
        StringProcessor_P1 processor = new StringProcessor_P1();
        assertEquals("cireneG avaJ", processor.process("Java Generic"));
    }

    @Test
    void normal_box_storesAndRetrievesDifferentTypes() {
        Box_P2<Integer> intBox = new Box_P2<>();
        intBox.setBox_P2(42);

        Box_P2<String> stringBox = new Box_P2<>("Hello Generics");

        assertEquals(42, intBox.getBox_P2());
        assertEquals("Hello Generics", stringBox.getBox_P2());
    }

    @Test
    void normal_library_addFindAndRemoveBook() {
        Library_P3<Book_P3> library = new Library_P3<>(new Book_P3("Starter Book"));
        Book_P3 cleanCode = new Book_P3("Clean Code");
        Book_P3 effectiveJava = new Book_P3("Effective Java");

        library.addItem(cleanCode);
        library.addItem(effectiveJava);

        assertEquals(cleanCode.toString(), library.findItemByName("Clean Code").toString());

        library.removeItem(cleanCode);
        assertNull(library.findItemByName("Clean Code"));
        assertEquals(effectiveJava.toString(), library.findItemByName("Effective Java").toString());
    }

    // ---------- Edge tests ----------

    @Test
    void edge_stringProcessor_returnsNullForNullInput() {
        StringProcessor_P1 processor = new StringProcessor_P1();
        assertNull(processor.process(null));
    }

    @Test
    void edge_box_rejectsEmptyString() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Box_P2<String>(""));
        assertEquals("String value cannot be null", ex.getMessage());
    }

    @Test
    void edge_library_rejectsEmptySearchName() {
        Library_P3<Book_P3> library = new Library_P3<>(new Book_P3("Starter Book"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> library.findItemByName(""));
        assertEquals("Name cannot be null", ex.getMessage());
    }
}
