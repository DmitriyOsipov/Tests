import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileWorker {
    public List<String> readFileLines(String filename) throws Exception{
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String readString;
        try {
            while ((readString = reader.readLine()) != null) {
                lines.add(readString);
            }
        }
        catch (IOException ex){
            throw ex;
        }
        finally {
            reader.close();
        }
        return lines;
    }

    public void writeFile(String filename, String content) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        try {
            writer.write(content);
        }
        catch (IOException ex){
            throw ex;
        }
        finally {
            writer.close();
        }
    }

    public String getShortFilename(String filename){
        File file = new File(filename);
        return file.getName();
    }
}
