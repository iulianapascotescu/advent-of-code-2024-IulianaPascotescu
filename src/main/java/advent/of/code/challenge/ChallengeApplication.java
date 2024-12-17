package advent.of.code.challenge;

import advent.of.code.challenge.days.day1.AdventOfCodeDay1;
import advent.of.code.challenge.days.day2.AdventOfCodeDay2;

public class ChallengeApplication {

    public static void main(String[] args) {
        AdventOfCodeDay1 day1 = new AdventOfCodeDay1();
        day1.play("puzzle-input-day1");

        AdventOfCodeDay2 day2 = new AdventOfCodeDay2();
        day2.play("puzzle-input-day2");
    }

}
