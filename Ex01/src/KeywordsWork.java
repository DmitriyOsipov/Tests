import rubiconproject.KeywordService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KeywordsWork implements KeywordService {
    private List<String> words = new ArrayList<>();

    private String getWords(Site site){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i=1; i<10; i++){
            words.add("someKeyWord_" + i);
        }
        int numWords = random.nextInt(4);
        for(int i=0; i<numWords; i++){
            int wordIndex = random.nextInt(words.size());
            builder.append(words.get(wordIndex));
            builder.append(",");
        }
        String result = builder.toString();
        if (result.length()>1){
            result = result.substring(0, result.length()-1);
        }
        return result;
    }
    @Override
    public String resolveKeywords(Object site) {
        String result = "";

        if (site instanceof Site){
            result = this.getWords((Site)site);
        }

        return result;
    }
}
