public class Test {
    public static void main(String[] args) throws Exception{
        String fileIn = "D:\\test\\input1.csv";
        String fileOut = "D:\\test\\out.txt";
        FileWorker fw = new FileWorker();
        Parser parser = new ParserCSV(fileIn);
        SitesCollectionsAlbum album = new SitesCollectionsAlbum();
        album.addCollection(parser.parse());

        fw.writeFile(fileOut, album.toString());
    }
}
