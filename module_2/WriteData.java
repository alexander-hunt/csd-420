import java.io.*;
import java.util.Random;

/**
 * WriteData.java
 * Writes an array of five random integers and five random double values to a file.
 * If the file exists, data is appended; otherwise, the file is created.
 */
public class WriteData {
    public static void main(String[] args) {
        Random rand = new Random();
        String filename = "AlexH datafile.dat";
        
        // Create arrays for random integers and doubles
        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];
        
        // Populate arrays with random values
        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = rand.nextInt(100) + 1;  // Random integers 1-100
            randomDoubles[i] = rand.nextDouble() * 100;  // Random doubles 0-100
        }
        
        // Write to file (append mode)
        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            // Write separator for readability
            bw.write("========== Data Write Session ==========\n");
            
            // Write integers
            bw.write("Random Integers: ");
            for (int i = 0; i < 5; i++) {
                bw.write(String.valueOf(randomIntegers[i]));
                if (i < 4) bw.write(", ");
            }
            bw.write("\n");
            
            // Write doubles
            bw.write("Random Doubles: ");
            for (int i = 0; i < 5; i++) {
                bw.write(String.format("%.2f", randomDoubles[i]));
                if (i < 4) bw.write(", ");
            }
            bw.write("\n");
            bw.write("=======================================\n\n");
            
            System.out.println("Data successfully written to " + filename);
            System.out.println("Random Integers: ");
            for (int i = 0; i < 5; i++) {
                System.out.print(randomIntegers[i]);
                if (i < 4) System.out.print(", ");
            }
            System.out.println();
            
            System.out.println("Random Doubles: ");
            for (int i = 0; i < 5; i++) {
                System.out.printf("%.2f", randomDoubles[i]);
                if (i < 4) System.out.print(", ");
            }
            System.out.println();
            
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
