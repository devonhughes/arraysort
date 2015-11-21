/*
    The RandomArray class generates an array of arbitrary size with integer elements. 
    Includes a zero args constructor and a constructor that requires path name and array size 
    as parameters. Each element of the randomly sized array is filled with a random
    integer that is no less than 1 and no greater than the size of the array itself. 
*/
package arraysort;
import java.io.File;
import java.io.File.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class RandomArray {
    
    // PRIVATE FIELDS
    private Random number = new Random();
    private int MAX = 1000000;   // max size of zero-args array (for testing, set low)
    private String path;
    private int size = 1;
    private int[] theArray;
    private PrintWriter file;
    
    // CONSTRUCTORS 
    //zero args constructor
    public RandomArray() throws FileNotFoundException, IOException{
        
        //set path to default and make a file object 
        setPath("default.txt");
        file = MakeFile();
        
        // make a random number and array of same random length
        size = number.nextInt(MAX);
        System.out.println("size of array: " + size);
        MakeArray();
        PopulateNewArray();
        file.close();
    }
    
    // inputs: path name and array size 
    public RandomArray(String p, int s) throws FileNotFoundException, IOException{
        
        // set path name and make a file object
        setPath(p);
        setSize(s);
        // print statement to confirm size of array (helpful during testing/evaluating of sorts)
        System.out.println("size = " + getSize() );
        MakeArray();
        PopulateNewArray();
    }
    
    // METHODS  
    // method to make file (used if zero-args constructor is called)
    public PrintWriter MakeFile() throws FileNotFoundException{
        String path = getPath();
        PrintWriter file = new PrintWriter(path);
        return file;
    }
    // method to make and return array using size specified in paramter
    public int[] MakeArray(){
        theArray = new int[size];
        //PrintArray();     //used for testing
        return theArray;
    }
    
    //if array and file are being created for first time
    // method fills each element of the array with a randomly generated integer 
    // integer values are between the range of 1 and the length of the array
    public void PopulateNewArray(){
        for (int i = 0; i < theArray.length; i++){
            theArray[i] = number.nextInt(size + 1);
        } 
    }
    
    // GETTERS AND SETTERS 
    public String getPath() {
        return path;        }

    public void setPath(String path) {
        this.path = path;            }

    public int[] getTheArray() {
        return theArray;       }

    public void setTheArray(int a) {
        for (int i = 0; i < theArray.length; i++){
           theArray[i] = a; }                    }

    public int getSize() {
        return size;     }

    public void setSize(int size) {
        this.size = size;         }
    
    //print method used for testing
    public void PrintArray(){
        System.out.println("array length: " + theArray.length);
        for (int i = 0; i < theArray.length; i++){
           System.out.println("Element " + (i + 1) + ": " + theArray[i]);
       }
    } 
}

       

   