public class ClickCounterTest {

    private static int testsPassed = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {
        System.out.println("Running ClickCounter tests...\n");

        // Normal test cases
        testInitialState();
        testSingleClick();
        testMultipleClicks();

        // Edge test cases
        testRapidClicks();
        testLargeNumberOfClicks();
        testWindowTitleAndSize();

        System.out.println("\n---------------------------");
        System.out.println("Tests passed: " + testsPassed);
        System.out.println("Tests failed: " + testsFailed);
        System.out.println("---------------------------");

        if (testsFailed == 0) {
            System.out.println("All test cases PASSED.");
        } else {
            System.out.println("Some test cases FAILED.");
        }
    }

    // ---------- Utility methods ----------

    private static void assertEquals(String testName, Object expected, Object actual) {
        if (expected.equals(actual)) {
            System.out.println("[PASS] " + testName);
            testsPassed++;
        } else {
            System.out.println("[FAIL] " + testName);
            System.out.println("       Expected: " + expected);
            System.out.println("       Actual:   " + actual);
            testsFailed++;
        }
    }

    private static void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
            testsPassed++;
        } else {
            System.out.println("[FAIL] " + testName);
            testsFailed++;
        }
    }

    // ---------- Normal test cases ----------

    private static void testInitialState() {
        ClickCounter app = new ClickCounter();

        assertEquals(
            "Initial count should be 0",
            0,
            app.getCount()
        );

        assertEquals(
            "Initial label should show 0",
            "Number of clicks: 0",
            app.getLabelText()
        );

        app.dispose();
    }

    private static void testSingleClick() {
        ClickCounter app = new ClickCounter();

        app.simulateButtonClick();

        assertEquals(
            "Count should be 1 after one click",
            1,
            app.getCount()
        );

        assertEquals(
            "Label should update to 1 after one click",
            "Number of clicks: 1",
            app.getLabelText()
        );

        app.dispose();
    }

    private static void testMultipleClicks() {
        ClickCounter app = new ClickCounter();

        for (int i = 0; i < 5; i++) {
            app.simulateButtonClick();
        }

        assertEquals(
            "Count should be 5 after five clicks",
            5,
            app.getCount()
        );

        assertEquals(
            "Label should update to 5 after five clicks",
            "Number of clicks: 5",
            app.getLabelText()
        );

        app.dispose();
    }

    // ---------- Edge test cases ----------

    private static void testRapidClicks() {
        ClickCounter app = new ClickCounter();

        for (int i = 0; i < 20; i++) {
            app.simulateButtonClick();
        }

        assertEquals(
            "Count should handle rapid clicks correctly",
            20,
            app.getCount()
        );

        assertEquals(
            "Label should handle rapid clicks correctly",
            "Number of clicks: 20",
            app.getLabelText()
        );

        app.dispose();
    }

    private static void testLargeNumberOfClicks() {
        ClickCounter app = new ClickCounter();

        for (int i = 0; i < 100; i++) {
            app.simulateButtonClick();
        }

        assertEquals(
            "Count should handle 100 clicks correctly",
            100,
            app.getCount()
        );

        assertEquals(
            "Label should show 100 after 100 clicks",
            "Number of clicks: 100",
            app.getLabelText()
        );

        app.dispose();
    }

    private static void testWindowTitleAndSize() {
        ClickCounter app = new ClickCounter();

        assertEquals(
            "Window title should be correct",
            "My Click Counter",
            app.getTitle()
        );

        assertTrue(
            "Window width should be 300",
            app.getWidth() == 300
        );

        assertTrue(
            "Window height should be 200",
            app.getHeight() == 200
        );

        app.dispose();
    }
}
