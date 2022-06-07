package pgdp.pinguracing;

import pgdp.MiniJava;

public class PinguRacing extends MiniJava {
    public static void main(String[] args) {
        int userInputPosA = readInt("Alan starting position:"); //asking user for Alan's starting position
        int userInputPosB = readInt("Bjarne starting position:"); //asking user for Bjarne's starting position
        int userInputDuration = readInt("Race duration:"); //asking user for duration of the race
        while (userInputDuration < 0) { //loop for checking the duration to be non-negative
            userInputDuration = readInt("Please do not enter a negative number:");
        }
        int seconds = 0;
        int speedB = 0;
        int speedA = 0;
        int maxSpeed = 128; 
        //implementing logic for first half of the race
        while (seconds < userInputDuration / 2) {
            System.out.println("t = " + seconds);
            if (speedA < 0) speedA = 0; //resetting Alan's speed if it becomes less then 0
            if (speedB < 0) speedB = 0; //resetting Bjarne's speed if it becomes less then 0
            if (userInputPosA % 10 == 4 || userInputPosA % 10 == -4) speedA = (speedA / 2) + 1; //changing Alan's speed according to his phobia
            else speedA += 7;
            if (userInputPosB % 13 == 0) speedB = (speedB * 2) + 1; //changing Bjarne's speed according to his phobia
            else speedB += 3;
            if (speedA > maxSpeed) speedA = maxSpeed; //setting Alan's speed to maximal if it overflows
            if (speedB > maxSpeed) speedB = maxSpeed; //setting Bjarne's speed to maximal if it overflows
            seconds++; //incrementing time
            userInputPosA += speedA; //updating Alan's position
            userInputPosB += speedB; //updating Bjarne's position
            System.out.print("Alan position = " + userInputPosA + ";");
            System.out.println(" speed = " + speedA);
            System.out.print("Bjarne position = " + userInputPosB + ";");
            System.out.println(" speed = " + speedB);
        }
        //implementing logic for second half of the race
        while (seconds < userInputDuration) {
            System.out.println("t = " + seconds);
            if (seconds == userInputDuration * 3 / 5) speedA /= 4;
            else if (seconds == userInputDuration * 4 / 5) speedA /= 4;
            else speedA++;
            if (seconds > userInputDuration - 13) speedB /= 2;
            else speedB--;
            if (speedA > maxSpeed) speedA = maxSpeed;
            else if (speedA < 0) speedA = 0;
            if (speedB > maxSpeed) speedB = maxSpeed;
            else if (speedB < 0) speedB = 0;
            seconds++;
            userInputPosA += speedA;
            userInputPosB += speedB;
            System.out.print("Alan position = " + userInputPosA + ";");
            System.out.println(" speed = " + speedA);
            System.out.print("Bjarne position = " + userInputPosB + ";");
            System.out.println(" speed = " + speedB);
        }
        if (userInputPosA == userInputPosB) System.out.println("Draw!");
        else if (userInputPosA > userInputPosB) System.out.println("Alan wins!");
        else System.out.println("Bjarne wins!");
    }
}
