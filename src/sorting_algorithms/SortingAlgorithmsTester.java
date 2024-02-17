//Tommy Hudson Tester for the sorting algorithms

package sorting_algorithms;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class to test the sorting algorithms
 */
public class SortingAlgorithmsTester 
{
    
    /**
     * Method to test each of the sorting algorithms in the package by number of comparisons and runtime in nano seconds
     * @param args Command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        SortingAlgorithms sa = new SortingAlgorithms();
        //Arrays to store the random numbers that will hold the exact same numbers for each sorting algorithm
        ArrayList<Integer> arrOriginal = new ArrayList<>();
        ArrayList<Integer> arrSorting = new ArrayList<>();
        //Welcome the user to the program, create the arrays, then present menu to user
        sa.welcome();
        sa.createArrays(in, arrOriginal, arrSorting);
        int choice = 0;
        String answer = "";
        while (choice != 'Q')
        {
             
            //Create an instance of all of the sorting algorithm classes and the SortingAlgorithms class
            SelectionSort ss = new SelectionSort();
            InsertionSort is = new InsertionSort();
            ShellSort shs = new ShellSort();
            QuickSort qs = new QuickSort();
            MergeSort ms = new MergeSort();
            RadixSort rs = new RadixSort();
            HeapSort hs = new HeapSort();
            NaturalMergeSort nms = new NaturalMergeSort();
            BubbleSort bs = new BubbleSort();
            CombSort cs = new CombSort();
            //Variables to hold time values
            long timeStart = 0, timeEnd = 0;
            
            
            choice = sa.mainMenu(in);
            switch (choice)
            {
                case 1:
                    choice = sa.algorithmMenu(in);
                    switch (choice)
                    {
                        case 1:
                            System.out.println("\nBubble Sort");
                            timeStart = System.nanoTime();
                            bs.bubbleSort(arrSorting);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Swaps: " + bs.swapCount);
                            System.out.println("Comparisons: " + bs.comparisonCount);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 2:
                            System.out.println("\nSelection Sort");
                            timeStart = System.nanoTime();
                            ss.selectionSort(arrSorting);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Swaps: " + ss.swapCount);
                            System.out.println("Comparisions: " + ss.comparisonCount);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 3:
                            System.out.println("\nInsertion Sort");
                            timeStart = System.nanoTime();
                            is.insertionSort(arrSorting);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Swaps: " + is.swapCount);
                            System.out.println("Comparisons: " + is.comparisonCount);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 4:
                            System.out.println("\nShell Sort");
                            ArrayList<Integer> gapList = shs.findGapValues(arrSorting.size());
                            timeStart = System.nanoTime();
                            shs.shellSort(arrSorting, gapList);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Gap Values Used: " + gapList.toString());
                            System.out.println("Swaps: " + shs.swapCount);
                            System.out.println("Comparisons: " + shs.comparisonCount);
                            System.out.println();
                            gapList.clear();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 5:
                            System.out.println("\nComb Sort");
                            timeStart = System.nanoTime();
                            cs.combSort(arrSorting);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Swaps: " + cs.swapCount);
                            System.out.println("Comparisons: " + cs.comparisonCount);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 6:
                            System.out.println("\nQuick Sort");
                            timeStart = System.nanoTime();
                            qs.quickSort(arrSorting, 0, arrSorting.size() - 1);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                                System.out.println();
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Swaps: " + qs.swapCount);
                            System.out.println("Comparisons: " + qs.comparisonCount);
                            System.out.println("Recursive Calls: " + qs.recursiveCount);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 7:
                            System.out.println("\nMerge Sort");
                            timeStart = System.nanoTime();
                            ms.mergeSort(arrSorting, 0, arrSorting.size() - 1);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Swaps: " + ms.swapCount);
                            System.out.println("Comparisons: " + ms.comparisonCount);
                            System.out.println("Recursive Calls: " + ms.recursiveCount);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 8:
                            System.out.println("\nNatural Merge Sort");
                            timeStart = System.nanoTime();
                            nms.naturalMergeSort(arrSorting);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Swaps: " + nms.swapCount);
                            System.out.println("Comparisons: " + nms.comparisonCount);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 9:
                            System.out.println("\nHeap Sort");
                            timeStart = System.nanoTime();
                            hs.heapSort(arrSorting);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Swaps: " + hs.swapCount);
                            System.out.println("Comparisons: " + hs.comparisonCount);
                            System.out.println("Recursive Calls: " + hs.recursiveCount);
                            System.out.println("Heapify Calls: " + hs.heapifyCount);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                        case 10:
                            System.out.println("\nRadix Sort");
                            timeStart = System.nanoTime();
                            rs.radixSort(arrSorting);
                            timeEnd = System.nanoTime();
                            System.out.print("\nPrint Sorted Array? (y/n): ");
                            answer = in.next();
                            if (answer.toUpperCase().charAt(0) == 'Y')
                            {
                                System.out.print("\nSorted array: ");
                                sa.printArray(arrSorting);
                            }
                            System.out.println("\nTime: " + (timeEnd-timeStart) + " nanoseconds");
                            System.out.println("Digit Iterations: " + rs.digitIterations);
                            System.out.println("Get Length Iterations: " + rs.getLengthIterations);
                            System.out.println("Bucket Assignments: " + rs.bucketAssignments);
                            System.out.println("Max Length Comparisons: " + rs.maxLengthComparisons);
                            System.out.println();
                            sa.restoreSortedArray(arrOriginal, arrSorting);
                            break;
                    }
                    break;
                case 2:
                    choice = sa.arrayMenu(in);
                    switch (choice)
                    {
                        case 1:
                            System.out.print("Original array: ");
                            sa.printArray(arrOriginal);
                            System.out.println();
                            break;
                        case 2:
                            arrOriginal.clear(); arrSorting.clear();
                            sa.createArrays(in, arrOriginal, arrSorting);
                            break;
                        case 3:
                            sa.createSortedArray(arrOriginal, arrSorting);
                            System.out.println("\nArrays have been sorted.\n");
                            break;
                    }
                    break;
                
            }
            
        }
        in.close();
    }
    
}