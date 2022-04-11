package homework29;

public class IllegalStepsException extends Exception {

    public IllegalStepsException(int steps) {
        super("Шаги должны быть больше или равны нулю. Вы передали: " + steps);
    }

}
