import java.util.Arrays;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        if (phrase.equals("")) return true;
        String filteredString = this.filterPhrase(phrase.toLowerCase());
        char[] alphabetizedCharArray = this.alphabetizePhrase(filteredString);
        return !anyDuplicateLetters(alphabetizedCharArray);
    }

    private char[] alphabetizePhrase(String phrase) {
        char[] charArray = phrase.toCharArray();
        Arrays.sort(charArray);
        return charArray;
    }

    private boolean anyDuplicateLetters(char[] charArray) {
       boolean foundDuplicate = false;
       for (int index = 0; index < charArray.length - 1; index++) {
           if (charArray[index] == charArray[index + 1]) {
               foundDuplicate = true;
               break;
           }
       }
       return foundDuplicate;
    }

    private String filterPhrase(String phrase) {
        String regex ="[\\-\\s+]";
        return phrase.replaceAll(regex, "");
    }
}