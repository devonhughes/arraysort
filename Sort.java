/*
    The Sort class contains methods to sort arrays of randomizd integers.
    Bubble, insertion and merge sort methods are provided. 
    Each sort works by using the importFile method to read in the array from a file
    before performing the sort.
 */
package arraysort;

import java.io.FileNotFoundException;


public class Sort {
    
    // PRIVATE FIELDS
    ConvertFormat cf = new ConvertFormat();
    String path;
    
    // method to import file for overwriting as array is sorted
    // input: path of file
    // returns: overwritten array (after it has been sorted)
    public int[] importFile (String p) throws FileNotFoundException {
        path = p;
        int[] importedArray = cf.fileToArray(path);
        
        /* print importedArray for testing
        System.out.println("importFile printing importedArry:");
        cf.PrintArray(importedArray); */
        return importedArray;
    }
    // method to sort an array using bubble sort algorithm
    public void BubbleSort(String p) throws FileNotFoundException{
        path = p;
        int[] bubble = importFile(path) ;   

        //algorithm goes here
        for (int i = 0 ; i < bubble.length - 1 ; i++){
            for (int j = 0 ; j < bubble.length - 1 ; j++){
		if ( bubble[j] > bubble[j + 1] ){
                    int n = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = n;
		}
            }
        }
        // print importedArray for testing
        //System.out.println("importFile printing bubble array:");
        //cf.PrintArray(bubble); 
        
        //sorted array goes back into file
        cf.arrayToFile(bubble, path);
    }
 
    // method to sort an array using insertion sort algorithm
    public void InsertionSort(String p) throws FileNotFoundException{
        path = p;
        int[] insert = importFile(path) ;   

        //algorithm goes here
        for (int i = 1; i < insert.length; i++){
            int j;
            int n = insert[i];
	
            for(j = (i - 1); (j >= 0) && (n < insert[j] ); j--){
		insert[j + 1] = insert[j];
            }
	insert[j + 1] = n;}
                        
        /* print importedArray for testing
        System.out.println("importFile printing insert array:");
        cf.PrintArray(insert); */
        
        //sorted array goes back into file
        cf.arrayToFile(insert, path);
    }
    
    // method to sort an array using merge sort algorithm
    // Mergesort: takes in a path and calls the mergeSort method
    public void Mergesort (String p) throws FileNotFoundException{
        path = p;
        int[] mergeyArray = importFile(path) ;   
        mergeSort(mergeyArray);
        
        // print importedArray for testing
        //System.out.println("importFile printing merge array: ");
                
        //sorted array goes back into file
        cf.arrayToFile(mergeyArray, path);
    }   
    // mergeSort: takes array input and recursively divides it into arrays of only 1 element 
    // returns: sorted array of integers
    public int[] mergeSort( int[] mergeyArray) throws FileNotFoundException{
        // if the array has 2 elements to sort 
        if( mergeyArray.length > 1 ){	
	
            //divide the array into left and right 
            int[] leftarray = new int[mergeyArray.length / 2];
            int[] rightarray = new int[mergeyArray.length - leftarray.length];
            
            //copy the left and right arrays back into the original array
            System.arraycopy(mergeyArray, 0, leftarray, 0, leftarray.length);
            System.arraycopy(mergeyArray, leftarray.length, rightarray, 0, rightarray.length);
		
            //recursively call the mergeSort method on sub-arrays
            mergeSort(leftarray);
            mergeSort(rightarray);
        
            // recursively call Merge to merge the sub-arrays together, overwriting the original array
            Merge(leftarray, rightarray, mergeyArray);
        } 
        return mergeyArray;	
    }
    //Merge: recursively merges sub-arrays together into new sorted array
    //input: leftarray[] and rightarray[] and sortedarray[]
    //output: sorted sub-array of integers
    public int[] Merge(int[] leftarray, int[] rightarray, int[] sortedarray){
            //initialize count variables to zero
            int leftCount = 0;
            int rightCount = 0;
            int arrayCount = 0;

        // sort elements of lesser value into new sorted array
            while( leftCount < leftarray.length && rightCount < rightarray.length){
                if (leftarray[leftCount] < rightarray[rightCount]){
                    sortedarray[arrayCount] = leftarray[leftCount];
                    leftCount++;
                } else {
                    sortedarray[arrayCount] = rightarray[rightCount];
                    rightCount++;
                }
                arrayCount++;
           }
            // when sorting elements is done, copy any remaining elements in left 
            ///or right sub-arrays into sorted array
            if( leftCount == leftarray.length ){
                System.arraycopy(rightarray, rightCount, sortedarray , arrayCount, (rightarray.length - rightCount));
            } else {
                System.arraycopy( leftarray , leftCount ,sortedarray ,arrayCount , (leftarray.length - leftCount));
            } 
            return sortedarray; //returns back to mergeSort method
       }
      
    
    //  QuickSort: BONUS CREDIT
    


    
}
