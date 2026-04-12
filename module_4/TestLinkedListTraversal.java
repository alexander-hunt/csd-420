import java.util.*;
import java.io.*;

public class TestLinkedListTraversal {
    private LinkedList<Integer> list;
    private int[] sizes = {50000, 500000};
    private String fileName = "results.txt";

    public TestLinkedListTraversal() {
        this.list = new LinkedList<>();
    }

    public void runTests() {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            for (int size : sizes) {
                populateList(size);
                long iteratorTime = timeIteratorTraversal();
                long getTime = timeGetTraversal();
                writeResults(fw, size, iteratorTime, getTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateList(int size) {
        list.clear();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    private long timeIteratorTraversal() {
        long start = System.nanoTime();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
        long end = System.nanoTime();
        return end - start;
    }

    private long timeGetTraversal() {
        long start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end = System.nanoTime();
        return end - start;
    }

    private void writeResults(FileWriter fw, int size, long iteratorTime, long getTime) throws IOException {
        fw.write("Size: " + size + "\n");
        fw.write("Iterator time: " + iteratorTime + " ns\n");
        fw.write("Get time: " + getTime + " ns\n");
        fw.write("\n");
    }

    public static void main(String[] args) {
        TestLinkedListTraversal tester = new TestLinkedListTraversal();
        tester.runTests();
    }
}