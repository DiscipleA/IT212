import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    // =========================
    // Normal Test Cases
    // =========================

    // Test normal addition
    @Test
    public void testAddNormal() {
        assertEquals(8, MathUtils.add(5, 3));
    }

    // Test normal subtraction
    @Test
    public void testSubtractNormal() {
        assertEquals(6, MathUtils.subtract(10, 4));
    }

    // Test normal multiplication
    @Test
    public void testMultiplyNormal() {
        assertEquals(12, MathUtils.multiply(6, 2));
    }

    // =========================
    // Edge Test Cases
    // =========================

    // Test division by zero
    @Test
    public void testDivideByZero() {
        assertTrue(Double.isNaN(MathUtils.divide(5, 0)));
    }

    // Test adding zeros
    @Test
    public void testAddZeroValues() {
        assertEquals(0, MathUtils.add(0, 0));
    }

    // Test subtracting to get a negative result
    @Test
    public void testSubtractNegativeResult() {
        assertEquals(-5, MathUtils.subtract(0, 5));
    }
}