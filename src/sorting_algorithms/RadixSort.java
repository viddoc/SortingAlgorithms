package sorting_algorithms;

import java.util.ArrayList;
/**
 * Class to implement the radix sort algorithm
 */
public class RadixSort 
{
    //Global variables to hold the number of swaps and comparisons for benchmarking purposes
    public int digitIterations = 0;
    public int bucketAssignments = 0;
    public int maxLengthComparisons = 0;
    public int getLengthIterations = 0;
    
    /**
     * Method to sort an array using the radix sort algorithm
     * @param arr The array to be sorted
     */
    public void radixSort(ArrayList<Integer> arr)
    {
       ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
       //Create 10 buckets
       for (int i = 0; i < 10; ++i)
       {
           buckets.add(i, new ArrayList<Integer>());
       }

        //Find the max length in number of digits
        int maxDigits = radixGetMaxLength(arr);

        //Start with the least significant digit and work up
        int pow10 = 1;
        //For each digit
        for (int digitIndex = 0; digitIndex < maxDigits; ++digitIndex)
        {
            digitIterations++;
            //Put each number in a bucket based on the current digit
            for (Integer num : arr) {
                int bucketIndex = (num / pow10) % 10;
                buckets.get(bucketIndex).add(num);
                bucketAssignments++;
            }
            int arrIndex = 0;
            //Put the numbers back in the array in order
            for (ArrayList<Integer> bucket : buckets)
            {
                for (Integer num : bucket)
                {
                    arr.set(arrIndex++, num);
                }
                bucket.clear();
            }
            //Move to the next digit by multiplying by 10
            pow10 *= 10;
        }
    }
    /**
     * Method to get the length in number of digits of the max number in the array
     * @param arr The array to be checked
     * @return The number of digits in the max number
     */
    public int radixGetMaxLength(ArrayList<Integer> arr)
    {
        int maxDigits = 0;
        //For each number in the array
        for (int i = 0; i < arr.size(); ++i)
        {
            int digitCount = radixGetLength(arr.get(i));
            if (digitCount > maxDigits)
            {
                maxDigits = digitCount;
                maxLengthComparisons++; 
            }
        }
        return maxDigits;
    }

    /**
     * Method to get the length in number of digits of a number
     * @param num The number to be checked
     * @return The number of digits in the number
     */
    public int radixGetLength(int num)
    {
        //If the number is 0, it has 1 digit
        if (num == 0)
        {
            return 1;
        }
        int digits = 0;
        //While the number is not 0
        while (num != 0)
        {
            num /= 10;
            ++digits;
            getLengthIterations++;
        }
        return digits;
    }    
}

