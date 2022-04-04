package homework28;
import org.junit.jupiter.api.Test;

class PedometerManagerTest {

    @Test
    void shouldPrintAllDaysByCriteria() {
        PedometerManager p = new PedometerManager();
        p.addSteps(1, 1200);
        p.addSteps(2, 10200);
        p.addSteps(3, 20200);

        p.printAllDaysByCriteria(it -> it > 10000);

    }
}

