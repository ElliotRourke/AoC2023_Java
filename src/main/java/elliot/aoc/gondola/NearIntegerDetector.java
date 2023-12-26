package elliot.aoc.gondola;

import static elliot.aoc.util.Constant.MATRIX_DEPTH;

public class NearIntegerDetector {

    private static final String IS_NUMBER_REGEX = "[0-9]";

    private NearIntegerDetector() {
    }

    public static boolean hasNearIntegers(String[][] matrix, MatrixIndex index) {
        //Need to check in all directions around point, but obey constraints (sides, corners)
        if (isTopRightCorner(matrix, index)) {
            String left = matrix[index.getLength()][index.getDepth() - 1];
            String below = matrix[index.getLength() + 1][index.getDepth()];
            String diagonal = matrix[index.getLength() + 1][index.getDepth() - 1];
            return left.matches(IS_NUMBER_REGEX) || below.matches(IS_NUMBER_REGEX) || diagonal.matches(IS_NUMBER_REGEX);
        } else if (isTopLeftCorner(matrix, index)) {
            String right = matrix[index.getLength()][index.getDepth() + 1];
            String below = matrix[index.getLength() + 1][index.getDepth()];
            String diagonal = matrix[index.getLength() + 1][index.getDepth() + 1];
            return right.matches(IS_NUMBER_REGEX) || below.matches(IS_NUMBER_REGEX) || diagonal.matches(IS_NUMBER_REGEX);
        } else if (isBottomRightCorner(matrix, index)) {
            String left = matrix[index.getLength()][index.getDepth() - 1];
            String above = matrix[index.getLength() - 1][index.getDepth()];
            String diagonal = matrix[index.getLength() - 1][index.getDepth() - 1];
            return left.matches(IS_NUMBER_REGEX) || above.matches(IS_NUMBER_REGEX) || diagonal.matches(IS_NUMBER_REGEX);
        } else if (isBottomLeftCorner(matrix, index)) {
            String right = matrix[index.getLength()][index.getDepth() + 1];
            String above = matrix[index.getLength() - 1][index.getDepth()];
            String diagonal = matrix[index.getLength() - 1][index.getDepth() + 1];
            return right.matches(IS_NUMBER_REGEX) || above.matches(IS_NUMBER_REGEX) || diagonal.matches(IS_NUMBER_REGEX);
        } if (isLeftSide(matrix, index)) {
            String right = matrix[index.getLength()][index.getDepth() + 1];
            String above = matrix[index.getLength() - 1][index.getDepth()];
            String below = matrix[index.getLength() + 1][index.getDepth()];
            String diagonalAbove = matrix[index.getLength() - 1][index.getDepth() + 1];
            String diagonalBelow = matrix[index.getLength() + 1][index.getDepth() + 1];
            return right.matches(IS_NUMBER_REGEX)
                    || above.matches(IS_NUMBER_REGEX)
                    || below.matches(IS_NUMBER_REGEX)
                    || diagonalAbove.matches(IS_NUMBER_REGEX)
                    || diagonalBelow.matches(IS_NUMBER_REGEX);
        } else if (isRightSide(matrix, index)) {
            String left = matrix[index.getLength()][index.getDepth() - 1];
            String above = matrix[index.getLength() - 1][index.getDepth()];
            String below = matrix[index.getLength() + 1][index.getDepth()];
            String diagonalAbove = matrix[index.getLength() - 1][index.getDepth() - 1];
            String diagonalBelow = matrix[index.getLength() + 1][index.getDepth() - 1];
            return left.matches(IS_NUMBER_REGEX)
                    || above.matches(IS_NUMBER_REGEX)
                    || below.matches(IS_NUMBER_REGEX)
                    || diagonalAbove.matches(IS_NUMBER_REGEX)
                    || diagonalBelow.matches(IS_NUMBER_REGEX);
        } else if (isBottomSide(matrix, index)) {
            String left = matrix[index.getLength()][index.getDepth() - 1];
            String right = matrix[index.getLength()][index.getDepth() + 1];
            String above = matrix[index.getLength() - 1][index.getDepth()];
            String diagonalLeft = matrix[index.getLength() - 1][index.getDepth() - 1];
            String diagonalRight = matrix[index.getLength() - 1][index.getDepth() + 1];
            return left.matches(IS_NUMBER_REGEX)
                    || right.matches(IS_NUMBER_REGEX)
                    || above.matches(IS_NUMBER_REGEX)
                    || diagonalLeft.matches(IS_NUMBER_REGEX)
                    || diagonalRight.matches(IS_NUMBER_REGEX);
        } else if (isTopSide(matrix, index)) {
            String left = matrix[index.getLength()][index.getDepth() - 1];
            String right = matrix[index.getLength()][index.getDepth() + 1];
            String below = matrix[index.getLength() + 1][index.getDepth()];
            String diagonalLeft = matrix[index.getLength() - 1][index.getDepth() - 1];
            String diagonalRight = matrix[index.getLength() - 1][index.getDepth() + 1];
            return left.matches(IS_NUMBER_REGEX)
                    || right.matches(IS_NUMBER_REGEX)
                    || below.matches(IS_NUMBER_REGEX)
                    || diagonalLeft.matches(IS_NUMBER_REGEX)
                    || diagonalRight.matches(IS_NUMBER_REGEX);
        } else {
            String left = matrix[index.getLength()][index.getDepth() - 1];
            String right = matrix[index.getLength()][index.getDepth() + 1];
            String above = matrix[index.getLength() - 1][index.getDepth()];
            String below = matrix[index.getLength() + 1][index.getDepth()];
            String diagonalLeftAbove = matrix[index.getLength() - 1][index.getDepth() - 1];
            String diagonalRightAbove = matrix[index.getLength() - 1][index.getDepth() + 1];
            String diagonalLeftBelow = matrix[index.getLength() + 1][index.getDepth() - 1];
            String diagonalRightBelow = matrix[index.getLength() + 1][index.getDepth() + 1];
            return left.matches(IS_NUMBER_REGEX)
                    || right.matches(IS_NUMBER_REGEX)
                    || above.matches(IS_NUMBER_REGEX)
                    || below.matches(IS_NUMBER_REGEX)
                    || diagonalLeftAbove.matches(IS_NUMBER_REGEX)
                    || diagonalRightAbove.matches(IS_NUMBER_REGEX)
                    || diagonalLeftBelow.matches(IS_NUMBER_REGEX)
                    || diagonalRightBelow.matches(IS_NUMBER_REGEX);
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
