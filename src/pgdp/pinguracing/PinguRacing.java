package pgdp.pinguracing;

import pgdp.MiniJava;

public class PinguRacing extends MiniJava {
    public static void main(String[] args) {
        int userInputPosA = readInt("Alan starting position:");
        int userInputPosB = readInt("Bjarne starting position:");
        int userInputDuration = readInt("Race duration:");
        while (userInputDuration < 0) {
            System.out.print("Please do not enter a negative number:");
            userInputDuration = readInt("Race duration:");
        }
        int seconds = 0;
        int speedB = 0;
        int speedA = 0;
        int maxSpeed = 128;
        while (seconds < userInputDuration / 2) {
            System.out.println("t = " + seconds);
            if (speedA <= 0) speedA = 0;
            if (speedB <= 0) speedB = 0;
            if (userInputPosA % 10 == 4 || userInputPosA % 10 == -4) speedA = (speedA / 2) + 1;
            else speedA += 7;
            if (userInputPosB % 13 == 0) speedB = (speedB * 2) + 1;
            else speedB += 3;
            if (speedA >= maxSpeed) speedA = maxSpeed;
            if (speedB >= maxSpeed) speedB = maxSpeed;
            seconds++;
            userInputPosA += speedA;
            userInputPosB += speedB;
            System.out.print("Alan position = " + userInputPosA + ";");
            System.out.println(" speed = " + speedA);
            System.out.print("Bjarne position = " + userInputPosB + ";");
            System.out.println(" speed = " + speedB);
        }
        while (seconds < userInputDuration) {
            System.out.println("t = " + seconds);
            if (seconds == userInputDuration * 3 / 5) speedA /= 4;
            else if (seconds == userInputDuration * 4 / 5) speedA /= 4;
            else speedA++;
            if (seconds >= userInputDuration - 13) speedB /= 2;
            else speedB--;
            if (speedA >= maxSpeed) speedA = maxSpeed;
            else if (speedA <= 0) speedA = 0;
            if (speedB >= maxSpeed) speedB = maxSpeed;
            else if (speedB <= 0) speedB = 0;
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
