package ControlElevator;

public class ElevatorSystem implements Step {
    private Elevator[] evenFloorElevators;
    private Elevator[] oddFloorElevators;
    private Elevator[] staffElevators;

    public ElevatorSystem(Elevator[] even, Elevator[] odd, Elevator[] staff) {
        this.evenFloorElevators = even;
        this.oddFloorElevators = odd;
        this.staffElevators = staff;
    }

    @Override
    public void requestElevator(Type type, int destinationFloor) throws AllElevatorsBusyException {
        Elevator[] availableElevators;

        switch (type) {
            case EVEN:
                availableElevators = evenFloorElevators;
                break;
            case ODD:
                availableElevators = oddFloorElevators;
                break;
            case STUFF:
                availableElevators = staffElevators;
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип лифта: " + type);
        }

        for (Elevator elevator : availableElevators) {
            if (elevator.state() == ElevatorState2.STOP) {
                elevator.callElevator(destinationFloor);
                System.out.println("Лифт вызван на этаж " + destinationFloor);
                return;
            }
        }
        throw new AllElevatorsBusyException("Все лифты заняты! Тип: " + type + ", заказанный этаж: " + destinationFloor);
    }

    public void workAll() {
        for (Elevator elevator : evenFloorElevators) {
            elevator.work();
        }
        for (Elevator elevator : oddFloorElevators) {
            elevator.work();
        }
        for (Elevator elevator : staffElevators) {
            elevator.work();
        }
    }

}
