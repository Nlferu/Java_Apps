// Our Own class for error handling

public class NoRecordFound extends Exception {
    public NoRecordFound() {
        super();
    }

    public NoRecordFound(String error) {
        super(error);
    }
}
