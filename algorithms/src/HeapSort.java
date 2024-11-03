import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Testing{

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,5,9,2,6,2,82,4,5));
        heapsort(arr);
        arr.forEach(x-> System.out.println("->" + x));
    }

    private static void heapsort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for(int i=n-1;i>=0;i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    static void heapify(ArrayList<Integer> arr, int n, int i) {
        int largest = i;
        int l = 2*i+1;
        int r = 2* i +2;

        if(l<n && arr.get(l) > arr.get(largest)) {
            largest = l;
        }

        if(r<n && arr.get(r) > arr.get(largest)) {
            largest = r;
        }

        if(largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }

    }
  
    static void swap(ArrayList<Integer> arr, int i, int j) {
           int temp = arr.get(i);
           arr.set(i, arr.get(j));
           arr.set(j, temp);
    }
}

