public class Hamming {
    String leftStrand, rightStrand;
    int distance;

    public Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException
    {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (this.leftStrand.isEmpty() && this.rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (this.rightStrand.isEmpty() && this.leftStrand.length() > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (this.leftStrand.length() != this.rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        } else {
            distance = 0;
            for (int i = 0; i < this.rightStrand.length(); i++) {
                if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) distance += 1;
            }
        }
    }

    public int getHammingDistance() {
        return distance;
    }
}
