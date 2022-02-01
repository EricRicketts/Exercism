import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    public Map<String, Integer> phrase(String str) {
        List<String> allWords = wordFilter(str);
        return countWords(allWords);
    }
    private Map<String, Integer> countWords(List<String> listOfWords) {
        Map<String, Integer> wordCount = new HashMap<>();
        listOfWords.stream().forEach(word -> {
            if (wordCount.get(word) == null) {
                wordCount.put(word.toLowerCase(), 1);
            } else {
                wordCount.put(word, wordCount.get(word) + 1);
            }
        });
        return wordCount;
    }
    private List<String> wordFilter(String str) {
        List<String> allMatchedWords = new ArrayList<>();
        String stringPattern = "\\b[a-zA-Z\\d']+\\b"; // search on the word boundary as we only get ' inside the word
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher m = pattern.matcher(str);
        while (m.find()) {
            allMatchedWords.add(m.group().toLowerCase());
        }
        return allMatchedWords;
    }
}