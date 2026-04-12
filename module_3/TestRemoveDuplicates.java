import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class TestRemoveDuplicates {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        LinkedHashSet<E> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        // Fill with 50 random values from 1 to 20
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        System.out.println("Original list:");
        System.out.println(originalList);

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("List after removing duplicates:");
        System.out.println(uniqueList);
    }
}