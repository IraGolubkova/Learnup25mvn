package homework29;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedometerManagerByDaysComparatorTest {
    private final PedometerManager p1 = new PedometerManager();
    private final PedometerManager p2 = new PedometerManager();

    {
        try {
            p1.addSteps(1, 500);
        } catch (IllegalDayException | IllegalStepsException e) {
            e.printStackTrace();
        }
        try {
            p1.addSteps(1, 500); // 1000
        } catch (IllegalDayException | IllegalStepsException e) {
            e.printStackTrace();
        }
        try {
            p1.addSteps(2, 1500); // 1500
        } catch (IllegalDayException | IllegalStepsException e) {
            e.printStackTrace();
        }
        try {
            p1.addSteps(3, 2000); // 2000
        } catch (IllegalDayException | IllegalStepsException e) {
            e.printStackTrace();
        }

        try {
            p2.addSteps(1, 300);  // 300
        } catch (IllegalDayException | IllegalStepsException e) {
            e.printStackTrace();
        }
        try {
            p2.addSteps(2, 600);  // 600
        } catch (IllegalDayException | IllegalStepsException e) {
            e.printStackTrace();
        }
        try {
            p2.addSteps(3, 900);  // 900
        } catch (IllegalDayException | IllegalStepsException e) {
            e.printStackTrace();
        }
        try {
            p2.addSteps(4, 1600); // 1600
        } catch (IllegalDayException | IllegalStepsException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, -1",
            "500, 0",
            "600, 1",
            "1500, 0",
            "1501, 0",
            "1600, 1",
            "3000, 0",
    })
    public void shouldCompareByCountOfDaysWhenStepsExceedMinimum(
            int givenMinOfSteps,
            int expectedSign
    ) {
        // when
        PedometerManagerByDaysComparator comparator = new PedometerManagerByDaysComparator(givenMinOfSteps);
        int actualSign = sign(comparator.compare(p1, p2));
        int actualReverseSign = sign(comparator.compare(p2, p1));

        // then
        assertEquals(expectedSign, actualSign);
        assertEquals(-expectedSign, actualReverseSign);
    }

    private int sign(int value) {
        return Integer.compare(value, 0);
    }
}
