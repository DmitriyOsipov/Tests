import java.util.ArrayList;
import java.util.Iterator;

public class SiteCollection implements Iterable<Site>{
    private final String collectionId;
    private ArrayList<Site> sites = new ArrayList<>();

    public SiteCollection(String collectionId) {
        this.collectionId = collectionId;
    }

    public void addSite(Site newSite){
        sites.add(newSite);
    }

    @Override
    public Iterator<Site> iterator() {
        return new Iterator<Site>() {
            int current = 0;
            @Override
            public boolean hasNext() {
                return current<sites.size();
            }

            @Override
            public Site next() {
                Site site = sites.get(current);
                current++;
                return site;
            }
        };
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(" \"collectionId\": \"" + collectionId + "\"");
        builder.append("\n \"sites\": [");
        for(Site site: sites){
            if (site.toString().length()>1) {
                builder.append("\n");
                builder.append(site.toString());
            }
        }
        builder.append("\n ]");
        return builder.toString();
    }
}
