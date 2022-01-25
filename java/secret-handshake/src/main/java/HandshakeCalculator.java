import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {
    private final int MAX_BITS = 5;
    private final int MAX_NUM_SIGNALS = Signal.values().length;

    List<Signal> calculateHandshake(int number) {
        List<Signal> handShake = new ArrayList<>();
        String binaryString = this.conditionBinaryString(Integer.toBinaryString(number));
        String[] handShakeCodes = this.getEnumNames(Signal.class);

        int lastIndex = binaryString.length() - 1;
        int codeSelect = 0;

        for (int currentIndex = lastIndex; currentIndex > -1; currentIndex--) {
            codeSelect = lastIndex - currentIndex;
            if (binaryString.charAt(currentIndex) == '1' && codeSelect < MAX_NUM_SIGNALS) {
                String handShakeCode = handShakeCodes[codeSelect];
                handShake.add(Signal.valueOf(handShakeCode));
            }
        }
        if (this.reverseListOrNot(binaryString)) Collections.reverse(handShake);
        return handShake;
    }

    private String conditionBinaryString(String binaryString) {
        int binaryStringLength = binaryString.length();
        int startingIndex = binaryStringLength - MAX_BITS;
        return binaryStringLength > MAX_BITS ? binaryString.substring(startingIndex, binaryStringLength) :
                binaryString;
    }

    private String[] getEnumNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    private boolean reverseListOrNot(String binaryString) {
        return binaryString.length() == 5 && binaryString.charAt(0) == '1';
    }

}
