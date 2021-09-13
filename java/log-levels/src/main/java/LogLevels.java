public class LogLevels {
    private static String SEPARATE_ERROR_AND_MESSAGE = ":\\s*";
    public static String message(String logLine) {
        String[] strings = logLine.split(SEPARATE_ERROR_AND_MESSAGE);
        String message = strings[1];
        return message.strip();
    }

    public static String logLevel(String logLine) {
        String[] strings = logLine.split(SEPARATE_ERROR_AND_MESSAGE);
        String level = strings[0];
        return level.substring(1, level.length() - 1).toLowerCase();
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
