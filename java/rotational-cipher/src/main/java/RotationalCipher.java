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
            String s = String.valueOf(data.charAt(index));
            String lowerCaseCharacter = s.toLowerCase();
            if (ALPHABET.contains(lowerCaseCharacter)) {
                int letterIndex = ALPHABET.indexOf(lowerCaseCharacter);
                int shiftedPosition = (letterIndex + this.shiftKey) % ALPHABET.length();
                String encodedLetter = String.valueOf(ALPHABET.charAt(shiftedPosition));
                if (s == s.toUpperCase()) {
                    s = encodedLetter.toUpperCase();
                } else {
                    s = encodedLetter;
                }
            }
            encodedData += s;
        }
        return encodedData;
    }

}
