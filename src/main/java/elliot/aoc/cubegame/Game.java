package elliot.aoc.cubegame;

public class Game {
    private int id = -1;
    private int maxBlueCubes = 0;
    private int maxRedCubes = 0;
    private int maxGreenCubes = 0;

    public Game() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxBlueCubes() {
        return maxBlueCubes;
    }

    public void setMaxBlueCubes(int maxBlueCubes) {
        this.maxBlueCubes = maxBlueCubes;
    }

    public int getMaxRedCubes() {
        return maxRedCubes;
    }

    public void setMaxRedCubes(int maxRedCubes) {
        this.maxRedCubes = maxRedCubes;
    }

    public int getMaxGreenCubes() {
        return maxGreenCubes;
    }

    public void setMaxGreenCubes(int maxGreenCubes) {
        this.maxGreenCubes = maxGreenCubes;
    }

    public boolean isWithinLimits(final int blueLimit, final int redLimit, final int greenLimit) {
        return this.maxBlueCubes <= blueLimit && this.maxRedCubes <= redLimit && this.maxGreenCubes <= greenLimit;
    }

}
