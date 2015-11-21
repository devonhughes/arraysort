/*
    The ConvertFormat class provides a convenient way to convert between 
    integer arrays and text files. A print method is also included to provide an 
    easy way to verify arrays are working as expected during testing. 
 */
package arraysort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
 
public class ConvertFormat {
    
    //method to convert an array into a text file
    // void method that creates a text file
    public void arrayToFile(int[] array, String path) throws FileNotFoundException{
        File file = new File(path);
        PrintWriter output = new PrintWriter(file);
        for (int i = 0; i < array.length; i++){
            output.println(array[i]);
        }
        output.close();
    }
    
    // method to convert a text file into an array 
    // returns an integer array
    public int[] fileToArray(String path) throws FileNotFoundException{
        File file = new File(path);
        Scanner input = new Scanner(file);
        
        //create temporary array list to read in file of unknown size
        ArrayList tempArray = new ArrayList<>();
        while (input.hasNext()) {
            int i = input.nextInt();
            tempArray.add(i);
        } 
        // create array of equal size as temporary array list
        int[] array = new int[tempArray.size()];
        
        // copy array list into array
        for (int i = 0; i < tempArray.size(); i++){
             array[i] =  (int) tempArray.get(i);
        }
        //PrintArray(array);        //used for testing
        return array;
    }
    // method to print an array, used for testing
    public void PrintArray(int[] array){
        System.out.println("array length: " + array.length);
        for (int i = 0; i < array.length; i++){
           System.out.println("Element " + (i + 1) + ": " + array[i]);
       }
    }
}
