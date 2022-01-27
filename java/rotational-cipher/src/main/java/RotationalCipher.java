import java.util.List;
import java.util.stream.Collectors;

class RotationalCipher {
    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private int shiftKey;
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return List.of(data.split("")).stream().map(s -> this.applyCipher(s)).collect(Collectors.joining());
    }

    private String encodeLetter(String lowerCaseLetter) {
        int letterIndex = ALPHABET.indexOf(lowerCaseLetter);
        int shiftedPosition = (letterIndex + this.shiftKey) % ALPHABET.length();
        char cipherEncodedLetter = ALPHABET.charAt(shiftedPosition);

        return String.valueOf(cipherEncodedLetter);
    }

    private String applyCipher(String chr) {
        String lowerCaseCharacter = chr.toLowerCase();
        if (ALPHABET.contains(lowerCaseCharacter)) {
            String encodedLetter = this.encodeLetter(lowerCaseCharacter);
            chr = (chr == chr.toUpperCase()) ? encodedLetter.toUpperCase() : encodedLetter;
        }
        return chr;
    }
}
