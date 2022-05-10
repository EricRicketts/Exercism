import java.util.*;

class HandshakeCalculator {
    private Map<Integer, Signal> signalMap = new HashMap<>();
    private final Integer[] binaryArray = new Integer[]{1, 2, 4, 8, 16};
    {
        signalMap.put(1, Signal.values()[0]);
        signalMap.put(2, Signal.values()[1]);
        signalMap.put(4, Signal.values()[2]);
        signalMap.put(8, Signal.values()[3]);
    }

    public List<Signal> calculateHandshake(int number) {
        List<Signal> handShake = new ArrayList<>();
        boolean bitPresent;
        for (Integer bit:binaryArray) {
            bitPresent = (bit & number) == bit;
            if (bit != 16) {
                if (bitPresent) handShake.add(signalMap.get(bit));
            } else {
                if (bitPresent) Collections.reverse(handShake);
            }
        }

        return handShake;
    }
}