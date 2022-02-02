import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Robot {

    private String name;
    public Robot() {
        this.name = null;
    }

    public String getName() {
        if (this.name == null) { this.name = generateTwoRandomLetters() + generateThreeRandomDigits(); }
        return this.name;
    }

    public void reset() {
        this.name = null;
    }

    private String generateThreeRandomDigits() {
        Random r = new Random();

    }

    private String generateTwoRandomLetters() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWZYZ";
        String twoLetters = "";
        Random r = new Random();

        for (int count = 0; count < 2; count++) {
            twoLetters += capitalLetters.charAt(r.nextInt(capitalLetters.length()));
        }

        return twoLetters;
    }
}