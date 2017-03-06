import java.util.ArrayList;

public class SiteCollection {
    private final String collectionId;
    private ArrayList<Site> sites = new ArrayList<>();

    public SiteCollection(String collectionId) {
        this.collectionId = collectionId;
    }

    public void addSite(Site newSite){
        sites.add(newSite);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("\t\"collectionId\": \"" + collectionId + "\"");
        builder.append("\n\t\"sites\": [");
        for(Site site: sites){
            builder.append("\n");
            builder.append(site.toString());
        }
        builder.append("\n\t]");
        return builder.toString();
    }
}
