//Time complexity: O(NlogN)
//space: O(N)

import java.util.*;

class Solution {
    public int[] merge_sort(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int pivot = input.length / 2;
        int[] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
        int[] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
        return merge(left_list, right_list);
    }

    public int[] merge(int[] left_list, int[] right_list) {
        int[] ret = new int[left_list.length + right_list.length];
        int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

        while (left_cursor < left_list.length && right_cursor < right_list.length) {
            if (left_list[left_cursor] < right_list[right_cursor]) {
                ret[ret_cursor++] = left_list[left_cursor++];
            } else {
                ret[ret_cursor++] = right_list[right_cursor++];
            }
        }
        // append what is remain the above lists
        while (left_cursor < left_list.length) {
            ret[ret_cursor++] = left_list[left_cursor++];
        }
        while (right_cursor < right_list.length) {
            ret[ret_cursor++] = right_list[right_cursor++];
        }
        return ret;
    }
}

class MergeSort {
    public static void main(String args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // call merge sort function
        arr = merge_sort(arr);
        System.out.print(arr);
    }
}

//another approach
class Solution {
    public int[] sortArray(int[] nums) {
        //sort the array using merge sort
        if(nums.length == 1)return nums;

        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] arr, int start, int end){

        if(start < end){
            int mid = start + (end - start) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, mid, start, end);
        }
    }

    void  merge(int[] arr, int mid, int start, int end){

        int l = start, r = mid + 1, i = 0;

        int[] mix = new int[end - start + 1];
        while(l <= mid && r <= end){
            if(arr[l] <= arr[r]){
                mix[i++] = arr[l];
                l++;
            }else {
                mix[i++] = arr[r];
                r++;
            }
        }
        while(l <= mid){
            mix[i++] = arr[l++];
        }

        while(r <= end){
            mix[i++] = arr[r++];
        }

        for(int k = 0; k < mix.length; k++){
            arr[start + k] = mix[k];
        }

    }
}
