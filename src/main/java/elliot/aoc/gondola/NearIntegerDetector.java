package elliot.aoc.gondola;

public class NearIntegerDetector {

    private NearIntegerDetector() {}

    public static boolean hasNearIntegers(String[][] matrix, MatrixIndex index) {
        //Need to check in all directions around point, but obey constraints (sides, corners)
        if (isIndexASidePoint(matrix, index)) {
            return false;
        } else if (isIndexACornerPoint(matrix, index)) {
            return false;
        } else {
            return false;
        }
    }

    private static boolean isIndexASidePoint(String[][] matrix, MatrixIndex index) {
        return false;
    }

    private static boolean isIndexACornerPoint(String[][] matrix, MatrixIndex index) {
        return false;
    }
}
