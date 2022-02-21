package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet{
    float[] rainfall = {45, 37, 55, 26, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    // Alternative ways of creating arrays in Java
    // float[] array1 = new float[100];
    // float[] array2;  // This gives a null pointer exception. No memory has been allocated to the array

    public void settings() {
        size(500, 500);
    }

    public void setup() {   
        /* Ways of iterating over arrays in Java */
        // Using for loop
        for (int i=0; i<rainfall.length; i++) {
            println(rainfall[i] + "\t" + months[i]); // From PApplet superclass
        }
        // Possibility of array index out of bounds

        // Enhanced for loop; for iterable objects
        for (float r:rainfall) {
            println(r);
        }
        /*
        int j=0;
        for (float r:rainfall) {
            println(r + "/t" + months[j]);
            j++;
        }
        */

        // Iterating backwards
        for (int i=rainfall.length -1; i>=0 ; i--) {
            println(rainfall[i] + "/t" + months[i]);
        }

        // Finding the minimum and max values in the rainfall array
        int minIndex = 0;
        int maxIndex = 0;

        for (int k=0; k<rainfall.length; k++) {
            if (rainfall[k] < rainfall[minIndex]) {
                minIndex = k;
            }
            if (rainfall[k] > rainfall[maxIndex]) {
                maxIndex = k;
            }
        }
        println("Max rainfall: " + rainfall[maxIndex] + "in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + "in month " + months[minIndex]);

        float avg = 0;
        float sum = 0;
        // Finding the average
        for (int l=0; l<rainfall.length; l++) {
            sum = sum + rainfall[l];
        }
        avg = sum / rainfall.length;
        println("Average :" + avg);

        
    }

    public void draw() {

    }
}
