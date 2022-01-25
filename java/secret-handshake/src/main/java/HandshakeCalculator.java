import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> handShake = new ArrayList<>();
        String binaryString = Integer.toBinaryString(number);
        String[] handShakeCodes = this.getEnumNames(Signal.class);

        int lastIndex = binaryString.length() - 1;
        int signalIndex = 0;

        for (int currentIndex = lastIndex; currentIndex > -1; currentIndex--) {
            signalIndex = lastIndex - currentIndex;
            if (binaryString.charAt(currentIndex) == '1') {
                String handShakeCode = handShakeCodes[signalIndex];
                handShake.add(Signal.valueOf(handShakeCode));
            }
        }
        return handShake;
    }

    private String[] getEnumNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}
