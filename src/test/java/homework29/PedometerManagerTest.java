package homework29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PedometerManagerTest {

    @ParameterizedTest
    @CsvSource({
            "-1",
            "0",
            "366",
            "1000"
    })
    public void shouldThrowExceptionWhenDayIsInvalid(int givenDay) {
        PedometerManager pedometerManager = new PedometerManager();

        Assertions.assertThrows(IllegalDayException.class, () -> {
            pedometerManager.addSteps(givenDay, 500);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
            "100",
            "364",
            "365"
    })
    public void shouldNotThrowExceptionWhenDayIsValid(int givenDay) {
        PedometerManager pedometerManager = new PedometerManager();

        Assertions.assertDoesNotThrow(() -> {
            pedometerManager.addSteps(givenDay, 500);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "-1",
            "-100"
    })
    public void shouldThrowExceptionWhenStepsIsInvalid(int givenSteps) {
        PedometerManager pedometerManager = new PedometerManager();

        Assertions.assertThrows(IllegalStepsException.class, () -> {
            pedometerManager.addSteps(1, givenSteps);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "100",
            "1000",
    })
    public void shouldNotThrowExceptionWhenStepsValid(int givenSteps) {
        PedometerManager pedometerManager = new PedometerManager();

        Assertions.assertDoesNotThrow(() -> {
            pedometerManager.addSteps(1, givenSteps);
        });
    }

    @Test
    public void shouldComparePedometersByTotalCountOfSteps() throws IllegalStepsException, IllegalDayException {
        PedometerManager p1 = new PedometerManager();
        PedometerManager p2 = new PedometerManager();

        assertEquals(0, p1.compareTo(p2));
        assertEquals(0, p2.compareTo(p1));

        p1.addSteps(1, 1000);
        p2.addSteps(1, 500);
        assertTrue(p1.compareTo(p2) > 0);
        assertTrue(p2.compareTo(p1) < 0);

        p2.addSteps(2, 2000);
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);

        p1.addSteps(3, 1500);
        assertEquals(0, p1.compareTo(p2));
        assertEquals(0, p2.compareTo(p1));
    }

    @Test
    void shouldPrintAllDaysByCriteria() throws IllegalStepsException, IllegalDayException {
        PedometerManager p = new PedometerManager();
        p.addSteps(1, 1200);
        p.addSteps(2, 10200);
        p.addSteps(3, 20200);

        p.printAllDaysByCriteria(it -> it > 10000);

    }
}

