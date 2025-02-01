package ControlElevator;

public abstract class Elevator implements ElevatorStateInterface {
    protected ElevatorState2 state;
    protected int countOfFloors;
    protected Integer destinationFloor;

    public Elevator(ElevatorState2 state, int countOfFloors, Integer destinationFloor) {
        this.state = state;
        this.countOfFloors = countOfFloors;
        this.destinationFloor = destinationFloor;
    }

    public void callElevator(int floor) {
        if (destinationFloor != null) {
            System.out.println("лифт уже был вызван");
            return;
        }
        this.destinationFloor = floor;
        if (floor > countOfFloors) {
            state = ElevatorState2.UP;
        } else if (floor < countOfFloors) {
            state = ElevatorState2.DOWN;
        } else {
            state = ElevatorState2.STOP;
        }
    }

    @Override
    public ElevatorState2 state() {
        return state;
    }

    public void work() {
        if (state == ElevatorState2.UP) {
            countOfFloors++;
            if (countOfFloors == destinationFloor) {
                state = ElevatorState2.STOP;
                destinationFloor = null;
            }
        } else if (state == ElevatorState2.DOWN) {
            countOfFloors--;
            if (countOfFloors == destinationFloor) {
                state = ElevatorState2.STOP;
                destinationFloor = null;
            }
        }
    }



}
