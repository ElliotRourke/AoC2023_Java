package elliot.aoc.gondola;

public class MatrixIndex {
    private final int length;
    private final int depth;

    public MatrixIndex(int length, int depth) {
        this.length = length;
        this.depth = depth;
    }

    public int getLength() {
        return length;
    }

    public int getDepth() {
        return depth;
    }
}
