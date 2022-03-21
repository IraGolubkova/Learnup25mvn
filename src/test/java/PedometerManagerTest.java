import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PedometerManagerTest {
    PedometerManager pedometerManager = new PedometerManager();
    {
        pedometerManager.addSteps(1, 1000);
        pedometerManager.addSteps(1, 2000);
        pedometerManager.addSteps(1, 3000);
        pedometerManager.addSteps(2, 5000);
        pedometerManager.addSteps(3, 500);
        pedometerManager.addSteps(3, 600);
        pedometerManager.addSteps(1, 500);

    }

    @ParameterizedTest
    @CsvSource({
            "1, 6501",
            "2, 5001",
            "3, 1101",
            "4, 1",
    })
    public void shouldCalculateCountOfStepsToExceedADayMaximum(
            int givenDay,
            int expectedCountOfSteps
    ) {
        // when
        int actualCountOfSteps = pedometerManager.getCountOfStepsToExceedDayMaximum(givenDay);

        // then
        Assertions.assertEquals(expectedCountOfSteps, actualCountOfSteps);
    }


}