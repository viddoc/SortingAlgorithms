//Tommy Hudson CombSort class

package sorting_algorithms;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Class to implement the comb sort algorithm
 */
public class CombSort 
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int comparisonCount = 0;
    public int swapCount = 0;
    /**
     * Method to sort an array using the comb sort algorithm
     * @param arr The array to be sorted
     */
    public void combSort(ArrayList<Integer> arr)
    {
        int n = arr.size();     //Find the size of the array        
        int gap = n;            //Initialize the gap
        double shrink = 1.3;    //Initialize the shrink factor
        boolean swapped = true; //Initialize the swapped flag
        //Loop through the array
        while (gap > 1 || swapped)
        {
            //Shrink the gap
            if (gap > 1)
            {
                gap = (int)(gap / shrink);
            }
            int i = 0;
            //Reset the swapped flag
            swapped = false;
            //Loop through the array
            while (i + gap < n)
            {
                //Swap the elements if they are in the wrong order
                if (arr.get(i) > arr.get(i + gap))
                {
                    Collections.swap(arr, i, i + gap);
                    swapped = true;
                    swapCount++;
                }
                comparisonCount++;
                i++;
            }
        }
    }
}
