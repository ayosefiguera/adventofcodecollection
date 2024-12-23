package seasons.one.days.one;

import generic.AbstractAdventDay;

import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class DayOne extends AbstractAdventDay {

    private static final String INPUT_DATA = "src/seasons/one/days/one/input/input";
    private static final char GO_UP = '(';

    @Override
    protected String resolveStarOne() {
        final Optional<Scanner> data = getData();
        if (data.isEmpty()) return "Not found input data.";
        final int floor = calcFloor(data.get());
        return String.valueOf(floor);
    }

    @Override
    protected String resolveStarTwo() {
        final Optional<Scanner> data = getData();
        if (data.isEmpty()) return "Not found input data.";
        final Integer floor = calcFirstPositionEnterBasement(data.get());
        return String.valueOf(floor);
    }

    @Override
    protected String getDay() {
        return "1st";
    }

    @Override
    protected String getInput() {
        return INPUT_DATA;
    }

    private Integer calcFloor(final Scanner data) {
        final AtomicInteger floor = new AtomicInteger();
        while (data.hasNext()) {
            data.nextLine()
                    .chars()
                    .forEach(c -> goToFloor((char) c, floor)
                    );
        }
        return floor.get();
    }

    private Integer calcFirstPositionEnterBasement(final Scanner data) {
        final AtomicInteger floor = new AtomicInteger();
        final AtomicInteger position = new AtomicInteger();

        while (data.hasNext()) {
            final String positions = data.nextLine();
            for (int i = 0; i < positions.length(); i++) {
                char character = positions.charAt(i);
                goToFloor(character, floor);
                position.getAndIncrement();
                if (floor.get() == -1) {
                    break;
                }
            }
        }
        return position.get();
    }

    private void goToFloor(final char character, final AtomicInteger floor) {
        if (character == GO_UP) {
            floor.getAndIncrement();
        } else {
            floor.getAndDecrement();
        }
    }
}
