//Tommy Hudson SortingAlgorithms class that builds the menu and runs the program for the tester
package sorting_algorithms;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class to test various sorting algorithms
 */
public class SortingAlgorithms 
{
    public static final String BOLD = "\u001b[1m";
    public static final String UNDERLINE = "\u001b[4m";
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * Method to welcome the user to the program
     */
    public void welcome()
    {
        System.out.println();
        System.out.println(BOLD + UNDERLINE + "\t\t\t\t\tSorting Algorithms Tester\n" + ANSI_RESET);
        System.out.println("This program allows you to test various sorting algorithms by comparing the number of comparisons made and the runtime in nano seconds.");
        System.out.println("Once you choose the size of the array to be tested and the upper bound of the random numbers the array will be created and can then be tested.");
        System.out.println("Each sorting algorithm will be tested on the same array to ensure a fair comparison. The array can be modified to use a sorted array or a new array.");
        System.out.println("The sorting algorithms can be found in the Sorting Algorithm Menu and the array can be viewed or modified using the Array Menu.\n\n\n");
    }
    /**
     * Method to display the menu to the user
     * @param in The scanner object to read the user's choice
     * @return The user's choice
     */
    public int mainMenu(Scanner in)
    {
        System.out.println("\n\n");
        System.out.println(BOLD + UNDERLINE + "\t\tMain Menu" + ANSI_RESET);
        System.out.println("1.  Sorting Algorithm Menu");
        System.out.println("2.  Array Menu");
        System.out.println("Q.  Exit");
        System.out.print("Please choose an option: ");
        //Ensure the user enters an integer
        int choice = 0;
        choice = validateChoice(in);
        //Ensure the user enters a valid choice
        while (choice < 1 || choice > 2)
        {
            System.out.println("Invalid choice. Please choose again.");
            System.out.print("Please choose an option: ");
            choice = in.nextInt();
        }
        return choice;
    }

    public int algorithmMenu(Scanner in)
    {
        System.out.println("\n\n");
        System.out.println(BOLD + UNDERLINE + "\t\tSorting Algorithm Menu" + ANSI_RESET);
        System.out.println("1.  Bubble Sort");
        System.out.println("2.  Selection Sort");
        System.out.println("3.  Insertion Sort");
        System.out.println("4.  Shell Sort");
        System.out.println("5.  Comb Sort");
        System.out.println("6.  Quick Sort");
        System.out.println("7.  Merge Sort");
        System.out.println("8.  Natural Merge Sort");
        System.out.println("9.  Heap Sort");
        System.out.println("10.  Radix Sort");
        System.out.println("Q.  Exit");
        System.out.print("Please choose an option: ");
        //Ensure the user enters an integer
        int choice = 0;
        choice = validateChoice(in);
        //Ensure the user enters a valid choice
        while (choice < 1 || choice > 10)
        {
            System.out.println("Invalid choice. Please choose again.");
            System.out.print("Please choose an option: ");
            choice = in.nextInt();
        }
        return choice;
    }

    public int arrayMenu(Scanner in)
    {
        System.out.println("\n\n");
        System.out.println(BOLD + UNDERLINE + "\t\tArray Menu" + ANSI_RESET);
        System.out.println("1.  Show Original Array");
        System.out.println("2.  Create New Array");
        System.out.println("3.  Use Sorted Array");
        System.out.println("Q.  Exit");
        System.out.print("Please choose an option: ");
        //Ensure the user enters an integer
        int choice = 0;
        choice = validateChoice(in);
        //Ensure the user enters a valid choice
        while (choice < 1 || choice > 3)
        {
            System.out.println("Invalid choice. Please choose again.");
            System.out.print("Please choose an option: ");
            choice = in.nextInt();
        }
        return choice;
    }

    /**
     * Method to print an array
     * @param arr The array to be printed
     */
    public void printArray(ArrayList<Integer> arr)
    {
        for (int i = 0; i < arr.size(); ++i)
        {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
    /**
     * Method to create the arrays to be tested
     * @param in The scanner object to read the user's input
     * @param arrOriginal The original array
     * @param arrSorting The array to be sorted
     */
    public void createArrays(Scanner in, ArrayList<Integer> arrOriginal, ArrayList<Integer> arrSorting)
    {
        //Find out the size of the array to sort from the user
        System.out.print("Enter the size of the array to be sorted: ");
        while (in.hasNextInt() == false)
        {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print("Enter the size of the array to be sorted: ");
            in.next();
        }
        int size = in.nextInt();
        System.out.print("Enter the upper bound of the random numbers in the array: ");
        while (in.hasNextInt() == false)
        {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print("Enter the upper bound of the random numbers in the array: ");
            in.next();
        }
        int bound = in.nextInt();
        
        Random rand = new Random();
        //Fill the original array and the arrays to be sorted
        for (int i = 0; i < size; ++i)
        {
            arrOriginal.add(rand.nextInt(bound));
            arrSorting.add(arrOriginal.get(i));
            
        }
    }
    /**
     * Method to create a sorted array
     * @param arrOriginal The original array
     * @param arrSorting The array to be sorted
     */
    public void createSortedArray(ArrayList<Integer> arrOriginal, ArrayList<Integer> arrSorting)
    {
        MergeSort ms = new MergeSort();
        ms.mergeSort(arrOriginal, 0, arrOriginal.size() - 1);
        arrSorting.clear();
        for (int i = 0; i < arrOriginal.size(); ++i)
        {
            arrSorting.add(arrOriginal.get(i));
            
        }
    }
    /**
     * Method to restore the original array to the array that has just been sorted
     * @param arrOriginal The original array
     * @param arrPassed The array that has just been sorted
     */
    public void restoreSortedArray(ArrayList<Integer> arrOriginal, ArrayList<Integer> arrPassed)
    {
        arrPassed.clear();
        for (int i = 0; i < arrOriginal.size(); ++i)
        {
            arrPassed.add(arrOriginal.get(i));
        }
    }
    /**
     * Method to validate the user's choice, ensure it is an integer, close the program if the user chooses to quit
     * @param in The scanner object to read the user's input
     * @return The user's choice
     */
    public int validateChoice(Scanner in)
    {
        int choice = 0;
        while(in.hasNextInt() == false)
        {
            while(in.next().toUpperCase().charAt(0) == 'Q')
            {
                System.out.println("Exiting program...");
                System.exit(0);
            } 
            System.out.println("Invalid choice. Please choose again.");
            System.out.print("Please choose an option: ");
            in.next();
        }
        choice = in.nextInt();
        return choice;
    }
}
