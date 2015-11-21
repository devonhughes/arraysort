/*
    The ArraySort program contains classes and methods to provide the user with
    ways to implement, test and evaluate sorting algorithms: Bubble sort, 
    Insertion Sort, and Merge Sort. 

    Running each of the sorting algorithms creates a randomly generated integer
    array which is then stored in a text file. The stored array is then sorted
    using the specified algorithm, during which the time is recorded in seconds.
    Thesorted array and these results are then output into text files for analysis. 
 */
package arraysort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArraySort {

    public static void main(String[] args) throws FileNotFoundException, IOException {
    
        // TO RUN INDIVIDUAL ALGORITHM RESULTS 
        runBubbleSort();
        runInsertSort();
        runMergeSort();
        
        
        /* TO RUN ALL THREE SORTING ALGORITHMS
           Can be modified to test algorithms against each other with specific inputs
           All results then print to one file rather than individual results files
           while each individual sorted array still prints to its own file.
           UNCOMMENT LINE BELOW TO RUN */
        // runAllSorts();                                    
    }
        // Bubble Sorts
        public static void runBubbleSort() throws IOException{
            Sort sorty = new Sort();
            File bFile = new File("bResults.txt");
            PrintWriter bOutput = new PrintWriter(bFile);
            int[] bSizes = {10, 100, 1000, 10000, 100000, 200000, 300000, 350000, 
                            400000, 500000};
            String[] bPaths = {"b10.txt", "b100.txt", "b1000.txt", "b10000.txt", 
                               "b100000.txt", "b200000.txt", "b300000.txt", "b350k.txt", 
                               "b400k.txt", "bHalfMillion.txt"};
            int i = 0;
            int j = 0;
                        
            for(i = 0; i < bSizes.length; i++){
                for(j = 0; j < 1; j++){
                    String bIterativePath = bPaths[i+j];
                    RandomArray bRandom = new RandomArray(bIterativePath, bSizes[i]);      
                    ConvertFormat cf = new ConvertFormat();
                    int[] bubble = bRandom.getTheArray();
                    cf.arrayToFile(bubble, bIterativePath);
                    
                    // Code to perform a bubble sort 
                    long startTime = System.nanoTime();
                    sorty.BubbleSort(bIterativePath);
                    long elapsedTime = System.nanoTime() - startTime;
                    double secondsSorted = (double)elapsedTime / 1000000000.0;
                    System.out.println(bIterativePath + " time: " + secondsSorted);
                    System.out.println("---------------------------------");
                    bOutput.println(bIterativePath + " : " + secondsSorted);
                } 
            } bOutput.close();
        }
        // Insertion Sorts
        public static void runInsertSort() throws IOException{
            Sort sorty = new Sort();
            File iFile = new File("iResults.txt");
            PrintWriter iOutput = new PrintWriter(iFile);
            int[] iSizes = {10, 100, 1000, 10000, 100000, 200000, 300000, 350000, 
                            400000, 500000, 1000000, 1500000, 2000000};
            String[] iPaths = {"i10.txt", "i100.txt", "i1000.txt", "i10000.txt", 
                               "i100000.txt", "i200000.txt", "i300000.txt", "i350k.txt", 
                               "i400k.txt", "iHalfMillion.txt", "iMillion.txt",
                               "iOneAndHalfMill.txt", "i2Million.txt"};
            int i = 0;
            int j = 0;  
            
            for(i = 0; i < iSizes.length; i++){
                for(j = 0; j < 1; j++){
                    String iIterativePath = iPaths[i+j];
                    RandomArray iRandom = new RandomArray(iIterativePath, iSizes[i]);      
                    ConvertFormat cf = new ConvertFormat();
                    int[] insertion = iRandom.getTheArray();
                    cf.arrayToFile(insertion, iIterativePath);
            
                    // Code to perform a bubble sort 
                    long startTime = System.nanoTime();
                    sorty.InsertionSort(iIterativePath);
                    long elapsedTime = System.nanoTime() - startTime;
                    double secondsSorted = (double)elapsedTime / 1000000000.0;
                    System.out.println(iIterativePath + " time: " + secondsSorted);
                    System.out.println("---------------------------------");
                    iOutput.println(iIterativePath + " : " + secondsSorted);
                } 
            } iOutput.close();
        }
        
        // Merge Sorts
        public static void runMergeSort() throws IOException{
            Sort sorty = new Sort();
            File mFile = new File("mResults.txt");
            PrintWriter mOutput = new PrintWriter(mFile);
            int[] mSizes = {10, 100, 1000, 10000, 100000, 200000, 300000, 350000, 
                            400000, 500000, 1000000, 1500000, 2000000, 10000000, 
                            50000000, 100000000, 150000000 };
            String[] mPaths = {"m10.txt", "m100.txt", "m1000.txt", "m10000.txt", 
                               "m100000.txt", "m200000.txt", "m300000.txt", "m350k.txt", 
                               "m400k.txt", "mHalfMillion.txt", "mMillion.txt",
                               "mOneAndHalfMill.txt", "m2Million.txt", "m10Million.txt",
                               "m50Million.txt", "m100Million.txt", "m120Million.txt"};
            int i = 0;
            int j = 0;
                        
            for(i = 0; i < mSizes.length; i++){
                for(j = 0; j < 1; j++){
                    String mIterativePath = mPaths[i+j];
                    RandomArray mRandom = new RandomArray(mIterativePath, mSizes[i]);      
                    ConvertFormat cf = new ConvertFormat();
                    int[] merge = mRandom.getTheArray();
                    cf.arrayToFile(merge, mIterativePath);
                    
                    // Code to perform a bubble sort 
                    long startTime = System.nanoTime();
                    sorty.Mergesort(mIterativePath);
                    long elapsedTime = System.nanoTime() - startTime;
                    double secondsSorted = (double)elapsedTime / 1000000000.0;
                    System.out.println(mIterativePath + " time: " + secondsSorted);
                    System.out.println("---------------------------------");
                    mOutput.println(mIterativePath + " : " + secondsSorted);
                } 
            } mOutput.close();
        }
        public static void runQuickSorts() throws IOException{
            Sort sorty = new Sort();
            File qFile = new File("qResults.txt");
            PrintWriter qOutput = new PrintWriter(qFile);
            int[] qSizes = {5,2};
            String [] qPaths = {"q5test.txt", "q10test.txt"};
            
            int i = 0;
            int j = 0;
                        
            for(i = 0; i < qSizes.length; i++){
                for(j = 0; j < 1; j++){
                    String qIterativePath = qPaths[i+j];
                    RandomArray qRandom = new RandomArray(qIterativePath, qSizes[i]);      
                    ConvertFormat cf = new ConvertFormat();
                    int[] quick = qRandom.getTheArray();
                    cf.arrayToFile(quick, qIterativePath);
                    
                    // Code to perform a bubble sort 
                    long startTime = System.nanoTime();
                    sorty.QuickSort(qIterativePath);
                    long totalNanoSeconds = System.nanoTime() - startTime;
                    printSortResult(qIterativePath, totalNanoSeconds, qOutput);
//                    double secondsSorted = (double)elapsedTime / 1000000000.0;
//                    System.out.println(qIterativePath + " time: " + secondsSorted);
//                    System.out.println("---------------------------------");
//                    qOutput.println(qIterativePath + " : " + secondsSorted);
                } 
            } qOutput.close();
        }
        
        
        public static void runAllSorts() throws FileNotFoundException, IOException{
            
            Sort sorty = new Sort();
            File allFile = new File("allResults.txt");
            PrintWriter allOutput = new PrintWriter(allFile);
            int[] allSizes = {10, 100, 1000, 10000, 100000, 200000, 300000  };
            String[] allPaths = {"bubblesort10.txt", "insertysort10.txt", "mergeysort10.txt" ,
                          "bubblesort100.txt", "insertysort100.txt", "mergeysort100.txt" ,
                          "bubblesort1000.txt", "insertysort1000.txt", "mergeysort1000.txt" ,
                          "bubblesort10000.txt", "insertysort10000.txt", "mergeysort10000.txt" ,
                          "bubblesort100000.txt", "insertysort100000.txt", "mergeysort100000.txt" ,
                          "bubblesort200000.txt", "insertysort200000.txt", "mergeysort200000.txt" ,
                          "bubblesort300000.txt", "insertysort300000.txt", "mergeysort300000.txt" };
            int i = 0;
            int j = 0;
                        
            // set up for loops to iterate thru size and path arrays 
            for (i = 0; i < allSizes.length; i++){
                for(j = 0; j < 3; j++ ){
                    String allIterativePath = allPaths[(i*3)+j]; 
                
                    // Code to make a random array 
                    RandomArray aRandom = new RandomArray(allIterativePath, allSizes[i]);      
                
                    // Code to write random array into file 
                    ConvertFormat cf = new ConvertFormat();
                    int[] all = aRandom.getTheArray();
                    cf.arrayToFile(all, allIterativePath);      
        
                    if ( j % 3 == 0){
                        // Code to perform a bubble sort 
                        long start = System.nanoTime();
                        sorty.BubbleSort(allIterativePath);
                        long totalNanoSeconds = System.nanoTime() - start;
                        printSortResult(allIterativePath, totalNanoSeconds, allOutput);
                        
                    }
                
                    if ( j % 3 == 1){
                        // Code to perform an insertion sort 
                        long start = System.nanoTime();    
                        sorty.InsertionSort(allIterativePath);
                        long totalNanoSeconds = System.nanoTime() - start;
                        printSortResult(allIterativePath, totalNanoSeconds, allOutput);
                    }
                
                    if ( j % 3 == 2){
                        // Code to perform an insertion sort 
                        long start = System.nanoTime();    
                        sorty.Mergesort(allIterativePath);
                        long totalNanoSeconds = System.nanoTime() - start;
                        printSortResult(allIterativePath, totalNanoSeconds, allOutput);
                    }
                }
            }  allOutput.close(); 
        }
        
        public static void printSortResult(String path, long time, PrintWriter output){
            double timeInSeconds = (double)time / 1000000000.0;
            System.out.println(path + " time: " + timeInSeconds);
            System.out.println("---------------------------------");
            output.println(path + " : " + timeInSeconds);
        }
}
