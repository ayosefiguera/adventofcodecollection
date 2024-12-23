package seasons.one;

import seasons.one.days.one.DayOne;
import seasons.one.days.two.DayTwo;

public class SeasonOne {

    public void run() {
        var dayOne = new DayOne();
        var dayTwo = new DayTwo();
        dayOne.run();
        dayTwo.run();
    }

}
