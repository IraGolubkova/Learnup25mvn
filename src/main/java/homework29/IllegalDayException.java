package homework29;

public class IllegalDayException extends Exception {

    public IllegalDayException(int day) {
        super("День должен существовать, а этого дня нет в году: " + day);
    }

}
