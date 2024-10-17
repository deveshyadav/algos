
    static ArrayList<Integer> quick_sort(ArrayList<Integer> arr) {
        int[] arr1 = arr.stream()
               .mapToInt(Integer::intValue)
               .toArray();
               
        sort(arr1, 0, arr.size()-1);
        
        
        
        return  Arrays.stream(arr1)
                 .boxed()
                 .collect(Collectors.toCollection(ArrayList::new));
    }
    
    static void sort(int[] arr, int low, int high) {
        while (low < high) {
            if (high - low < 10) {  // Threshold for switching to insertion sort
                insertionSort(arr, low, high);
                return;
            }
            int pivot = partition(arr, low, high);
            if (pivot - low < high - pivot) {
                sort(arr, low, pivot - 1);
                low = pivot + 1;
            } else {
                sort(arr, pivot + 1, high);
                high = pivot - 1;
            }
        }
    }


 static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];
        swap(arr, mid, high);  // Move pivot to end

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);  // Restore pivot
        return i + 1;
    }
    static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
    
