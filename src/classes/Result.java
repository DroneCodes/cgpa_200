package classes;

/**
 * Represents a result with a course and grade.
 */
public class Result {
    /**
     * The course of the result.
     */
    Course course;

    /**
     * The grade of the result.
     */
    int grade;

    /**
     * Constructs a new Result with the given course and grade.
     *
     * @param course The course of the result.
     * @param grade The grade of the result.
     */
    public Result(Course course, int grade) {
        this.course = course;
        this.grade = grade;
    }
}