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

        // Read file and populate students list
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

        // Calculate CGPA and write to file
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