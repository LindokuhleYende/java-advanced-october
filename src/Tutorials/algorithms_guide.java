// ============================================================================
// SORTING ALGORITHMS
// ============================================================================

class SortingAlgorithms {
    
    // 1. BUBBLE SORT
    // Time: O(n²) | Space: O(1)
    // Repeatedly swaps adjacent elements if they're in wrong order
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: already sorted
        }
    }
    
    // 2. SELECTION SORT
    // Time: O(n²) | Space: O(1)
    // Finds minimum element and places it at beginning
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }
    
    // 3. INSERTION SORT
    // Time: O(n²) | Space: O(1)
    // Builds sorted array one item at a time
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    // 4. MERGE SORT
    // Time: O(n log n) | Space: O(n)
    // Divide and conquer - divides array and merges sorted halves
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for (int i = 0;