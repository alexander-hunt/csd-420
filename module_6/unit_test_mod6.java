import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class unit_test_mod6 {

    public static void main(String[] args) {
        try {
            testComparableInterface();
            testComparatorInterface();
            System.out.println("All module_6 tests passed.");
        } catch (AssertionError error) {
            System.err.println(error.getMessage());
            System.exit(1);
        }
    }

    private static void testComparableInterface() {
        String actual = captureOutput(() -> comparable_interface.main(new String[0]));
        String expected = new StringBuilder()
                .append("Before sorting:")
                .append(System.lineSeparator())
                .append("[5, 3, 4, 9, 0, 1, 2, 7, 6, 8]")
                .append(System.lineSeparator())
                .append("After sorting with Comparable:")
                .append(System.lineSeparator())
                .append("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]")
                .append(System.lineSeparator())
                .toString();

        assertEquals("comparable_interface output mismatch", expected, actual);
    }

    private static void testComparatorInterface() {
        String actual = captureOutput(() -> comparator_interface.main(new String[0]));
        String expected = new StringBuilder()
                .append("Before sorting:")
                .append(System.lineSeparator())
                .append("[5, 3, 4, 9, 0, 1, 2, 7, 6, 8]")
                .append(System.lineSeparator())
                .append("After sorting with Comparator:")
                .append(System.lineSeparator())
                .append("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]")
                .append(System.lineSeparator())
                .toString();

        assertEquals("comparator_interface output mismatch", expected, actual);
    }

    private static String captureOutput(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (PrintStream capture = new PrintStream(buffer, true, StandardCharsets.UTF_8)) {
            System.setOut(capture);
            action.run();
        } finally {
            System.setOut(originalOut);
        }
        return buffer.toString(StandardCharsets.UTF_8);
    }

    private static void assertEquals(String message, String expected, String actual) {
        if (!expected.equals(actual)) {
            String fullMessage = message + System.lineSeparator()
                    + "Expected:" + System.lineSeparator()
                    + expected
                    + "Actual:" + System.lineSeparator()
                    + actual;
            throw new AssertionError(fullMessage);
        }
    }
}
