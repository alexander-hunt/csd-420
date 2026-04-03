import java.io.*;

/**
 * ReadData.java
 * Reads and displays the data from the file created by WriteData.java
 */
public class ReadData {
    public static void main(String[] args) {
        String filename = "AlexH datafile.dat";
        
        // Read and display file contents
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("========== File Contents ==========");
            System.out.println();
            
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            System.err.println("Please run WriteData first to create the file.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
