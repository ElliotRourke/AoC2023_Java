package elliot.aoc;

import elliot.aoc.cubegame.ElfGameCalculator;
import elliot.aoc.gondola.EnginePartIdentifier;
import elliot.aoc.trebuchet.ElfTrebuchetCalibrator;

import java.io.File;
import java.util.List;

public class AoCApp {
    public static void main (String[] args) {
        InputConsumer inputConsumer = new InputConsumer();
        List<String> inputStrings = inputConsumer.getInputAsList(new File("src/main/resources/test.txt"));
//        int res = ElfTrebuchetCalibrator.getElfTrebuchetCalibration(inputStrings);
//        int res = ElfGameCalculator.getSumOfPossibleGameIds(inputStrings, 14, 12, 13);
//        int res = ElfGameCalculator.getPowerOfCubes(inputStrings);
        int res = EnginePartIdentifier.sumEnginePartIds(inputStrings);
        System.out.println("Result: " + res);
    }
}
