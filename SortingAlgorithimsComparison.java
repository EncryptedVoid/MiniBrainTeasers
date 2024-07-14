import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        int[] array = generateRandomArray(10);

        System.out.println("Original array: " + Arrays.toString(array));

        int[] bubbleArray = array.clone();
        int[] randomArray = array.clone();
        int[] mergeArray = array.clone();

        System.out.println("\nBubble Sort:");
        long bubbleStartTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long bubbleEndTime = System.nanoTime();
        System.out.println("Total time: " + (bubbleEndTime - bubbleStartTime) + " ns");

        System.out.println("\nRandom Sort:");
        long randomStartTime = System.nanoTime();
        randomSort(randomArray);
        long randomEndTime = System.nanoTime();
        System.out.println("Total time: " + (randomEndTime - randomStartTime) + " ns");

        System.out.println("\nMerge Sort:");
        long mergeStartTime = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        long mergeEndTime = System.nanoTime();
        System.out.println("Total time: " + (mergeEndTime - mergeStartTime) + " ns");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100); // Random integers between 0 and 99
        }
        return array;
    }

    // Bubble Sort
    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // Print array after each iteration
            System.out.println("Iteration " + (i + 1) + ": " + Arrays.toString(array));
            if (!swapped) break; // If no two elements were swapped, break
        }
    }

    // Random Sort (Bogosort)
    private static void randomSort(int[] array) {
        Random rand = new Random();
        while (!isSorted(array)) {
            for (int i = 0; i < array.length; i++) {
                int randomIndex = rand.nextInt(array.length);
                int temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }
            // Print array after each iteration
            System.out.println("Iteration: " + Arrays.toString(array));
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Merge Sort
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);

            // Print array after merging
            System.out.println("Merging: " + Arrays.toString(array));
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = array[left + i];
        for (int j = 0; j < n2; j++) R[j] = array[middle + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
