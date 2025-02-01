package ControlElevator;

import java.util.Random;

public class Iterations10000 {
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
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            if (i % 20 == 0) {
                int floor = 2 + random.nextInt(16);
                Type type = Type.values()[random.nextInt(Type.values().length)];

                try {
                    system.requestElevator(type, floor);
                } catch (AllElevatorsBusyException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }

            system.workAll();
        }
    }
}

