//https://practice.geeksforgeeks.org/problems/quick-sort/1/?track=dsa-workshop-1-search-sort&batchId=308

class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
    if(low < high){
        int pivote = partition(arr, low, high);
        quickSort(arr, low, pivote - 1);
        quickSort(arr, pivote + 1, high);
    }
    }
    static int partition(int arr[], int low, int high)
    {
        int pivote = arr[high];
        int i = low - 1;
        
        for(int j = low; j < high; j++){
            if(arr[j] <= pivote){
                i++;
                swap(arr, i, j);
            }
            
        }
        swap(arr, i + 1, high);
      return i + 1;
    } 
    
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

