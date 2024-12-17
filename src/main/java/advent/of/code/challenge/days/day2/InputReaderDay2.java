package advent.of.code.challenge.days.day2;

import advent.of.code.challenge.days.InputReader;
import advent.of.code.challenge.exception.PuzzleInputException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputReaderDay2 extends InputReader<List<List<Integer>>> {

    @Override
    public List<List<Integer>> readPuzzle(String fileName) {
        BufferedReader reader;
        List<List<Integer>> puzzle = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + fileName + ".txt"));
            String line = reader.readLine();
            while (line != null) {
                puzzle.add(Arrays.stream(line.split(" ")).map(Integer::valueOf).toList());
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new PuzzleInputException("Exception encountered when reading puzzle input!");
        }
        return puzzle;
    }
}
