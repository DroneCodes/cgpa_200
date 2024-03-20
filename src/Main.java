import classes.Course;
import classes.Result;
import classes.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for the CGPA calculation program.
 * This class reads student data from a text file, calculates the CGPA for each student, and writes the results to another text file.
 */
public class Main {
    /**
     * The main method for the CGPA calculation program.
     * @param args Command line arguments. Not used in this program.
     * @throws IOException If an I/O error occurs when reading or writing files.
     */
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();

        // This block of code reads student data from a text file.
        // Each line in the file represents a student's course result.
        // The line is split into parts, each part representing a different piece of data.
        // The student ID, course code, credit hours, and grade are extracted from the line.
        // A new Course object is created with the course code and credit hours.
        // A new Result object is created with the Course object and the grade.
        // The findOrCreateStudent method is called with the students list and the student ID.
        // This method returns a Student object, either an existing one with the same ID, or a new one if no such student exists.
        // The Result object is added to the student's list of results.
        // If an IOException occurs while reading the file, it is caught and a RuntimeException is thrown.
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String studentId = parts[0];
                String courseCode = parts[1];
                int creditHours = Integer.parseInt(parts[2]);
                int grade = Integer.parseInt(parts[3]);
                Course course = new Course(courseCode, creditHours);
                Result result = new Result(course, grade);
                Student student = findOrCreateStudent(students, studentId);
                student.results.add(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // This block of code calculates the CGPA for each student and writes the results to a text file.
        // A PrintWriter is created to write to the file.
        // The calculateCGPA method of the cgpa class is called for each student.
        // The student's ID and CGPA are written to the file, separated by a comma.
        // If an IOException occurs while writing to the file, it is caught and a RuntimeException is thrown.
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            for (Student student : students) {
                double cgpa = classes.cgpa.calculateCGPA(student);
                writer.println(student.id + "," + cgpa);
            }
        }

    }

    /**
     * Finds a student in the list by ID, or creates a new student if no such student exists.
     * @param students The list of students.
     * @param id The ID of the student to find or create.
     * @return The existing or newly created student.
     */
    private static Student findOrCreateStudent(List<Student> students, String id) {
        for (Student student : students) {
            if (student.id.equals(id)) {
                return student;
            }
        }
        Student newStudent = new Student(id);
        students.add(newStudent);
        return newStudent;
    }
}