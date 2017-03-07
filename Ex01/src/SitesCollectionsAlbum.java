import java.util.ArrayList;

public class SitesCollectionsAlbum {
    private ArrayList<SiteCollection> sitesAlbum = new ArrayList<>();

    public void addCollection(SiteCollection collection){
        this.sitesAlbum.add(collection);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (SiteCollection collection: sitesAlbum){
            if (collection!=null) {
                builder.append("{\n");
                builder.append(collection.toString());
                builder.append("\n}\n");
            }
        }
        return builder.toString().trim();
    }
}
