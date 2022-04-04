package homework27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void shouldComparePedometersByTotalCountOfSteps() {
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
}


//В тестах покажите что всё работает (можно на примере сортировки, можно на примерах ассертов на методы compareTo и compare).