package elliot.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ElfTrebuchetCalibrator {
    private static final String REMOVAL_REGEX_STRING = "[a-zA-Z]*";
    private static final String EMPTY_STRING = "";
    private static final Pattern REMOVAL_PATTERN = Pattern.compile("");

    private ElfTrebuchetCalibrator() {}

    public static int getElfTrebuchetCalibration(final List<String> input) {
        if (input == null || input.isEmpty()) {
            return -1;
        }

        return input.stream()
                .map(ElfTrebuchetCalibrator::readCalibrationInput)
                .filter(i -> i != -1)
                .reduce(0, Integer::sum);
    }

    private static int readCalibrationInput(final String s) {
        final String formattedString = s.replaceAll(REMOVAL_REGEX_STRING, EMPTY_STRING);

        if (formattedString.length() == 1) {
            String res = formattedString + formattedString;
            return Integer.parseInt(res);
        }

        if (formattedString.length() == 2) {
            return Integer.parseInt(formattedString);
        }

        if (formattedString.length() > 2) {
            String res = formattedString.substring(0, 1) + formattedString.substring(formattedString.length() - 1);
            return Integer.parseInt(res);
        }

        return -1;
    }
}
