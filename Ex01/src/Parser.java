import java.util.List;

public abstract class Parser {
    private final String filename;
    private final List<String> content;

    public Parser(String filename) {
        this.filename = filename;
        content = this.readFile();
    }

    public List<String> getContent() {
        return content;
    }
    public String getCollectionName(){
        FileWorker fw = new FileWorker();
        return fw.getShortFilename(this.filename);
    }

    private List<String> readFile(){
        FileWorker fileWorker = new FileWorker();
        List<String> result;
        try {
            result = fileWorker.readFileLines(filename);
        }
        catch (Exception ex){
            result = null;
        }
        return result;
    }

    public abstract SiteCollection parse();
}
