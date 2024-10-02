import java.util.HashMap;
import java.util.Scanner;

public class GradeCalculator {

    // HashMap to store grades
    private HashMap<String, Integer> grades;

    public GradeCalculator() {
        grades = new HashMap<>();
        // Initialize the HashMap with grades
        grades.put("Outline", 100);
        grades.put("Quiz1", 10); // 10 points
        grades.put("Quiz2", 10); // 10 points
        grades.put("Quiz3", 8);  // 8 points
        grades.put("Quiz4", 8);  // 8 points
        grades.put("Quiz5", 12); // 12 points
        grades.put("Assignment1", 30); // 30 points
        grades.put("Assignment2", 30); // 30 points
        grades.put("Assignment3", 30); // 30 points
        grades.put("Assignment4", 24); // 24 points
        grades.put("Assignment5", 18); // 18 points
    }

    // Function to calculate total points earned
    public int calculateTotalPoints() {
        int totalPoints = 0;
        for (Integer points : grades.values()) {
            totalPoints += points;
        }
        return totalPoints;
    }

    // Function to return the letter grade based on percentage
    public String getLetterGrade(double percentage) {
        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }

    // Function to calculate the average of quizzes
    public double calculateQuizAverage() {
        int quizTotalPoints = grades.get("Quiz1") + grades.get("Quiz2") + grades.get("Quiz3")
                           + grades.get("Quiz4") + grades.get("Quiz5");
        double quizAverage = (double) quizTotalPoints / 5; // Number of quizzes
        return (quizAverage / 10) * 100; // Convert to percentage
    }

    // Function to calculate the average of assignments
    public double calculateAssignmentAverage() {
        int assignmentTotalPoints = grades.get("Assignment1") + grades.get("Assignment2")
                                  + grades.get("Assignment3") + grades.get("Assignment4")
                                  + grades.get("Assignment5");
        double assignmentAverage = (double) assignmentTotalPoints / 5; // Number of assignments
        return (assignmentAverage / 30) * 100; // Convert to percentage
    }

    // Function to calculate overall percentage and grade
    public double calculateOverallGrade() {
        int totalPoints = calculateTotalPoints();
        int maxPoints = 100 + (10 * 5) + (30 * 5); // 100 for outline, 10 for each quiz, 30 for each assignment
        return (double) totalPoints / maxPoints * 100; // Convert to percentage
    }

    // Function to gather and print all grades and their averages
    public void printGrades() {
        double quizAverage = calculateQuizAverage();
        double assignmentAverage = calculateAssignmentAverage();
        double overallGrade = calculateOverallGrade();

        String quizLetterGrade = getLetterGrade(quizAverage);
        String assignmentLetterGrade = getLetterGrade(assignmentAverage);
        String overallLetterGrade = getLetterGrade(overallGrade);

        System.out.printf("Quiz Average: %.2f%% --> %s\n", quizAverage, quizLetterGrade);
        System.out.printf("Assignment Average: %.2f%% --> %s\n", assignmentAverage, assignmentLetterGrade);
        System.out.printf("Total Points: %d pts\n", calculateTotalPoints());
        System.out.printf("Overall Grade: %.2f%% --> %s\n", overallGrade, overallLetterGrade);
    }

    // Extra credit: Input reader with error checking
    public void inputGrades() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the percentage: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a valid percentage: ");
                scanner.next();
            }
            double percentage = scanner.nextDouble();
            String letterGrade = getLetterGrade(percentage);
            System.out.printf("Your grade: %.2f%% --> %s\n", percentage, letterGrade);
        }
    }

    public static void main(String[] args) {
        GradeCalculator gc = new GradeCalculator();
        gc.printGrades();
        gc.inputGrades();
    }
}
