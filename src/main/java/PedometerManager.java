import java.util.HashMap;
import java.util.Map;

public class PedometerManager {
    private final Map<Integer, Integer> data = new HashMap<>();

    public void addSteps(int day, int steps) {
        if (data.containsKey(day)) {
            data.put(day, data.get(day) + steps);
        } else {
            data.put(day, steps);
        }
    }

    public int getCountOfStepsToExceedDayMaximum(int day) {
        return data.getOrDefault(day, 0) + 1;
    }
}
