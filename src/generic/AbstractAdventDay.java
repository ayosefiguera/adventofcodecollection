package generic;

import utils.ImportDataUtils;

import java.util.Optional;
import java.util.Scanner;

import static java.io.IO.println;

public abstract class AbstractAdventDay implements AdventDay {

    @Override
    public void run() {
        println(String.format("%nAdventOfCode Day %s", getDay()));
        println("----");
        println(String.format("Start One: %s", resolveStarOne()));
        println(String.format("Start Two: %s", resolveStarTwo()));
        println("----");
    }

    protected Optional<Scanner> getData() {
        return ImportDataUtils.load(getInput());
    }

    protected abstract String resolveStarOne();

    protected abstract String resolveStarTwo();

    protected abstract String getDay();

    protected abstract String getInput();
}
