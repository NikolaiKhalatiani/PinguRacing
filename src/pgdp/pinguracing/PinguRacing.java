package pgdp.pinguracing;

import pgdp.MiniJava;

import static pgdp.MiniJava.*; //Diesen Import nicht löschen! Do not delete this import!

public class PinguRacing extends MiniJava {
    public static void main(String[] args) {
        int userinput_posa = readInt("Alan starting position:");
        int userinput_posb = readInt("Bjarne starting position:");
        int userinput_time = readInt("Race duration:");
        while (userinput_time < 0) {
            writeConsole("Please do not enter a negative number:");
            userinput_time = readInt("");
        }
        int seconds = 0;
        int speed_b = 0;
        int speed_a = 0;
        int speed_max = 128;
        while (seconds < userinput_time / 2) {
            write("t = " + seconds);
            if (speed_a <= 0) speed_a = 0;
            if (speed_b <= 0) speed_b = 0;
            if (userinput_posa % 10 == 4 || userinput_posa % 10 == -4) speed_a = (speed_a / 2) + 1;
            else speed_a += 7;
            if (userinput_posb % 13 == 0) speed_b = (speed_b * 2) + 1;
            else speed_b += 3;
            if (speed_a >= speed_max) speed_a = speed_max;
            if (speed_b >= speed_max) speed_b = speed_max;
            seconds++;
            userinput_posa += speed_a;
            userinput_posb += speed_b;
            writeConsole("Alan position = " + userinput_posa + ";");
            write(" speed = " + speed_a);
            writeConsole("Bjarne position = " + userinput_posb + ";");
            write(" speed = " + speed_b);
        }
        while (seconds < userinput_time) {
            write("t = " + seconds);
            if (seconds == userinput_time * 3 / 5) speed_a /= 4;
            else if (seconds == userinput_time * 4 / 5) speed_a /= 4;
            else speed_a++;
            if (seconds >= userinput_time - 13) speed_b /= 2;
            else speed_b--;
            if (speed_a >= speed_max) speed_a = speed_max;
            else if (speed_a <= 0) speed_a = 0;
            if (speed_b >= speed_max) speed_b = speed_max;
            else if (speed_b <= 0) speed_b = 0;
            seconds++;
            userinput_posa += speed_a;
            userinput_posb += speed_b;
            writeConsole("Alan position = " + userinput_posa + ";");
            write(" speed = " + speed_a);
            writeConsole("Bjarne position = " + userinput_posb + ";");
            write(" speed = " + speed_b);
        }
        if (userinput_posa == userinput_posb) writeConsole("Draw!");
        else if (userinput_posa > userinput_posb) writeConsole("Alan wins!");
        else writeConsole("Bjarne wins!");
    }
}