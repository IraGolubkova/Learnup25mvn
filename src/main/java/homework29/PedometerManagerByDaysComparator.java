package homework29;

import java.util.Comparator;

public class PedometerManagerByDaysComparator implements Comparator<PedometerManager> {
    final int minOfSteps;

    public PedometerManagerByDaysComparator(int minOfSteps) {
        super();
        this.minOfSteps = minOfSteps;
    }

    @Override
    public int compare(PedometerManager p1, PedometerManager p2) {
        return p1.countDaysWhenStepsExceedMinimum(minOfSteps) - p2.countDaysWhenStepsExceedMinimum(minOfSteps);
    }

}
