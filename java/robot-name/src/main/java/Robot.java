import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Robot {

    private String name;
    private static Set<String> allNamesSet = new HashSet<>();

    public String getName() {
        if (this.name == null) { this.name = generateTwoRandomLetters() + generateThreeRandomDigits(); }
        if (!allNamesSet.isEmpty()) {
            while (allNamesSet.contains(this.name)) {
                this.name = generateTwoRandomLetters() + generateThreeRandomDigits();
            }
            allNamesSet.add(this.name);
        } else {
            allNamesSet.add(this.name);
        }
        return this.name;
    }

    public void reset() {
        this.name = null;
    }

    private String generateThreeRandomDigits() {
        final String digits = "0123456789";
        StringBuilder threeDigits = new StringBuilder();
        Random r = new Random();

        for (int count = 0; count < 3; count++) {
            threeDigits.append(digits.charAt(r.nextInt(digits.length())));
        }

        return threeDigits.toString();
    }

    private String generateTwoRandomLetters() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWZYZ";
        StringBuilder twoLetters = new StringBuilder();
        Random r = new Random();

        for (int count = 0; count < 2; count++) {
            twoLetters.append(capitalLetters.charAt(r.nextInt(capitalLetters.length())));
        }

        return twoLetters.toString();
    }
}