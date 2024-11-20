package ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    public void print(String msg) {
        System.out.println(msg);
    }

    public double readDouble(String prompt) {
        return 0;
    }

    public double readDouble(String prompt, double min, double max) {
        return 0;
    }

    public float readFloat(String prompt) {
        return 0;
    }

    public float readFloat(String prompt, float min, float max) {
        return 0;
    }

    public int readInt(String prompt) {
        return 0;
    }

    public int readInt(String prompt, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        String input = "";


        print(prompt);
        input = sc.nextLine();
        choice = Integer.parseInt(input);




        return choice;


    }



    public long readLong(String prompt) {



        return 0;
    }

    public long readLong(String prompt, long min, long max) {
        return 0;
    }

    public String readString(String prompt) {
        Scanner sc = new Scanner(System.in);
        print(prompt);
        String input = sc.nextLine();
        return input;

    }
}
