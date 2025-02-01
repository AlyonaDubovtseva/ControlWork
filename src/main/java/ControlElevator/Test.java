package ControlElevator;

public class Test {
    public static void main(String[] args) {
        Elevator[] evenElevators = new Elevator[3];
        Elevator[] oddElevators = new Elevator[3];
        Elevator[] staffElevators = new Elevator[1];

        for (int i = 0; i < 3; i++) {
            evenElevators[i] = new CallToEvenFloor();
            oddElevators[i] = new CallToOddFloor();
        }

        staffElevators[0] = new ElevatorForStuff();

        ElevatorSystem system = new ElevatorSystem(evenElevators, oddElevators, staffElevators);

        try {
            system.requestElevator(Type.EVEN, 4);
            system.requestElevator(Type.ODD, 5);
            system.requestElevator(Type.STUFF, 10);
        } catch (AllElevatorsBusyException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
