import java.util.TreeSet;

public class WordOrchestrator {
    private String sourceFilePath;
    private TreeSet<String> collectionOfWords;
    
    // Initializes the orchestrator with a file path and creates an empty TreeSet for words.
    public WordOrchestrator(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
        this.collectionOfWords = new TreeSet<>();
    }

    // Main entry point that loads words from file and displays them in both ascending and descending order.
    public static void main(String[] args) {
        WordOrchestrator orchestrator = new WordOrchestrator("collection_of_words.txt");
        orchestrator.gatherWords();
        System.out.println("Ascending Order:");
        System.out.print(orchestrator.displayWords(true));
        System.out.println("");
        System.out.println("Descending Order:");
        System.out.print(orchestrator.displayWords(false));
    }

    // Reads words from the source file and adds them to the collection, automatically removing duplicates.
    private void gatherWords() {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(sourceFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String token : line.trim().split("\\s+")) {
                    if (!token.isEmpty()) {
                        collectionOfWords.add(token.toLowerCase());
                    }
                }
            }
        } catch (java.io.IOException exception) {
            System.out.println("Unable to read words from file: " + exception.getMessage());
        }
    }
    
    // Returns a string of all words separated by line breaks, ordered ascending or descending based on the boolean parameter.
    private String displayWords(boolean isInAscendingOrder) {
        StringBuilder wordCollection = new StringBuilder();
        if (isInAscendingOrder) {
            for (String word : collectionOfWords) {
                wordCollection.append(word).append(System.lineSeparator());
            }
        } else {
            java.util.List<String> reversed = new java.util.ArrayList<>(collectionOfWords);
            java.util.Collections.reverse(reversed);
            for (String word : reversed) {
                wordCollection.append(word).append(System.lineSeparator());
            }
        }
        return wordCollection.toString();
    }
}
