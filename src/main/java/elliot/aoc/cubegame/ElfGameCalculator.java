package elliot.aoc.cubegame;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static elliot.aoc.util.Constant.*;

public class ElfGameCalculator {



    public ElfGameCalculator() {}

    public static int getSumOfPossibleGameIds(final List<String> input, final int blueLimit, final int redLimit, final int greenLimit) {
        List<Game> games = input.stream()
                .map(ElfGameCalculator::transformInputIntoGame)
                .filter(game -> game.getId() != -1)
                .toList();

        return games.stream()
                .filter(game -> game.isWithinLimits(blueLimit, redLimit, greenLimit))
                .map(Game::getId)
                .reduce(0, Integer::sum);
    }

    public static int getPowerOfCubes(final List<String> input) {
        List<Game> games = input.stream()
                .map(ElfGameCalculator::transformInputIntoGame)
                .filter(game -> game.getId() != -1)
                .toList();

        return games.stream()
                .map(Game::getPowerofMaxCubes)
                .reduce(0, Integer::sum);
    }

    private static Game transformInputIntoGame(String input) {
        Game game = new Game();
        String[] match = input.split(COLON);
        String gameId = match[0];
        String[] rounds = match[1].split(SEMI_COLON);

        //Set game Id
        game.setId(Integer.parseInt(gameId.split(SPACE)[1]));

        //Parse rounds
        int maxBlue = getMaxValueOfColour(rounds, "blue");
        int maxRed = getMaxValueOfColour(rounds, "red");
        int maxGreen = getMaxValueOfColour(rounds, "green");

        game.setMaxBlueCubes(maxBlue);
        game.setMaxRedCubes(maxRed);
        game.setMaxGreenCubes(maxGreen);

        return game;
    }

    private static Integer getMaxValueOfColour(String[] rounds, final String colour) {
        return Arrays.stream(rounds)
                .map(round -> round.split(COMMA))
                .flatMap(Arrays::stream)
                .filter(s -> s.contains(colour))
                .map(ElfGameCalculator::getNumberFromRound)
                .max(Integer::compareTo)
                .orElseGet(() -> -1);
    }

    private static int getNumberFromRound(String s) {
        String[] split = s.split(SPACE);
        return Integer.parseInt(split[1]);
    }

}
