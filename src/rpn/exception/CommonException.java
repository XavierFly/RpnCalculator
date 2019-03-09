package rpn.exception;

public class CommonException extends Exception {
    private static String errorMessage;

    public CommonException() {
        super();
    }

    public CommonException(String errorCode) {
        switch (errorCode) {
            case "E001":
                errorMessage = "The properties is not found.";
                break;
            default:
                errorMessage = errorCode;
                break;
        }
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
