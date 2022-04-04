package homework28;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

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
        return sum () - pedometerManager.sum();
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
//    Добавьте в шагомер метод `printAllDaysByCriteria`, который принимал бы предикат от количества шагов
//    и выводил бы на экран записи вида:
//
//        день 3 шагов 15
//        день 5 шагов 20
//        ...
//
//        Продемонстрируйте работу того метода в тесте на предикате, который отвечает true если количество шагов больше 10000.
//        Предикат реализуйте лямбдой