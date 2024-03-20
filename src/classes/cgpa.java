package classes;

/**
 * This class contains a method to calculate the CGPA of a student.
 */
public class cgpa {
    /**
     * This method calculates the CGPA of a student.
     * It iterates over the results of the student, adding up the total credit hours and the total grade points.
     * The CGPA is then calculated as the total grade points divided by the total credit hours.
     * The result is rounded to 2 decimal places before being returned.
     *
     * @param student The student whose CGPA is to be calculated.
     * @return The CGPA of the student, rounded to 2 decimal places.
     */
    public static double calculateCGPA(Student student) {
        int totalCreditHours = 0;
        double totalGradePoints = 0;
        for (Result result : student.results) {
            totalCreditHours += result.course.creditHours;
            totalGradePoints += (result.grade / 20.0) * result.course.creditHours;
        }
        double cgpa = totalGradePoints / totalCreditHours;
        return Math.round(cgpa * 100.0) / 100.0;
    }
}