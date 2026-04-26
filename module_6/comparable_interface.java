import java.util.Arrays;

public class comparable_interface {

    public static void main(String[] args) {
        Integer[] values = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        System.out.println("Before sorting:");
        printArray(values);

        bubbleSort(values);

        System.out.println("After sorting with Comparable:");
        printArray(values);
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }
}
