class SqueakyClean {
    static String clean(String identifier) {
        final char SPACE = ' ';
        final char UNDERSCORE = '_';
        final char CONTROL_CHAR = '\0';
        final char HYPHEN = '-';
        final String CONTROL_STRING = "CTRL";
        final int LOWEST_GREEK_LETTER = 945;
        final int HIGHEST_GREEK_LETTER = 969;

        char[] chars = identifier.toCharArray();
        StringBuilder cleanedString = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int ch = chars[i];
            if (ch >= LOWEST_GREEK_LETTER && ch <= HIGHEST_GREEK_LETTER) {
                cleanedString.append("");
            } else if (Character.isLetter(chars[i])) {
                cleanedString.append(chars[i]);
            } else if (chars[i] == SPACE) {
                cleanedString.append(UNDERSCORE);
            } else if (chars[i] == CONTROL_CHAR) {
                cleanedString.append(CONTROL_STRING);
            } else if (chars[i] == HYPHEN) {
                cleanedString.append(Character.toUpperCase(chars[i+1]));
                i += 1;
            }
        }
        return cleanedString.toString();
    }
}
/*
    if the current character is a
*/