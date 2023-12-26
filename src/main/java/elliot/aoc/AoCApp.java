package elliot.aoc;

import java.io.File;
import java.util.List;

public class AoCApp {
    public static void main (String[] args) {
        InputConsumer inputConsumer = new InputConsumer();
        List<String> inputStrings = inputConsumer.getInputAsList(new File("src/main/resources/challenge_1_input.txt"));
        int res = ElfTrebuchetCalibrator.getElfTrebuchetCalibration(inputStrings);
        System.out.println("Calibration result: " + res);
    }
}
