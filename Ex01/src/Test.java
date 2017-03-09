public class Test {
    public static void main(String[] args) throws Exception{
        String fileIn = "D:\\test\\input1.csv";
        String fileIn2 = "D:\\test\\input2.json";
        String fileOut = "D:\\test\\out.txt";
        FileWorker fw = new FileWorker();
        Parser parser = new ParserCSV(fileIn);
        SitesCollectionsAlbum album = new SitesCollectionsAlbum();
        album.addCollection(parser.parse());
        Parser parser1 = new ParserJson(fileIn2);
        album.addCollection(parser1.parse());

        //fw.writeFile(fileOut, album.toString());
        fw.writeFile(fileOut, album.toStringJ());
    }
}
