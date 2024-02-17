//Tommy Hudson NaturalMergeSort class

package sorting_algorithms;

import java.util.ArrayList;

public class NaturalMergeSort
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int swapCount = 0;
    public int comparisonCount = 0;
    /**
     * Method to get the length of a sorted run in an array
     * @param arr The array to be checked
     * @param startIndex The index to start checking from
     * @return The length of the sorted run
     */
	public int getSortedRunLength(ArrayList<Integer> arr, int startIndex) 
	{
		int arrayLength = arr.size();
        // Check for out-of-bounds start index
		if (startIndex < 0 || startIndex >= arrayLength) {
			return 0;
		}

		// Check for ascending run
        int runLength = 1;
        while (runLength < arrayLength && startIndex + runLength < arrayLength && arr.get(startIndex + runLength - 1) <= arr.get(startIndex + runLength))
		{
           	runLength++;
            
        }

        return runLength;
	}
    /**
     * Method to sort an array using the natural merge sort algorithm
     * @param arr The array to be sorted
     */
	public void naturalMergeSort(ArrayList<Integer> arr) 
	{
        int arrayLength = arr.size();
		int i = 0;
    	while (i < arrayLength) 
		{
            comparisonCount++;
			// Get the length of the first sorted run
			int runLength1 = getSortedRunLength(arr, i);

			// If the first run spans the entire array, we're done
			if (runLength1 == arrayLength) 
			{
				return;
			}

			// If the first run ends at the array's end, restart from the beginning
			if (i + runLength1 == arrayLength) 
			{
				i = 0;
				continue; // Skip to the next iteration to find a new first run
			}

			// Get the length of the second sorted run
			int runLength2 = getSortedRunLength(arr, i + runLength1);

			// Merge the two runs
			merge(arr, i, i + runLength1 - 1, i + runLength1 + runLength2 - 1);
            swapCount++;
			// Update i for the next iteration
			i += runLength1 + runLength2;

			// If the second run ends at the array's end, restart from the beginning
			if (i == arrayLength) 
			{
				i = 0;
			}
		}
	}
	/**
     * Method to merge two sorted partitions of an array
     * @param arr The array to be merged
     * @param leftFirst The index of the first element of the left partition
     * @param leftLast The index of the last element of the left partition
     * @param rightLast The index of the last element of the right partition
     */
	public void merge(ArrayList<Integer> arr, int leftFirst, int leftLast, int rightLast) 
	{
		// Create a temporary array to hold the merged numbers
		int mergedSize = rightLast - leftFirst + 1;
		ArrayList<Integer> mergedNumbers = new ArrayList<Integer>(mergedSize);
		int mergePos = 0;				// Initialize mergedNumbers array position
		int leftPos = leftFirst; 		// Initialize left partition position
		int rightPos = leftLast + 1; 	// Initialize right partition position
      
      // Add smallest element from left or right partition to merged numbers
		while (leftPos <= leftLast && rightPos <= rightLast) 
		{
            comparisonCount++;
			// If the element in the left partition is smaller than the element in the right partition
			if (arr.get(leftPos) <= arr.get(rightPos)) 
			{
				mergedNumbers.add(mergePos, arr.get(leftPos));
				leftPos++;
			}
			// If the element in the right partition is smaller than the element in the left partition
			else 
			{
				mergedNumbers.add(mergePos,arr.get(rightPos));
				rightPos++;
			}
			mergePos++;
		}
      
      // If left partition isn't empty, add remaining elements to mergedNumbers
		while (leftPos <= leftLast) 
		{
            comparisonCount++;
			mergedNumbers.add(mergePos, arr.get(leftPos));
			leftPos++;
			mergePos++;
		}
      
      // If right partition isn't empty, add remaining elements to mergedNumbers
		while (rightPos <= rightLast) 
		{
            comparisonCount++;
			mergedNumbers.add(mergePos, arr.get(rightPos));
			rightPos++;
			mergePos++;
		}
      
      // Copy merged numbers back to numbers
		for (mergePos = 0; mergePos < mergedSize; mergePos++) 
		{
			arr.set(leftFirst + mergePos, mergedNumbers.get(mergePos));
		}
      
      // Free temporary array
		mergedNumbers.clear();
	}
}