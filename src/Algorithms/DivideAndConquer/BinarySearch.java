package Algorithms.DivideAndConquer;

/**
 * Created by astik on 03-05-2016.
 * binary search is a classic example of Divide and conquer algorithms
 */
public class BinarySearch {
    private int binarySearch(int[] array, int key){
        int start = 0;
        int end = array.length-1;
        int mid;
        while( start <= end ) {
            mid = (start + end) / 2;
            if (array[mid] == key)
                return mid;
            if (key < array[mid])
                end = mid - 1;
            if (key > array[mid])
                start = mid + 1;
        }
            System.out.println("Element not found");
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {10,20,30,40,50,60,70};
        int key = 80;
        BinarySearch b = new BinarySearch();
        System.out.println(b.binarySearch(array, key));
    }
}
