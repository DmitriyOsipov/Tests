import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;

public class SitesCollectionsAlbum implements Iterable<SiteCollection>{
    private ArrayList<SiteCollection> sitesAlbum = new ArrayList<>();

    public void addCollection(SiteCollection collection){
        this.sitesAlbum.add(collection);
    }

    @Override
    public Iterator<SiteCollection> iterator() {
        return new Iterator<SiteCollection>() {
            int current = 0;
            @Override
            public boolean hasNext() {
                return current<sitesAlbum.size();
            }

            @Override
            public SiteCollection next() {
                SiteCollection collection = sitesAlbum.get(current);
                current++;
                return collection;
            }
        };
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

    public String toStringJ(){
        Gson gson = new Gson();
        return gson.toJson(this).replace("{", "\n{\n").replace("]", "\n]").trim();
    }
}
