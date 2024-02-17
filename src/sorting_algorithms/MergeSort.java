//Tommy Hudson MergeSort class

package sorting_algorithms;

import java.util.ArrayList;
/**
 * Class to implement the merge sort algorithm
 */
public class MergeSort 
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int swapCount = 0;
    public int comparisonCount = 0;
    public int recursiveCount = 0;
    
    /**
     * Method to merge left and right arrays for the merge sort algorithm
     * @param arr The array to be sorted
     * @param i The starting index of the portion of the array to be merged
     * @param j The middle index of the portion of the array to be merged
     * @param k The ending index of the portion of the array to be merged
     */
    public void merge(ArrayList<Integer> arr, int i, int j, int k)
    {
        int mergedSize = k - i + 1;     // Size of merged partition
        int mergePos = 0;            // Position to insert merged number
        int leftPos = 0;         // Position of elements in left partition
        int rightPos = 0;     // Position of elements in right partition
        int[] mergedNumbers = new int[mergedSize];  // Dynamically allocates temporary array for merged numbers
        leftPos = i;     // Initialize left partition position
        rightPos = j + 1;   // Initialize right partition position
        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= j && rightPos <= k)
        {
            comparisonCount++;
            // If the element in the left partition is smaller than the element in the right partition
            if (arr.get(leftPos) < arr.get(rightPos))
            {
                mergedNumbers[mergePos] = arr.get(leftPos);
                ++leftPos;
            }
            // If the element in the right partition is smaller than the element in the left partition
            else
            {
                mergedNumbers[mergePos] = arr.get(rightPos);
                ++rightPos;
            }
            ++mergePos;
        }
        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j)
        {
            mergedNumbers[mergePos] = arr.get(leftPos);
            ++leftPos;
            ++mergePos;
        }
        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k)
        {
            mergedNumbers[mergePos] = arr.get(rightPos);
            ++rightPos;
            ++mergePos;
        }
        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos)
        {
            arr.set(i + mergePos, mergedNumbers[mergePos]);
            ++swapCount;}
        }
    /**
     * Method to sort the array using merge sort
     * @param arr The array to be sorted
     * @param i The starting index of the portion of the array to be sorted
     * @param k The ending index of the portion of the array to be sorted
     */
    public void mergeSort(ArrayList<Integer> arr, int i, int k)
    {
        recursiveCount++;
        // If the portion of the array to be sorted has more than one element
        if (i < k)
        {
            int j = (i + k) / 2;    // Find the midpoint in the array
            mergeSort(arr, i, j);   // Sort the left partition
            mergeSort(arr, j+1, k); // Sort the right partition
            merge(arr, i, j, k);    // Merge the left and right partitions
        }
    }
}
