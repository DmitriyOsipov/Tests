import rubiconproject.KeywordService;

import java.util.Iterator;
import java.util.List;

public class Exec {

    public SitesCollectionsAlbum execute(String[] args) throws Exception{
        String[] extensions = {"csv", "json"};
        SitesCollectionsAlbum album = new SitesCollectionsAlbum();
        FileWorker worker = new FileWorker();

        if (checkArguments(args)){
            for (String ext: extensions){
                List<String> files = getFiles(args[0], ext);
                work(files, ext, album);
            }

            getKeywords(album);
            worker.writeFile(args[1], album.toString());
        }
        else {
            throw new Exception("Wrong number of arguments");
        }

        return album;
    }

    private void getKeywords(SitesCollectionsAlbum album){
        KeywordService keywordService = new KeywordsWork();
        for(SiteCollection collection: album){
            for (Site site: collection){
                site.setKeywords(keywordService.resolveKeywords(site));
            }
        }
    }

    private void work(List<String> files, String extension, SitesCollectionsAlbum album){
        Parser parser = null;
        for (String file: files) {
            switch (extension) {
                case "csv": {
                    parser = new ParserCSV(file);
                }break;
                /*
                case "json":{
                    parser = new ParserJson(file);
                }break;
                //*/
                default:{
                    parser = new ParserJson(file);
                }
            }
            album.addCollection(parser.parse());
        }
    }


    private List<String> getFiles(String folderName, String extension){
        FolderChecker checker = new FolderChecker();
        List<String> files = checker.getFiles(folderName, extension);

        return files;
    }

    private boolean checkArguments(String[] args){
        boolean result = false;
        FolderChecker checker = new FolderChecker();
        boolean checkNumber = (args!=null)&&(args.length==2);
        boolean checkDirectory = false;
        boolean checkFile = false;
        if (checkNumber){
            checkDirectory = checker.isFolderExist(args[0]);
            checkFile = (args[1].length()>4)&&(args[1].endsWith(".txt"));
        }
        result = checkNumber && checkDirectory && checkFile;


        return result;
    }
}
