import java.util.List;

public class ParserCSV extends Parser {
    private final String splitter = ",";
    public ParserCSV(String filename) {
        super(filename);
    }

    @Override
    public SiteCollection parse(){
        List<String> content = this.getContent();
        SiteCollection collection = new SiteCollection(getCollectionName());
        for (int i=1; i<content.size(); i++){
            String[] line = content.get(i).split(splitter);
            try {
                if (line.length>1) {
                    int siteId = Integer.valueOf(line[0]);
                    String siteName = line[1];
                    boolean siteIsMobile = Boolean.valueOf(line[2]);
                    double siteScore = Double.valueOf(line[3]);
                    collection.addSite(new Site(siteId, siteName, siteIsMobile, "", siteScore));
                }
            }
            catch (IndexOutOfBoundsException ex){

            }
        }

        return collection;
    }
}
