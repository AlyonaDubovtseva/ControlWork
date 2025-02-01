package ControlElevator;

public interface Call {
    void requestElevator(Type type, int destinationFloor) throws AllElevatorsBusyException;
}
