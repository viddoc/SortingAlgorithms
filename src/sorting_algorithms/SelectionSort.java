//Tommy Hudson SelectionSort class

package sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Class to implement the selection sort algorithm
 */
public class SelectionSort 
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int comparisonCount = 0;
    public int swapCount = 0;
    /**
     * Method to sort an array using the selection sort algorithm
     * @param arr The array to be sorted
     * @return The number of comparisons made
     */
    public void selectionSort(ArrayList<Integer> arr)
    {
        //Traverse through the array
        for (int i = 0; i < arr.size()-1; ++i)
        {
            int min = i;
            //Find the minimum element in the unsorted part of the array
            for (int j = i+1; j < arr.size(); ++j)
            {
                //Set min to the index of the smallest element
                if (arr.get(j) < arr.get(min))
                {
                    min = j;
                }
                comparisonCount++;
            }
            Collections.swap(arr, min, i);
            swapCount++;
        }
    }
}
