import java.util.*;
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
        String stringPattern = "\\b[a-zA-Z\\d']+\\b";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher m = pattern.matcher(str);

        while (m.find()) {
            allMatchedWords.add(m.group().toLowerCase());
        }

        return allMatchedWords;
    }
}
/*
    1.  replace any form of punctuation with a single space.
    2.  split the result on \s+
    3.  Form a regular expression which will pick out the words, put this into an array or list
    4.  Can we use streams to count the unique words?
    5.  Results must be put into a Map.
*/