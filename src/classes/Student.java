package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student with an ID and a list of results.
 */
public class Student {
    /**
     * The ID of the student.
     */
    public String id;

    /**
     * The list of results for the student.
     */
    public List<Result> results;

    /**
     * Constructs a new Student with the given ID.
     * Initializes an empty list of results.
     *
     * @param id The ID of the student.
     */
    public Student(String id) {
        this.id = id;
        this.results = new ArrayList<>();
    }
}