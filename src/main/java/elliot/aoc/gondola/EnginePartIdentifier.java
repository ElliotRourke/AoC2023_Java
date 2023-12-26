package elliot.aoc.gondola;

import java.util.ArrayList;
import java.util.List;

public class EnginePartIdentifier {

    private static final String ENGINE_PARTS_REGEX = "[^.]";
    private static final String NON_DIGIT_REGEX = "[^0-9]";
    public static final int MATRIX_DEPTH = 10;

    private EnginePartIdentifier() {}

    public static int sumEnginePartIds(List<String> input) {
        //Create a matrix
        final String[][] matrix = new String[input.size()][10];
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            for (int j = 0; j < MATRIX_DEPTH; j++) {
                String[] charactersAsStrings = line.split("");
                matrix[i][j] = charactersAsStrings[j];
            }
        }
        //Find indexes of all parts and then check for numbers in a 3 degrees of freedom pattern
        //Have to be careful not to count some parts twice...
        List<MatrixIndex> enginePartIndices = getEnginePartIndexes(matrix);


        return -1;
    }

    private static List<MatrixIndex> getEnginePartIndexes(String[][] matrix) {
        List<MatrixIndex> indices = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < MATRIX_DEPTH; j++) {
                String character = matrix[i][j];
                if (character.matches(ENGINE_PARTS_REGEX) && character.matches(NON_DIGIT_REGEX)) {
                    MatrixIndex index = new MatrixIndex(i, j);
                    indices.add(index);
                }
            }
        }
        return indices;
    }

    private static int resolveInteger() {


        return -1;
    }
}
