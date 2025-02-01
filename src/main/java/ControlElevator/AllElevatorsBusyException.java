package ControlElevator;

public class AllElevatorsBusyException extends RuntimeException {
    public AllElevatorsBusyException(String message) {
        super(message);
    }
}
