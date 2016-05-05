package DataStructures.Heaps;

/**
 * Created by astik on 03-05-2016.
 * DataStructures.Heaps - Binary tree in array
 *       - provides flexibility of tree data structure
 *       - with access time of arrays
 *
 * size = max size of the heap
 * count = current items in heap
 * array = heap array
 *
 *
 * insertion - add to end of array
 *           - traverse up the array satisfying the heap property at each node
 *
 * delete    - swap the first with last element
 *           - traverse down the array satisfying the heap property at each node
 *
 */
public class MinHeap{

    private int[] array;
    private int size;
    private int count;

    public MinHeap(int size){
        this.size = size;
        array = new int[size];
        this.count = 0;
    }

    private int getLeftChild(int i){
        int left = 2*i + 1;
        if (left > this.count)
            return -1;
        else return left;
    }

    private int getRightChild(int i){
        int right = 2*i + 2;
        if (right > this.count)
            return -1;
        else return right;
    }


    private void percolateDown(int i){
        int left,right,temp,min;
        left = getLeftChild(i);
        right = getRightChild(i);

        if (left != -1 && this.array[left] < this.array[i])
            min = left;
        else
            min = i;
        if (right != -1 && this.array[right] < this.array[min])
            min = right;
        if (min != i){
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
            percolateDown(min);
        }

    }

    private int deleteMin(){
        if(this.count == 0){
            System.out.println("EMPTY HEAP");
            return -1;
        }
        else{
            int temp = this.array[0];
            this.array[0] = this.array[--this.count];
            percolateDown(0);
            return temp;
        }
    }

    private void insertMinHeap(int data){
        if(this.count >= this.size) {
            System.out.println("WARNING HEAP FULL");
            System.out.println("cannot insert " + data);
        }
        else{
            this.array[this.count++] = data;
            int i = this.count-1;
            int temp;
            while(i>0 && this.array[(i-1)/2] > array[i]){
                temp = this.array[i];
                this.array[i] = this.array[(i-1)/2];
                this.array[(i-1)/2] = temp;
                i = (i-1)/2;
            }
        }
    }

    private void printHeap(){
        for(int i=0; i< this.count; i++)
            System.out.print(this.array[i]+ " ");
        System.out.println();
    }

    public static void main(String[] args){
        MinHeap minHeap = new MinHeap(6);
        minHeap.insertMinHeap(10);
        minHeap.insertMinHeap(1);
        minHeap.insertMinHeap(8);
        minHeap.insertMinHeap(5);
        minHeap.insertMinHeap(2);
        minHeap.insertMinHeap(6);
        minHeap.insertMinHeap(7);
        minHeap.printHeap();
        System.out.println(minHeap.deleteMin());
        minHeap.printHeap();
        System.out.println(minHeap.deleteMin());
        minHeap.printHeap();
        System.out.println(minHeap.deleteMin());
        minHeap.printHeap();
        System.out.println(minHeap.deleteMin());
        minHeap.printHeap();
    }
}
