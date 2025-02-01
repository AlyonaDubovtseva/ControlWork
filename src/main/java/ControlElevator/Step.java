package ControlElevator;

public interface Step {
    void requestElevator(Type type, int destinationFloor) throws AllElevatorsBusyException;
}
