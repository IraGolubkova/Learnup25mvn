import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PedometerManagerTest {

    @Test
    public void shouldCalculateCountOfStepsToExceedADayMaximum() {
        PedometerManager pedometerManager = new PedometerManager();

        assertEquals(1, pedometerManager.addSteps(1, 1000)); // 1=1000
        assertEquals(1, pedometerManager.addSteps(1, 1000)); // 1=2000
        assertEquals(1501, pedometerManager.addSteps(2, 500)); //1=2000,2=500
        assertEquals(1, pedometerManager.addSteps(3, 3000)); //1=2000,2=500,3=3000
        assertEquals(501, pedometerManager.addSteps(1, 500)); //1=2500,2=500,3=3000

    }


}