package elliot.aoc.gondola;

import static elliot.aoc.util.Constant.MATRIX_DEPTH;

public class NearIntegerDetector {

    private NearIntegerDetector() {
    }

    public static boolean hasNearIntegers(String[][] matrix, MatrixIndex index) {
        //Need to check in all directions around point, but obey constraints (sides, corners)
        if (isTopRightCorner(matrix, index)) {
            return false;
        } else if (isTopLeftCorner(matrix, index)) {
            return false;
        } else if (isBottomRightCorner(matrix, index)) {
            return false;
        } else if (isBottomLeftCorner(matrix, index)) {
            return false;
        } if (isLeftSide(matrix, index)) {
            return false;
        } else if (isRightSide(matrix, index)) {
            return false;
        } else if (isBottomSide(matrix, index)) {
            return false;
        } else if (isTopSide(matrix, index)) {
            return false;
        } else {
            return false;
        }
    }

    private static boolean isLeftSide(String[][] matrix, MatrixIndex index) {
        return index.getDepth() == MATRIX_DEPTH;
    }

    private static boolean isRightSide(String[][] matrix, MatrixIndex index) {
        return index.getDepth() == 0;
    }

    private static boolean isTopSide(String[][] matrix, MatrixIndex index) {
        return index.getLength() == 0;
    }

    private static boolean isBottomSide(String[][] matrix, MatrixIndex index) {
        return index.getLength() == matrix.length;
    }

    private static boolean isTopLeftCorner(String[][] matrix, MatrixIndex index) {
        return (index.getLength() == 0 && index.getDepth() == 0);
    }

    private static boolean isTopRightCorner(String[][] matrix, MatrixIndex index) {
        return (index.getLength() == 0 && index.getDepth() == MATRIX_DEPTH);
    }

    private static boolean isBottomLeftCorner(String[][] matrix, MatrixIndex index) {
        return (index.getLength() == matrix.length && index.getDepth() == 0);
    }

    private static boolean isBottomRightCorner(String[][] matrix, MatrixIndex index) {
        return (index.getLength() == matrix.length && index.getDepth() == MATRIX_DEPTH);
    }
}
