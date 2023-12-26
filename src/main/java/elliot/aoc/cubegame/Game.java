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

    public void setMaxBlueCubes(int maxBlueCubes) {
        this.maxBlueCubes = maxBlueCubes;
    }

    public void setMaxRedCubes(int maxRedCubes) {
        this.maxRedCubes = maxRedCubes;
    }

    public void setMaxGreenCubes(int maxGreenCubes) {
        this.maxGreenCubes = maxGreenCubes;
    }

    public boolean isWithinLimits(final int blueLimit, final int redLimit, final int greenLimit) {
        return this.maxBlueCubes <= blueLimit && this.maxRedCubes <= redLimit && this.maxGreenCubes <= greenLimit;
    }

    public int getPowerofMaxCubes() {
        //Default to 1 to avoid multiplying by 0
        int bluePower = this.maxBlueCubes != 0 ? this.maxBlueCubes : 1;
        int redPower = this.maxRedCubes != 0 ? this.maxRedCubes : 1;
        int greenPower = this.maxGreenCubes != 0 ? this.maxGreenCubes : 1;
        return bluePower * redPower * greenPower;
    }

}
