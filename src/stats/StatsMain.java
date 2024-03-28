package stats;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class StatsMain {

    public static void main(String[] args) {
    	// Create a scanner class object to read input
    	// System.in to indicate input from console 
        Scanner scanner = new Scanner(System.in);

        // Ask filename from user (Using print instead of println, as we don't need new line in that case)
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine(); // Read filename entered by user

        
        // Try keyword to check either there is exception
        try {
            // Make file class object using new keyword on dynamic memory
        	// Pass filename as a parameter to 
            File fileObject = new File(filename);
            // Again make scanner object but this time to read data from file
            // Scanner class parse input stream data to tokens that is helpful for reading file data
            // Token mean single unit of input data
            Scanner fileScanner = new Scanner(fileObject);

            // Read the first number which specifies how many data numbers are there in file given to user
            int count = fileScanner.nextInt();

            // Array of Double to store the data numbers
            double[] numbersInFile = new double[count];
            int iteration;
            for (iteration = 0; iteration < count; iteration++) {
            	numbersInFile[iteration] = fileScanner.nextDouble();
            }

            // Close the file scanner
            fileScanner.close();

            // Calculate mean as we now mean is average , total sum of numbers divided by total numbers
            double sum = 0;
            
         
            for (iteration = 0; iteration < count; iteration++) { // Using for loop so get nu
                sum += numbersInFile[iteration];
            }
            double mean = sum / count; // Getting mean by dividing sum by count 

            // Calculate standard deviation
            double sumDeviation = 0;
            
            // again use iteration variable
            for (iteration = 0; iteration < count; iteration++) {
            	// (number - mean) ^ 2, add up for each number in sumDeviation
                sumDeviation += Math.pow( numbersInFile[iteration] - mean, 2);
            }
            // (Summation (number - mean) ^ 2 / totalNumbers) then square root of answer
            // another logic double standardDeviation = Math.pow(sumDeviation / count,0.5);
            double standardDeviation = Math.sqrt(sumDeviation / count);

            DecimalFormat df = new DecimalFormat("#.###");

         // Print out results rounded to three decimal places
         System.out.println("Mean: " + df.format(mean));
         System.out.println("Standard Deviation: " + df.format(standardDeviation));

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        scanner.close();    }
}
