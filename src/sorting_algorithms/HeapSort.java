//Tommy Hudson HeapSort class

package sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class to implement the heap sort algorithm
 */
public class HeapSort 
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int comparisonCount = 0;
    public int swapCount = 0;
    public int recursiveCount = 0;
    public int heapifyCount = 0;
    /**
     * Method to sort an array using the heap sort algorithm
     * @param arr The array to be sorted
     * @return The number of comparisons made
     */
    public void heapSort(ArrayList<Integer> arr)
    {
        //Build the heap
        for (int i = arr.size()/2 - 1; i >= 0; --i)
        {
            heapify(arr, arr.size(), i);
        }
        //Extract elements from the heap
        for (int i = arr.size()-1; i > 0; --i)
        {
            Collections.swap(arr, 0, i);
            heapify(arr, i, 0);
            swapCount++;
        }
    }
    /**
     * Method to heapify an array
     * @param arr The array to be heapified
     * @param n The size of the array
     * @param i The index of the array to be heapified
     */
    public void heapify(ArrayList<Integer> arr, int n, int i)
    {
        heapifyCount++;
        //Find the largest element among the root, left child and right child
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        //If the left child is larger than the root
        if (l < n && arr.get(l) > arr.get(largest))
        {
            largest = l;
            comparisonCount++;
        }
        //If the right child is larger than the root
        if (r < n && arr.get(r) > arr.get(largest))
        {
            largest = r;
            comparisonCount++;
        }
        //If the largest is not the root
        if (largest != i)
        {
            Collections.swap(arr, i, largest);
            heapify(arr, n, largest);
            swapCount++;
            recursiveCount++;
        }
    }
}
