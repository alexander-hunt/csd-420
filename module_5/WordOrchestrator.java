import java.util.TreeSet;

public class WordOrchestrator {
    private String sourceFilePath;
    private TreeSet<String> collectionOfWords;
    
    public WordOrchestrator(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
        this.collectionOfWords = new TreeSet<>();
    }

    public static void main(String[] args) {
        WordOrchestrator orchestrator = new WordOrchestrator("collection_of_words.txt");
        orchestrator.gatherWords();
        System.out.println("Ascending Order:");
        System.out.print(orchestrator.displayWords(true));
        System.out.println("");
        System.out.println("Descending Order:");
        System.out.print(orchestrator.displayWords(false));
    }

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
