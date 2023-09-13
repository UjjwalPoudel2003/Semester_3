import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    /**
     * This program will calculate the grades of the students
     * nobodyKnowsJavaIsShit
     */
    public static void main(String[] args) {
        testMethod();
    }

    public static void testMethod() {
        // Creating object of Student class
        Student firstStudent = new Student();

        // Taking user Input
        System.out.print("Enter Student Name: ");
        firstStudent.getName(informationExtractor());
        System.out.print("Enter Number of Grades: ");
        String totalNoOfSubjects = informationExtractor();

        int number = Integer.parseInt(totalNoOfSubjects);
        firstStudent.getTotalSubject(number);
        firstStudent.displayTestInformation();
        firstStudent.getSubjectList();
        firstStudent.getSubjectGrades();
    }

    // Method for User Input
    public static String informationExtractor() {
        Scanner inputTaker = new Scanner(System.in);
        return inputTaker.nextLine();
    }
}

// Creating class Student
class Student {
    private String name;
    private int subjectTotal;
    ArrayList<String> subjectList = new ArrayList<>();
    Dictionary<String, Integer> grades = new Hashtable<>();

    // Method to get student name
    void getName(String name) {
        this.name = name;
    }

    // Method to get total number of subjects of students
    void getTotalSubject(int totalSubject) {
        this.subjectTotal = totalSubject;
    }

    // Method to get the grades of each subject
    void getSubjectList() {
        Scanner input = new Scanner(System.in);
        // Using loop to get the subject list
        for (int i=0; i < this.subjectTotal; i++) {
            System.out.print("Enter subject ("+ (i+1) + "): ");
            subjectList.add(input.nextLine());
        }
    }

    double calculateTotalGpa() {
        for (double value : grades.values()) {

        }
    }

    void getSubjectGrades() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the grades for each subjects");
        for (String i : subjectList) {
            System.out.print(i + ": ");
            grades.put(i, Integer.parseInt(input.nextLine()));
        }
    }


    void displayTestInformation() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Total Subjects: " + this.subjectTotal);
    }
}