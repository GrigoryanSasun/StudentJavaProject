/**
 * Created by Grigoryan on 02.03.2016.
 */
import java.util.Random;
import java.util.Scanner;

public class StudentApp {
    private static String[] _studentIds;
    private static String[] _studentNames;
    private static String[] _studentEmails;
    private static String[] _studentClasses;
    private static String[] _classes;

    private static int GetStudentCount()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Input the number of students: ");
        int studentCount = reader.nextInt();
        return studentCount;
    }

    private static void GetStudents(int studentCount)
    {
        String[] classes = new String[] { "OOP","Calculus", "Discrete Math" , "Linear Algebra"};
        Random rnd = new Random();
        Scanner reader = new Scanner(System.in);
        _studentIds = new String[studentCount];
        _studentNames = new String[studentCount];
        _studentEmails = new String[studentCount];
        _studentClasses = new String[studentCount];
        for (int i=0; i<studentCount; i++)
        {
            System.out.println("Student #" + (i + 1));
            System.out.println("Student id: ");
            _studentIds[i] = reader.next();
            System.out.println("Student name: ");
            _studentNames[i] = reader.next();
            _studentClasses[i] = classes[rnd.nextInt(classes.length)];
            System.out.println("Student email: ");
            _studentEmails[i] = reader.next();
        }
    }

    private static void SendEmail(String courseName)
    {
        for (int i=0;i<_studentClasses.length;i++)
        {
            String className = _studentClasses[i];
            if (className.equals(courseName))
            {
                System.out.println("Send email to student with email " + _studentEmails[i]);
            }
        }
    }

    private static int GetPositiveNumber(String welcomeMessage, String errorMessage)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(welcomeMessage + ": ");
        int positiveNumber = scanner.nextInt();
        while (positiveNumber <= 0)
        {
            System.out.println(errorMessage);
            positiveNumber = scanner.nextInt();
        }
        return positiveNumber;
    }


    public static void main(String[] args) {
        boolean showMenu = true;
        Scanner scanner = new Scanner(System.in);
        while (showMenu)
        {
            System.out.println("*** MENU ***");
            System.out.println("(1) View students");
            System.out.println("(2) Input students");
            System.out.println("(3) View classes");
            System.out.println("(4) Input classes");
            System.out.println("(5) Exit");
            int choice;
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    if (_studentIds == null)
                    {
                        System.out.println("No students found!");
                    }
                    else
                    {
                        int studentCount = _studentIds.length;
                        System.out.println("Id \t Name \t Email \t Class");
                        for (int i=0;i<studentCount;i++)
                        {
                            System.out.println(_studentIds[i] + "\t" + _studentNames[i] + "\t" + _studentEmails[i] + "\t" + _studentClasses[i]);
                        }
                    }
                    break;
                case 2:
                    if (_classes == null)
                    {
                        System.out.println("No classes available!");
                    }
                    else {
                        int studentCount = GetPositiveNumber("Student count","Please specify positive student count!");
                        scanner.nextLine();
                        _studentIds = new String[studentCount];
                        _studentNames = new String[studentCount];
                        _studentEmails = new String[studentCount];
                        _studentClasses = new String[studentCount];
                        Random randomNumberGenerator = new Random();
                        for (int i=0;i<studentCount;i++)
                        {
                            System.out.println("Student #" + (i+1));
                            System.out.print("Student id: ");
                            _studentIds[i] = scanner.nextLine();
                            System.out.print("Student name: ");
                            _studentNames[i] = scanner.nextLine();
                            System.out.print("Student email: ");
                            _studentEmails[i] = scanner.nextLine();
                            int randomClassIndex = randomNumberGenerator.nextInt(_classes.length);
                            _studentClasses[i] = _classes[randomClassIndex];
                        }
                        System.out.println("Students successfully created!");
                    }
                    break;
                case 3:
                    if (_classes == null)
                    {
                        System.out.println("No classes to display!");
                    }
                    else
                    {
                        for (int i=0; i<_classes.length;i++)
                        {
                            System.out.println(_classes[i]);
                        }
                    }
                    break;
                case 4:
                    int classCount = GetPositiveNumber("Class count", "Please specify positive class count!");
                    _classes = new String[classCount];
                    scanner.nextLine();
                    for (int i=0;i<classCount;i++)
                    {
                        System.out.println("Class #" + (i+1));
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
