import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FolderChecker {
    public boolean isFolderExist(String folder){
        File dir = new File(folder);
        return ((dir.exists()&&(dir.isDirectory())));
    }

    public boolean isFileExist(String filename){
        File file = new File(filename);
        return ((file.exists())&&(file.isFile()));
    }

    private FilenameFilter createFilter(String extension){
        String filter = (extension.startsWith("."))? extension : "."+extension;
        FilenameFilter fileFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                final String f = filter.toLowerCase();
                if (name.endsWith(f)){
                    return true;
                }
                else {
                    return false;
                }
            }
        };
        return fileFilter;
    }

    public List<String> getFiles(String folder, String extension){
        ArrayList<String> files = new ArrayList<>();
        if (isFolderExist(folder)) {
            File dir = new File(folder);
            File[] lst = dir.listFiles(this.createFilter(extension));
            for (File file: lst){
               if (file.isFile()){
                   files.add(file.getAbsolutePath());
               }
            }
        }
        return files;
    }
}
