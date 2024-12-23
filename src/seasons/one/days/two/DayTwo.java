package seasons.one.days.two;

import generic.AbstractAdventDay;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class DayTwo extends AbstractAdventDay {

    private static final String INPUT_DATA = "src/seasons/one/days/two/input/input";

    @Override
    protected String resolveStarOne() {
        final Optional<Scanner> data = getData();
        if (data.isEmpty()) return "Not found input data.";
        final int result = wrappingPaperToOrder(data.get());
        return String.valueOf(result);
    }

    @Override
    protected String resolveStarTwo() {
        final Optional<Scanner> data = getData();
        if (data.isEmpty()) return "Not found input data.";
        final int result = feetOfRibbonToOrder(data.get());
        return String.valueOf(result);
    }

    @Override
    protected String getDay() {
        return "2nd";
    }

    @Override
    protected String getInput() {
        return INPUT_DATA;
    }

    private int wrappingPaperToOrder(final Scanner data) {
        int feetOfWrappingPaper = 0;
        while (data.hasNext()) {
            feetOfWrappingPaper += getTotalAreaOfWrappingPaper(data.nextLine().split("x"));
        }
        return feetOfWrappingPaper;
    }

    private int feetOfRibbonToOrder(final Scanner data) {
        int feetOfRibbon = 0;
        while (data.hasNext()) {
            feetOfRibbon += getTotalLengthOfRibbon(data.nextLine().split("x"));
        }
        return feetOfRibbon;
    }

    private Integer getTotalAreaOfWrappingPaper(final String[] vector) {
        final int[] dimension = Arrays.stream(vector)
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(dimension);
        final int l = dimension[0];
        final int w = dimension[1];
        final int h = dimension[2];
        return 2 * (l * w + w * h + h * l) + l * w;
    }

    private Integer getTotalLengthOfRibbon(final String[] vector) {
        final int[] dimension = Arrays.stream(vector)
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(dimension);
        final int l = dimension[0];
        final int w = dimension[1];
        final int h = dimension[2];
        return 2 * (l + w) + (l * w * h);
    }
}
