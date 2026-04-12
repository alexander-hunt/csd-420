import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class UnitTestLinkedListTraversal {
    public static void main(String[] args) {
        testConstructor();
        testPopulateList();
        testTimeIteratorTraversal();
        testTimeGetTraversal();
        testWriteResults();
        testRunTests();
        System.out.println("All tests passed!");
    }

    private static void testConstructor() {
        TestLinkedListTraversal tester = new TestLinkedListTraversal();
        try {
            Field listField = TestLinkedListTraversal.class.getDeclaredField("list");
            listField.setAccessible(true);
            LinkedList<Integer> list = (LinkedList<Integer>) listField.get(tester);
            assert list != null;
            assert list.isEmpty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void testPopulateList() {
        TestLinkedListTraversal tester = new TestLinkedListTraversal();
        try {
            Method method = TestLinkedListTraversal.class.getDeclaredMethod("populateList", int.class);
            method.setAccessible(true);
            method.invoke(tester, 10);
            Field listField = TestLinkedListTraversal.class.getDeclaredField("list");
            listField.setAccessible(true);
            LinkedList<Integer> list = (LinkedList<Integer>) listField.get(tester);
            assert list.size() == 10;
            for (int i = 0; i < 10; i++) {
                assert list.get(i) == i;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void testTimeIteratorTraversal() {
        TestLinkedListTraversal tester = new TestLinkedListTraversal();
        try {
            Method populate = TestLinkedListTraversal.class.getDeclaredMethod("populateList", int.class);
            populate.setAccessible(true);
            populate.invoke(tester, 100);
            Method method = TestLinkedListTraversal.class.getDeclaredMethod("timeIteratorTraversal");
            method.setAccessible(true);
            long time = (long) method.invoke(tester);
            assert time > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void testTimeGetTraversal() {
        TestLinkedListTraversal tester = new TestLinkedListTraversal();
        try {
            Method populate = TestLinkedListTraversal.class.getDeclaredMethod("populateList", int.class);
            populate.setAccessible(true);
            populate.invoke(tester, 100);
            Method method = TestLinkedListTraversal.class.getDeclaredMethod("timeGetTraversal");
            method.setAccessible(true);
            long time = (long) method.invoke(tester);
            assert time > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void testWriteResults() {
        try {
            File tempFile = File.createTempFile("test", ".txt");
            try (FileWriter fw = new FileWriter(tempFile)) {
                TestLinkedListTraversal tester = new TestLinkedListTraversal();
                Method method = TestLinkedListTraversal.class.getDeclaredMethod("writeResults", FileWriter.class, int.class, long.class, long.class);
                method.setAccessible(true);
                method.invoke(tester, fw, 100, 1000L, 2000L);
            }
            try (BufferedReader br = new BufferedReader(new FileReader(tempFile))) {
                assert br.readLine().equals("Size: 100");
                assert br.readLine().equals("Iterator time: 1000 ns");
                assert br.readLine().equals("Get time: 2000 ns");
                assert br.readLine().equals("");
            }
            tempFile.delete();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void testRunTests() {
        TestLinkedListTraversal tester = new TestLinkedListTraversal();
        tester.runTests();
    }
}