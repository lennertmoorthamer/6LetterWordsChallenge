import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileHandler {
    /**
     * ReadFile
     *
     * @return map of strings and their length from the file
     */
    public Map<String, Integer> ReadFile(String path) {
        File file = new File(path);
        Scanner myReader;
        Map<String, Integer> wordMap = new HashMap<>();
        String line;
        try {
            myReader = new Scanner(file);
            //loop every line of the input file and add to list
            while (myReader.hasNextLine()) {
                line = myReader.nextLine();
                wordMap.put(line, line.length());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordMap;
    }


    /**
     * WriteToFile
     *
     * @param outputList list of output strings
     */
    public void WriteToFile(List<String> outputList, String file) {
        try {
            //open or create file
            FileWriter myWriter = new FileWriter(file);
            for (String s : outputList) {
                //write in file
                myWriter.write(s + "\n");
            }
            //close file
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
