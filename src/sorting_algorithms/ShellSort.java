//Tommy Hudson ShellSort class
package sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Class to implement the shell sort algorithm
 */
public class ShellSort 
{
    
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int swapCount = 0;
    public int comparisonCount = 0;
    /**
     * Method to sort a portion of an array using the insertion sort algorithm to be used in the shell sort algorithm
     * @param arr The array to be sorted
     * @param start The starting index of the portion of the array to be sorted
     * @param gap The gap value to be used in the shell sort algorithm
     */
    public void insertionSortInterleaved(ArrayList<Integer> arr, int start, int gap)
    {
        int j = 0;
        int i = 0;
        //Traverse through the array
        for (i = start + gap; i < arr.size(); i += gap)
        {
            j = i;
            //Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j > start && arr.get(j) < arr.get(j-gap))
            {
                Collections.swap(arr, j, j-gap);
                j -= gap;
                comparisonCount++;
                swapCount++;
            }
        }
        //Check for necessary final swap
        if (j > start && arr.get(j) < arr.get(j - gap)) 
        {
            Collections.swap(arr, j, j - gap);
            swapCount++;
        }
        comparisonCount++;
    }
    /**
     * Method to sort an array using the shell sort algorithm
     * @param arr The array to be sorted
     * @param gapValues An array of gap values to be used in the shell sort algorithm
     */
    public void shellSort(ArrayList<Integer> arr, ArrayList<Integer> gapList)
    {
        for (int gap : gapList)
        {
            for (int i = 0; i < gap; ++i)
            {
                insertionSortInterleaved(arr, i, gap);
            }
        }
    }

    /**
     * Method to find the gap values for the shell sort algorithm using Pratt's sequence
     * @param size The size of the array to be sorted
     * @return An array of gap values to be used in the shell sort algorithm
     */
    public ArrayList<Integer> findGapValues (int size)
    {
        ArrayList<Integer> gapValues = new ArrayList<Integer>();
        int[] prattSequence = new int[size];
        int prattIndex = 0;
        int prattValue = 1;
        while (prattValue < size)
        {
            prattSequence[prattIndex] = prattValue;
            ++prattIndex;
            prattValue *= 3;
            
            while (prattValue < size)
            {
                prattSequence[prattIndex] = prattValue;
                ++prattIndex;
                prattValue *= 2;
            }
        }
        for (int i = prattIndex - 1; i >= 0; --i)
        {
            gapValues.add(prattSequence[i]);
        }
        return gapValues;
    }
}
