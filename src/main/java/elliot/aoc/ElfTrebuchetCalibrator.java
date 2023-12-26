package elliot.aoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElfTrebuchetCalibrator {
    private static final int RADIX = 10;
    private static final String EMPTY_STRING = "";
    private static final String REMOVAL_REGEX_STRING = "[^one|^two|^three|^four|^five|^six|^seven|^eight|^nine|[0-9]]";
    private static final Map<String, Integer> WRITTEN_NUMBERS = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

    private ElfTrebuchetCalibrator() {
    }

    public static int getElfTrebuchetCalibration(final List<String> input) {
        if (input == null || input.isEmpty()) {
            return -1;
        }

        return input.stream()
                .map(ElfTrebuchetCalibrator::removeUnwantedCharacters)
                .map(ElfTrebuchetCalibrator::convertWrittenNumbersToDigits)
                .map(ElfTrebuchetCalibrator::readCalibrationInput)
                .filter(i -> i != -1)
                .reduce(0, Integer::sum);
    }

    private static String removeUnwantedCharacters(final String input) {
        return input.replaceAll(REMOVAL_REGEX_STRING, EMPTY_STRING);
    }

    private static String convertWrittenNumbersToDigits(final String input) {
        Map<Integer, Integer> indexAndDigitMap = new HashMap<>();

        //Place the numeric digit in the map with the index as the key
        //We account for the possibility of multiple occurrences of a written number by setting the index equal to the written length
        //Plus the current index until the value returns -1 (representing not found)
        for (Map.Entry<String,Integer> en : WRITTEN_NUMBERS.entrySet()) {
            int index = 0;
            while (index != -1) {
                index = input.indexOf(en.getKey(), index);
                if (index != -1) {
                    indexAndDigitMap.put(index, en.getValue());
                    index = index + en.getKey().length() - 1;
                }
            }
        }

        //Add all other numeric digits to the map along with their index
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                indexAndDigitMap.put(i, Character.getNumericValue(c));
            }
        }

        //Place the numeric digits at their respective indexes
        char[] characters = new char[indexAndDigitMap.size()];
        List<Integer> sortedKeys = indexAndDigitMap.keySet().stream().sorted().toList();
        for (int i = 0; i < characters.length; i++) {
            characters[i] = Character.forDigit(indexAndDigitMap.get(sortedKeys.get(i)), RADIX);
        }
        return new String(characters);
    }

    private static int readCalibrationInput(final String input) {
        if (input.length() == 1) {
            String res = input + input;
            return Integer.parseInt(res);
        }

        if (input.length() == 2) {
            return Integer.parseInt(input);
        }

        if (input.length() > 2) {
            String res = input.substring(0, 1) + input.substring(input.length() - 1);
            return Integer.parseInt(res);
        }

        return -1;
    }
}
