package advent.of.code.challenge.days.day1;

import advent.of.code.challenge.days.InputReader;
import advent.of.code.challenge.exception.PuzzleInputException;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputReaderDay1 extends InputReader<Pair<List<Integer>, List<Integer>>> {

    @Override
    public Pair<List<Integer>, List<Integer>> readPuzzle(String fileName) {
        BufferedReader reader;
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + fileName + ".txt"));
            String line = reader.readLine();
            while (line != null) {
                List<Integer> list = Arrays.stream(line.split("   ")).map(Integer::valueOf).toList();
                if (list.size() != 2) {
                    throw new PuzzleInputException("Invalid line in puzzle input!");
                }
                firstList.add(list.get(0));
                secondList.add(list.get(1));
                line = reader.readLine();
            }
            reader.close();
            return Pair.of(firstList, secondList);
        } catch (IOException e) {
            throw new PuzzleInputException("Exception encountered when reading puzzle input!");
        }
    }
}
