import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;

public class ParserJson extends Parser{
    private final String splitter = ",";
    private final String inSpl = ": ";

    public ParserJson(String filename) {
        super(filename);
    }

    @Override
    public SiteCollection parse() {
        List<String> content = this.getContent();
        SiteCollection collection = new SiteCollection(getCollectionName());

        StringBuilder builder  = new StringBuilder();
        for (String line: content){
            builder.append(line);
        }

        JsonParser parser = new JsonParser();
        //JsonObject object = parser.parse(builder.toString()).getAsJsonObject();
        JsonArray jsonArray = parser.parse(builder.toString()).getAsJsonArray();
        for (JsonElement element: jsonArray) {
            JsonObject object = element.getAsJsonObject();
            int site_id = object.get("site_id").getAsInt();
            String name = object.get("name").getAsString();
            boolean mobile = object.get("mobile").getAsBoolean();
            double score = object.get("score").getAsDouble();
            collection.addSite(new Site(site_id, name, mobile, "", score));
        }
        return collection;
    }
}
