

public class Site {
    public static final int FIELDS_COUNT = 5;
    private final boolean CHECK_KEYWORDS = false;
    private final int id;
    private final String name;
    private final boolean mobile;
    private String keywords;
    private final double score;

    public Site(int id, String name, boolean mobile, String keywords, double score) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.keywords = keywords;
        this.score = score;
    }

    private boolean checkKeywords(){
        boolean result = true;
        if (CHECK_KEYWORDS){
            result = ((keywords!=null)&&(keywords.length()>0));
        }

        return result;
    }

    @Override
    public String toString(){
        if (checkKeywords()) {
            StringBuilder builder = new StringBuilder("\t{");
            int mobileI = (mobile) ? 1 : 0;
            builder.append("\n\t\t\"id\": \"" + id + "\"");
            builder.append("\n\t\t\"name\": \"" + name + "\"");
            builder.append("\n\t\t\"mobile\": \"" + mobileI + "\"");
            builder.append("\n\t\t\"keywords\": \"" + keywords + "\"");
            builder.append("\n\t\t\"score\": \"" + score + "\"");
            builder.append("\n\t}");
            return builder.toString();
        }
        return "";
    }
}
