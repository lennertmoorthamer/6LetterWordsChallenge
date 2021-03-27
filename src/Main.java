import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "IO/input.txt";
    private static final String OUTPUT_FILE = "IO/output.txt";
    private static final int WORD_LENGTH = 6;

    public static void main(String[] args) {
        Map<String, Integer> wordMap;
        FileHandler fileHandler = new FileHandler();
        wordMap = fileHandler.ReadFile(INPUT_FILE);
        fileHandler.WriteToFile(createWords(wordMap, WORD_LENGTH), OUTPUT_FILE);
    }


    public static List<String> createWords(Map<String, Integer> wordMap, int length) {
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> outerWord : wordMap.entrySet()) {
            for (Map.Entry<String, Integer> innerWord : wordMap.entrySet()) {
                if (outerWord.getValue() + innerWord.getValue() == length) {
                    output.add(String.format("%s + %s = %s", outerWord.getKey(), innerWord.getKey(), outerWord.getKey() + innerWord.getKey()));
                }
            }
        }
        return output;
    }
}
