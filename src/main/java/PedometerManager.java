import java.util.HashMap;
import java.util.Map;

public class PedometerManager {
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
}
//    Пояснение: метод add должен добавлять/перезаписывать значение шагов,
//        анализировать максимум и выводить количество оставшихся шагов до превышения максимума

//Создайте менеджер шагометра с методом `add(int day, int steps)`, который не перезаписывает значение за день,
// а добавляет к уже текущему значению. Пусть менеджер возвращает число, равное количеству шагов, которое надо сделать в этот день
// чтобы обновить превысить текущий максимум шагов за день.