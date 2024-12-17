package advent.of.code.challenge.days.day1;

import advent.of.code.challenge.days.AdventOfCode;
import advent.of.code.challenge.days.InputReader;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.logging.Logger;

public class AdventOfCodeDay1 extends AdventOfCode {

    private static final Logger LOG = Logger.getLogger(AdventOfCodeDay1.class.getName());

    private final InputReader<Pair<List<Integer>, List<Integer>>> inputReader = new InputReaderDay1();

    @Override
    public void play(String puzzleInput) {
        Pair<List<Integer>, List<Integer>> puzzle = inputReader.readPuzzle(puzzleInput);
        LOG.info("[Day1 - part 1]: " + countTotalDistance(puzzle));
//        LOG.info("[Day1 - part 2]: " + countTotalDistance(puzzle));
    }

    private long countTotalDistance(Pair<List<Integer>, List<Integer>> puzzle) {
        List<Integer> firstList = puzzle.getLeft().stream().sorted().toList();
        List<Integer> secondList = puzzle.getRight().stream().sorted().toList();
        long sum = 0;
        for (int i = 0; i < firstList.size(); i++) {
            sum += Math.abs(firstList.get(i) - secondList.get(i));
        }
        return sum;
    }
}
