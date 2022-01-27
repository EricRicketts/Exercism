class RotationalCipher {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int shiftKey;
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        String encodedData = "";
        int dataSize = data.length();
        for (int index = 0; index < dataSize; index++) {
            encodedData += this.applyCipherToCharacterOrNot(index, data);
        }
        return encodedData;
    }

    private String encodeLetter(String lowerCaseLetter) {
        int letterIndex = ALPHABET.indexOf(lowerCaseLetter);
        int shiftedPosition = (letterIndex + this.shiftKey) % ALPHABET.length();

        return String.valueOf(ALPHABET.charAt(shiftedPosition));
    }

    private String applyCipherToCharacterOrNot(int index, String data) {
        String s = String.valueOf(data.charAt(index));
        String lowerCaseCharacter = s.toLowerCase();
        if (ALPHABET.contains(lowerCaseCharacter)) {
            String encodedLetter = this.encodeLetter(lowerCaseCharacter);
            s = this.upperCaseLetterOrNot(s, encodedLetter);
        }
        return s;
    }

    private String upperCaseLetterOrNot(String s, String encodedLetter) {
        return (s == s.toUpperCase()) ? encodedLetter.toUpperCase() : encodedLetter;
    }
}
