package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//import external.SafeReader.SafeReader;
import static java.lang.System.exit;
import static java.lang.System.out;

public class Main {

    public static ITaskSolver[] Tasks = {new Task0(), new Task1(), new Task2(), new Task3(), new Task4(), new Task5()};

    public static void main(String[] args) {
        while (true)
            drawMenu();
    }

    private static void drawMenu() {
        out.println("1\n2\n3\n4\n5\n0 - exit");
        int task;

        do {
            task = SafeReader.readInt();
            if (task < 0 || task >= Tasks.length) {
                out.println("Incorrect value");
                continue;
            }
            break;

        } while (true);

        Tasks[task].SolveTask();
    }

}

interface ITaskSolver {
    void SolveTask();
}

class Task0 implements ITaskSolver {

    public void SolveTask() {
        exit(0);
    }
}

class Task1 implements ITaskSolver {

    public void SolveTask() {
        Scanner in = new Scanner(System.in);
        out.println("Input 2 values");
        double x = SafeReader.readDouble();
        double y = SafeReader.readDouble();

        double result = (Math.abs(Math.sin(x) - y) + 2 * x) / (Math.sqrt(1 + Math.abs(x * y)));

        out.println("Result: " + result + "\nPress any key to go back\n");

        in.nextLine();
    }
}

class Task2 implements ITaskSolver {

    public void SolveTask() {
        Scanner in = new Scanner(System.in);
        out.println("Print 3 numbers");

        double[] inputs = new double[3];

        for (int i = 0; i < inputs.length; i++)
            inputs[i] = SafeReader.readDouble();

        out.print("Numbers that are between 1 and 3:");

        for (int i = 0; i < inputs.length; i++)
            if (inputs[i] > 1 && inputs[i] < 3)
                out.print(" " + inputs[i]);

        out.println("\nPress any key to go back");

        in.nextLine();
    }
}

class Task3 implements ITaskSolver {

    public void SolveTask() {
        Scanner in = new Scanner(System.in);
        out.println("Input epsilon");

        double epsilon = SafeReader.readDouble();

        double k = 1;
        double sum = 1 / (2 * k - 1) * (2 * k + 1);
        out.println(sum);

        while (sum < epsilon) {
            k++;
            sum += 1 / (2 * k - 1) * (2 * k + 1);
            out.println(sum);
        }

        out.println("Sum is " + sum + "\nPress any key to go back");

        in.nextLine();
    }
}

class Task4 implements ITaskSolver {

    public void SolveTask() {
        Scanner in = new Scanner(System.in);
        double[] inputs = new double[16];
        double min = Double.MAX_VALUE;

        out.println("Input 16 values:");

        for (int i = 0; i < inputs.length; i++)
            inputs[i] = SafeReader.readDouble();

        for (int i = 0; i < inputs.length; i++)
            if (inputs[i] < min)
                min = inputs[i];

        out.println("Min: " + min + "\nPress any key to go back");

        in.nextLine();
    }
}

class Task5 implements ITaskSolver {

    public void SolveTask() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i <= 10; i++)
            out.println("X at " + i + " = " + calculate(i));

        out.println("Press any key to go back");
        in.nextLine();
    }

    private double calculate(double x) {
        return x - (Math.pow(x, 3) / 6) + (Math.pow(x, 5) / 120);
    }

}

class SafeReader {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() {
        int input = 0;

        do {
            try {
                input = Integer.parseInt(in.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Wrong input. Expected type: Integer. Try again");
            }
        } while (true);

        return input;
    }

    public static double readDouble() {
        double input = 0;

        do {
            try {
                input = Double.parseDouble(in.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Wrong input. Expected type: Double. Try again");
            }
        } while (true);

        return input;
    }

    public static float readFloat() {
        float input = 0;

        do {
            try {
                input = Float.parseFloat(in.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Wrong input. Expected type: Float. Try again");
            }
        } while (true);

        return input;
    }

    public static String readString() {
        String input = "";

        do {
            try {
                input = in.readLine();
                break;
            } catch (Exception e) {
                System.out.println("Wrong input. Try again");
            }
        } while (true);

        return input;
    }
}