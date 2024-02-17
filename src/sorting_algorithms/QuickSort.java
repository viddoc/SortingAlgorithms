//Tommy Hudson QuickSort class

package sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Class to implement the quicksort algorithm
 */
public class QuickSort
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int swapCount= 0;
    public int comparisonCount = 0;
    public int recursiveCount = 0;

    /**
     * Method to partition an array for the quicksort algorithm
     * @param arr The array to be partitioned
     * @param lowIndex The starting index of the portion of the array to be partitioned
     * @param highIndex The ending index of the portion of the array to be partitioned
     * @return The index of the pivot value after partitioning
     */
    public int partition(ArrayList<Integer> arr, int lowIndex, int highIndex)
    {
        //Find the midpoint of the array and use it to create the pivot
        int  midpoint = lowIndex + (highIndex -lowIndex) / 2;
        int pivot = arr.get(midpoint);
        
        boolean done = false;
        //Loop through the array
        while (!done)
        {
            //Increment the lowIndex while the value at lowIndex is less than the pivot
            while (lowIndex < highIndex && arr.get(lowIndex) < pivot)
            {
                ++lowIndex;
                comparisonCount++;
            }
            //Decrement the highIndex while the value at highIndex is greater than the pivot
            while (highIndex > lowIndex && arr.get(highIndex) > pivot)
            {
                --highIndex;
                comparisonCount++;
            }
            //If the lowIndex is greater than or equal to the highIndex, the partition is done
            if (lowIndex >= highIndex)
            {
                done = true;
            }
            //Otherwise, swap the values at lowIndex and highIndex
            else
            {
                Collections.swap(arr, lowIndex, highIndex);
                ++lowIndex;
                --highIndex;
                swapCount++;
            }
            
        }
        return highIndex;
    }
    /**
     * Method to sort an array using the quicksort algorithm
     * @param arr The array to be sorted
     * @param lowIndex The starting index of the portion of the array to be sorted
     * @param highIndex The ending index of the portion of the array to be sorted
     */
    public void quickSort(ArrayList<Integer> arr, int lowIndex, int highIndex)
    {
        recursiveCount++;
        if (lowIndex < highIndex)
        {
            int lowEndIndex = partition(arr, lowIndex, highIndex);  //Partition the array
            quickSort(arr, lowIndex, lowEndIndex);                  //Sort the left partition
            quickSort(arr, lowEndIndex + 1, highIndex);             //Sort the right partition
        }
    }
    

}