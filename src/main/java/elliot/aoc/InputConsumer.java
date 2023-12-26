package elliot.aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputConsumer {

    public InputConsumer() {}

    public List<String> getInputAsList(final File file) {
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            return bf.lines().toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
