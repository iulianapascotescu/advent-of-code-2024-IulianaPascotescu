package advent.of.code.challenge.days.day2;

import advent.of.code.challenge.days.AdventOfCode;
import advent.of.code.challenge.days.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class AdventOfCodeDay2 extends AdventOfCode {

    private static final Logger LOG = Logger.getLogger(AdventOfCodeDay2.class.getName());

    private final InputReader<List<List<Integer>>> inputReader = new InputReaderDay2();

    private static boolean isAscending(Integer firstLevel, Integer secondLevel) {
        return secondLevel - firstLevel >= 1 && secondLevel - firstLevel <= 3;
    }

    private static boolean isDescending(Integer firstLevel, Integer secondLevel) {
        return firstLevel - secondLevel >= 1 && firstLevel - secondLevel <= 3;
    }

    @Override
    public void play(String puzzleInput) {
        List<List<Integer>> puzzle = inputReader.readPuzzle(puzzleInput);
        LOG.info("[Day2 - part 1]: " + countSafeReports(puzzle));
        LOG.info("[Day2 - part 2]: " + countReportsWithOneBadLevel(puzzle));
    }

    private long countReportsWithOneBadLevel(List<List<Integer>> reports) {
        int reportsWithOneBadLevel = 0;
        for (List<Integer> report : reports) {
            for (int i = 0; i < report.size(); i++) {
                List<Integer> subReport = new ArrayList<>(report);
                subReport.remove(i);
                if (isReportSafe(subReport)) {
                    reportsWithOneBadLevel++;
                    break;
                }
            }
        }
        return reportsWithOneBadLevel;
    }

    private long countSafeReports(List<List<Integer>> puzzle) {
        return puzzle.stream().map(this::isReportSafe).filter(Boolean::booleanValue).count();
    }

    private boolean isReportSafe(List<Integer> levels) {
        if (levels.size() < 3) {
            return true;
        }

        Boolean ascending = null;

        for (int i = 0; i < levels.size() - 1; i++) {

            Integer currentLevel = levels.get(i);
            Integer nextLevel = levels.get(i + 1);

            if (isDescending(currentLevel, nextLevel)) {
                if (ascending != null && ascending) {
                    return false;
                }
                ascending = false;
            } else if (isAscending(currentLevel, nextLevel)) {
                if (ascending != null && !ascending) {
                    return false;
                }
                ascending = true;
            } else {
                return false;
            }
        }
        return true;
    }

}
