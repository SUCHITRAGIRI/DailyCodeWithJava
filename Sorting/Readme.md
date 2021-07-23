# Sorting
1. Stable 
2. Unstable

## Note : A sorting algorithm is stable, if the order of equal elements in the input array remains the same in the output array.

## Stable Sort :
1. Bubble Sort
2. Insertion Sort
3. Merge Sort
4. Count Sort
5. Redix Sort
6. Bucket Sort

## Unstable Sort :
1. Selection Sort (but in case of linkedlist it is a stable)
2. Quick Sort
3. Heap Sort

## Adaptive :
If order of the elements to be sorted of an input array matters (or) affects the time complexity of a sorting algorithm, then that algorithm is called “Adaptive” sorting algorithm.

For example, Insertion sort is an adaptive sorting algorithm, if input is already sorted then time complexity will be O(n). Therefore If input is nearly sorted then go for insertion sort, though this is not the only parameter to go for Insertion sort over other sorting algorithms.

Merge Sort is an “Non-Adaptive” Sorting algorithm, because the order of the elements in the input array doesn’t matter, time complexity will always be O(nlogn).

## Adaptive sorting algorithms:
1. Bubble Sort
2. Insertion Sort
3. Quick Sort

## Non-adaptive sorting algorithms:
1. Selection Sort
2. Merge Sort
