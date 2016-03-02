/**
 * Created by Grigoryan on 02.03.2016.
 */

import java.util.Random;
import java.util.Scanner;

public class StudentApp {
    private static String[][] _studentData;
    private static String[] _classes = new String[]{"OOP", "Calculus", "Discrete Math"};

    private static int GetPositiveNumber(String welcomeMessage, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(welcomeMessage + ": ");
        int positiveNumber = scanner.nextInt();
        while (positiveNumber <= 0) {
            System.out.println(errorMessage);
            positiveNumber = scanner.nextInt();
        }
        return positiveNumber;
    }


    public static void main(String[] args) {
        boolean showMenu = true;
        Scanner scanner = new Scanner(System.in);
        while (showMenu) {
            System.out.println("*** MENU ***");
            System.out.println("(1) View students");
            System.out.println("(2) Input students");
            System.out.println("(3) View classes");
            System.out.println("(4) Input classes");
            System.out.println("(5) Exit");
            int choice;
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (_studentData == null) {
                        System.out.println("No students found!");
                    } else {
                        int studentCount = _studentData.length;
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println("ID: " + _studentData[i][0]);
                            System.out.println("Name: " + _studentData[i][1]);
                            System.out.println("Email: " + _studentData[i][2]);
                            System.out.print("Classes: ");
                            for (int j = 3; j < _studentData[i].length; j++) {
                                System.out.print(_studentData[i][j] + " ");
                            }
                            System.out.println();
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    if (_classes == null) {
                        System.out.println("No classes available!");
                    } else {
                        int studentCount = GetPositiveNumber("Student count", "Please specify positive student count!");
                        scanner.nextLine();
                        _studentData = new String[studentCount][];
                        Random randomNumberGenerator = new Random();
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println("Student #" + (i + 1));
                            int classCount = GetPositiveNumber("Class count for current student", "Please specify positive class count!");
                            _studentData[i] = new String[3 + classCount];
                            System.out.print("Student id: ");
                            _studentData[i][0] = scanner.nextLine();
                            System.out.print("Student name: ");
                            _studentData[i][1] = scanner.nextLine();
                            System.out.print("Student email: ");
                            _studentData[i][2] = scanner.nextLine();
                            for (int j = 0; j < classCount; j++) {
                                int randomClassIndex = randomNumberGenerator.nextInt(_classes.length);
                                _studentData[i][3 + j] = _classes[randomClassIndex];
                            }
                        }
                        System.out.println("Students successfully created!");
                    }
                    break;
                case 3:
                    if (_classes == null) {
                        System.out.println("No classes to display!");
                    } else {
                        for (int i = 0; i < _classes.length; i++) {
                            System.out.println(_classes[i]);
                        }
                    }
                    break;
                case 4:
                    int classCount = GetPositiveNumber("Class count", "Please specify positive class count!");
                    _classes = new String[classCount];
                    scanner.nextLine();
                    for (int i = 0; i < classCount; i++) {
                        System.out.println("Class #" + (i + 1));
                        _classes[i] = scanner.nextLine();
                    }
                    System.out.println("Classes successfully created!");
                    break;
                case 5:
                    showMenu = false;
                    break;
                default:
                    System.out.println("Bad input! Try again.");
            }
            System.out.println();
        }
        System.out.println("Goodbye!");
    }
}
