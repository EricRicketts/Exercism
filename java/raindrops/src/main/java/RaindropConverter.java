import java.util.HashMap;
import java.util.Map;

class RaindropConverter {

    private final Map<Integer, String> raindropMapper;

    public RaindropConverter() {
        raindropMapper = new HashMap<>();
        raindropMapper.put(3, "Pling");
        raindropMapper.put(5, "Plang");
        raindropMapper.put(7, "Plong");
    }

    String convert(int number) {
        StringBuilder numberToRaindrops = new StringBuilder("");
        for (Map.Entry<Integer, String> entry:raindropMapper.entrySet()) {
            if (number % entry.getKey() == 0) numberToRaindrops.append(entry.getValue());
        }
        return numberToRaindrops.toString().equals("") ? String.valueOf(number) : numberToRaindrops.toString();
    }
}