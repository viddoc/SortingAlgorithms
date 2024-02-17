//Tommy Hudson BubbleSort class

package sorting_algorithms;

import java.util.ArrayList;
/**
 * Class to implement the bubble sort algorithm
 */
public class BubbleSort 
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int comparisonCount = 0;
    public int swapCount = 0;
    /**
     * Method to sort an array using the bubble sort algorithm
     * @param arr The array to be sorted
     */
    public void bubbleSort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        //Traverse through the array
        for (int i = 0; i < n-1; i++)
        {
            //Traverse through the array from 0 to n-i-1
            for (int j = 0; j < n-i-1; j++)
            {
                //Swap if the element found is greater than the next element
                if (arr.get(j) > arr.get(j+1))
                {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                    swapCount++;
                }
                comparisonCount++;
            }
        }
    }
}
