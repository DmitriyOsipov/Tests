

public class Site {
    //public static final int FIELDS_COUNT = 5;
    private final boolean CHECK_KEYWORDS = true;
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

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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
            StringBuilder builder = new StringBuilder("  {");
            int mobileI = (mobile) ? 1 : 0;
            builder.append("\n   \"id\": \"" + id + "\"");
            builder.append("\n   \"name\": \"" + name + "\"");
            builder.append("\n   \"mobile\": " + mobileI + "");
            builder.append("\n   \"keywords\": \"" + keywords + "\"");
            builder.append("\n   \"score\": " + score + "");
            builder.append("\n  }");
            return builder.toString();
        }
        return "";
    }
}
