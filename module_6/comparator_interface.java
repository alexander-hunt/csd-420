import java.util.Arrays;
import java.util.Comparator;

public class comparator_interface {

    public static void main(String[] args) {
        Integer[] values = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        System.out.println("Before sorting:");
        printArray(values);

        bubbleSort(values, Comparator.naturalOrder());

        System.out.println("After sorting with Comparator:");
        printArray(values);
    }

    public static <T> void bubbleSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
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
