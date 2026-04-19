import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UnitTestWordOrchestrator {
    // Executes all unit tests and prints pass/fail results to the console.
    public static void main(String[] args) {
        UnitTestWordOrchestrator test = new UnitTestWordOrchestrator();
        test.testMain();
        test.testGatherWords();
        test.testDisplayWords();
        System.out.println("testMain passed");
        System.out.println("testGatherWords passed");
        System.out.println("testDisplayWords passed");
    }

    // Verifies that WordOrchestrator.main() produces the expected output for both ascending and descending word lists.
    public void testMain() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
        try (PrintStream testOut = new PrintStream(capturedOut)) {
            System.setOut(testOut);
            WordOrchestrator.main(new String[0]);
        } finally {
            System.setOut(originalOut);
        }

        String actual = capturedOut.toString().replace("\r\n", "\n");
        String expected = "Ascending Order:\n"
                + "algorithm\n"
                + "cloud\n"
                + "computer\n"
                + "computing\n"
                + "data\n"
                + "database\n"
                + "development\n"
                + "java\n"
                + "network\n"
                + "programming\n"
                + "science\n"
                + "security\n"
                + "software\n"
                + "structure\n"
                + "\n"
                + "Descending Order:\n"
                + "structure\n"
                + "software\n"
                + "security\n"
                + "science\n"
                + "programming\n"
                + "network\n"
                + "java\n"
                + "development\n"
                + "database\n"
                + "data\n"
                + "computing\n"
                + "computer\n"
                + "cloud\n"
                + "algorithm\n";

        if (!expected.equals(actual)) {
            throw new AssertionError("Output did not match expected.\nExpected:\n" + expected + "\nActual:\n" + actual);
        }
    }

    // Confirms that gatherWords() correctly reads and stores exactly 14 unique words from the input file.
    public void testGatherWords() {
        try {
            WordOrchestrator orchestrator = new WordOrchestrator("collection_of_words.txt");
            java.lang.reflect.Method gatherMethod = WordOrchestrator.class.getDeclaredMethod("gatherWords");
            gatherMethod.setAccessible(true);
            gatherMethod.invoke(orchestrator);

            java.lang.reflect.Field field = WordOrchestrator.class.getDeclaredField("collectionOfWords");
            field.setAccessible(true);
            @SuppressWarnings("unchecked")
            java.util.TreeSet<String> actualWords = (java.util.TreeSet<String>) field.get(orchestrator);

            java.util.TreeSet<String> expectedWords = new java.util.TreeSet<>();
            expectedWords.add("algorithm");
            expectedWords.add("cloud");
            expectedWords.add("computer");
            expectedWords.add("computing");
            expectedWords.add("data");
            expectedWords.add("database");
            expectedWords.add("development");
            expectedWords.add("java");
            expectedWords.add("network");
            expectedWords.add("programming");
            expectedWords.add("science");
            expectedWords.add("security");
            expectedWords.add("software");
            expectedWords.add("structure");

            if (!expectedWords.equals(actualWords)) {
                throw new AssertionError("collectionOfWords did not match expected set.\nExpected: " + expectedWords + "\nActual: " + actualWords);
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    // Validates that displayWords() returns correctly formatted word lists in both ascending and descending order.
    public void testDisplayWords() {
        try {
            WordOrchestrator orchestrator = new WordOrchestrator("collection_of_words.txt");
            java.lang.reflect.Method gatherMethod = WordOrchestrator.class.getDeclaredMethod("gatherWords");
            gatherMethod.setAccessible(true);
            gatherMethod.invoke(orchestrator);

            java.lang.reflect.Method displayMethod = WordOrchestrator.class.getDeclaredMethod("displayWords", boolean.class);
            displayMethod.setAccessible(true);

            String actualAscending = ((String) displayMethod.invoke(orchestrator, true)).replace("\r\n", "\n");
            String expectedAscending = "algorithm\n"
                    + "cloud\n"
                    + "computer\n"
                    + "computing\n"
                    + "data\n"
                    + "database\n"
                    + "development\n"
                    + "java\n"
                    + "network\n"
                    + "programming\n"
                    + "science\n"
                    + "security\n"
                    + "software\n"
                    + "structure\n";

            if (!expectedAscending.equals(actualAscending)) {
                throw new AssertionError("Ascending display output did not match expected.\nExpected:\n" + expectedAscending + "\nActual:\n" + actualAscending);
            }

            String actualDescending = ((String) displayMethod.invoke(orchestrator, false)).replace("\r\n", "\n");
            String expectedDescending = "structure\n"
                    + "software\n"
                    + "security\n"
                    + "science\n"
                    + "programming\n"
                    + "network\n"
                    + "java\n"
                    + "development\n"
                    + "database\n"
                    + "data\n"
                    + "computing\n"
                    + "computer\n"
                    + "cloud\n"
                    + "algorithm\n";

            if (!expectedDescending.equals(actualDescending)) {
                throw new AssertionError("Descending display output did not match expected.\nExpected:\n" + expectedDescending + "\nActual:\n" + actualDescending);
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
