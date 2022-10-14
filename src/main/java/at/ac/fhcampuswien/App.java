package at.ac.fhcampuswien;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);

    //todo Task 1
    public void largestNumber() {
        System.out.print("Number 1: ");
        double number = sc.nextDouble();
        double largestNumber = number;
        double nextNumber = number;

        if (number <= 0) {
            System.out.println("No number entered.");
            return;
        }
        /**
         * The following (1) line of Code has been taken from the Internet | URL: https://mkyong.com/java/java-display-double-in-2-decimal-points/, last visit: 07.10.2022
         */
        DecimalFormat df = new DecimalFormat("0.00");

        for (int i = 2; nextNumber > 0; i++) {
            System.out.print("Number " + i + ": ");
            nextNumber = sc.nextDouble();

            if (nextNumber > number) {
                largestNumber = nextNumber;
            }
        }
        System.out.println("The largest number is " + df.format(largestNumber));

    }


    //todo Task 2
    public void stairs() {
        System.out.print("n: ");
        int rowCount = sc.nextInt();
        int count = 0;
        if (rowCount <= 0) {
            System.out.println("Invalid number!");
        }
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= i; j++) {
                count++;
                System.out.print(count + " ");

            }

            System.out.println();
        }

    }


    //todo Task 3
    public void printPyramid() {

        int i;
        int j;
        int rowCount = 6;

        for (i = 0; i < rowCount; i++) {

            for (j = rowCount - i - 1; j > 0; j--) { //Abstände (mehr -> weniger)
                System.out.print(" ");
            }
            for (j = 0; j < i * 2 + 1; j++) { //Anz. der Sterne
                System.out.print("*");
            }
            System.out.println();
        }

    }

    //todo Task 4
    public void printRhombus() {

        System.out.print("h: ");
        int height = sc.nextInt();
        System.out.print("c: ");
        char character = sc.next().charAt(0);

        if (height % 2 == 0) {
            System.out.println("Invalid number!");

        }

        if (height % 2 == 1) {
            for (int row = 0; row <= height / 2; row++) {
                for (int rowNext = row; rowNext < height / 2; rowNext++) {
                    System.out.print(" ");
                }
                for (int difference = 0 - row; difference <= row; difference++) {
                    // c ist character
                    System.out.print((char) (character - Math.abs(difference)));
                }
                System.out.println();
            }
            for (int row = height / 2; row > 0; row--) {
                for (int rowNext = row; rowNext <= height / 2; rowNext++) {
                    System.out.print(" ");
                }
                for (int difference = 0 - row + 1; difference < row; difference++) {
                    System.out.print((char) (character - Math.abs(difference)));
                }
                System.out.println();
            }
        }
    }

    //todo Task 5
    public void marks() {
        int counter = 0;
        int addedMarks = 0;
        int countNegativeMark = 0;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("Mark 1: ");
        int markInput = sc.nextInt();
        if (markInput < 0 || markInput > 5) {
            System.out.println("Invalid mark!");
            System.out.print("Mark 1: ");
            markInput = sc.nextInt();

        } else if (markInput == 0) {

            double average = 0.00;
            System.out.println("Average: " + df.format(average));
            System.out.println("Negative marks: " + countNegativeMark);
        } else if (markInput == 5) {
            countNegativeMark = countNegativeMark + 1;
            addedMarks = addedMarks + markInput;
            counter = counter + 1;
        } else if ((markInput > 0) && (markInput < 6)) {
            addedMarks = addedMarks + markInput;
            counter = counter + 1;
        }

        for (int i = 2; markInput != 0; i++) { //Schleife beginnt bei zweiter Eingabe, darf nicht Null sein
            System.out.print("Mark " + i + ": ");
            markInput = sc.nextInt();

            if ((markInput > 0) && (markInput < 6) && (markInput != 5)) {
                addedMarks = addedMarks + markInput;
                counter = counter + 1;

            } else if (markInput < 0 || markInput > 5) {
                System.out.println("Invalid mark!");
                System.out.print("Mark " + i + ": ");
                markInput = sc.nextInt();
                counter = counter + 1;
                addedMarks = addedMarks + markInput;

            } else if (markInput == 0) {
                double average = (double) addedMarks / counter;
                System.out.println("Average: " + df.format(average));
                System.out.println("Negative marks: " + countNegativeMark);
            } else if (markInput == 5) {
                countNegativeMark = countNegativeMark + 1;
                counter = counter + 1;
                addedMarks = addedMarks + markInput;

            }
        }
    }

    //todo Task 6
    public void happyNumbers() {

        int number;
        System.out.print("n: ");
        number = sc.nextInt();
        int sum = 0;


        while (number != 1) { //Aufhören, wenn Nummer 1 ist

            int remaining = number % 10; //Letzte Stelle der Zahl bekommen
            sum = sum + (remaining * remaining);
            number = number / 10; //Zahl ohne letzte Stelle bekommen
            if (number == 0) { //Wenn keine Zahl übrig ist
                number = sum; //Mit Summe weitermachen
                sum = 0;
            } else if (sum == 4) {
                System.out.println("Sad number!");
                break;
            }
        }

        if (number == 1) {
            System.out.println("Happy number!");
        }
        sc.close();
    }


    public static void main(String[] args) {
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }

}