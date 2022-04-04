package homework27;

import java.util.HashMap;
import java.util.Map;

public class PedometerManager implements Comparable<PedometerManager> {
    private final Map<Integer, Integer> data = new HashMap<>();

    public int addSteps(int day, int steps) {
        if (data.containsKey(day)) {
            data.put(day, data.get(day) + steps);
        } else {
            data.put(day, steps);
        }
        return getCountOfStepsToExceedMaximum(day);
    }


    private int getCountOfStepsToExceedMaximum(int day) {
        int maxSteps = calculateMaxOfSteps();
        int stepsInDay = data.getOrDefault(day, 0);
        return maxSteps - stepsInDay + 1;
    }

    private int calculateMaxOfSteps() {
        int max = 0;
        for (int val : data.values()) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    @Override
    public int compareTo(PedometerManager pedometerManager) {
        return sum() - pedometerManager.sum();
    }

    public int countDaysWhenStepsExceedMinimum(int minOfSteps) {
        int countOfDays = 0;
        for (int stepsInDay : data.values()) {
            if (stepsInDay > minOfSteps) {
                ++countOfDays;
            }
        }
        return countOfDays;
    }

    private int sum() {
        int sum = 0;
        for (int steps : data.values()) {
            sum += steps;
        }
        return sum;
    }
}

//    Добавьте возможность шагомерам сравниваться между собой.
//        Сделайте через Comparable сравнение по сумме шагов, а через Comparator сравнение по количеству дней,
//        в которых шагов больше минимума (минимум должен задаваться в конструкторе
//        компаратора).
