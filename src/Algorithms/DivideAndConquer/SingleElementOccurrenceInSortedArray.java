package Algorithms.DivideAndConquer;

/**
 * Created by astik on 04-05-2016.
 * Given sorted array with all but one single occurrence rest all double occurrence
 * answer inspired by binary search log(n) time
 * simple approach would be to traverse linearly and compare adjacent elements O(N)
 */
public class SingleElementOccurrenceInSortedArray {

    private int getSingleOccurrence(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(start <= end){

            mid = (start + end)/2;
            if (mid ==0 || mid == arr.length-1)
                    return mid;
            else if (arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1] )
                    return mid;

            if ( mid % 2 == 0)
                if (arr[mid] == arr[mid+1])
                    start = mid + 1;
                else
                    end = mid-1;
            else
                if (arr[mid] == arr[mid+1])
                    end = mid - 1;
                else
                    start = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {0,1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        SingleElementOccurrenceInSortedArray obj = new SingleElementOccurrenceInSortedArray();
        System.out.println(obj.getSingleOccurrence(arr));
    }
}
