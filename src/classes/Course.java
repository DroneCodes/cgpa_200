package classes;

/**
 * Represents a course with a code and credit hours.
 */
public class Course {
    /**
     * The code of the course.
     */
    String code;

    /**
     * The number of credit hours of the course.
     */
    int creditHours;

    /**
     * Constructs a new Course with the given code and credit hours.
     *
     * @param code The code of the course.
     * @param creditHours The number of credit hours of the course.
     */
    public Course(String code, int creditHours) {
        this.code = code;
        this.creditHours = creditHours;
    }
}