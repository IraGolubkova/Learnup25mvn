package homework29;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class PedometerManager implements Comparable<PedometerManager> {
    private final Map<Integer, Integer> data = new HashMap<>();

    public int addSteps(int day, int steps) throws IllegalDayException, IllegalStepsException {
        if (day < 1 || day > 365) {
            throw new IllegalDayException(day);
        }
        if (steps < 0) {
            throw new IllegalStepsException(steps);
        }
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

    public void printAllDaysByCriteria(Predicate<Integer> predicate) {
        data.entrySet()
                .stream()
                .filter(it -> predicate.test(it.getValue()))
                .forEach(it -> System.out.println("день " + it.getKey() + " шагов " + it.getValue()));
    }

}


//Добавьте в шагомер проверку на корректность дня (пусть это будет порядковый номер дня в году от 1 до 365, без високосных)
//и шагов (положительное число). Если некорректно - выкидываем исключения ваших собственных типов -
// IllegalDayException, IllegalStepsException. Протестируйте исключения в тестах.