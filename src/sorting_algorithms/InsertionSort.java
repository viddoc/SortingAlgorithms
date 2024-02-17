//Tommy Hudson InsertionSort class

package sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Class to implement the insertion sort algorithm
 */
public class InsertionSort 
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int comparisonCount = 0;
    public int swapCount = 0;

    /**
     * Method to sort an array using the insertion sort algorithm
     * @param arr The array to be sorted
     * @return The number of comparisons made
     */
    public void insertionSort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        //Traverse through the array
        for (int i = 1; i < n; ++i)
        {
            int j = i;
            //Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j > 0 && arr.get(j) < arr.get(j-1))
            {
                comparisonCount++;
                Collections.swap(arr, j, j-1);
                --j;
                swapCount++;
            }
            
        }
    }
}
