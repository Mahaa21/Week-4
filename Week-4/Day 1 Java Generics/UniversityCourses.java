abstract class CourseType {
    String title;
    CourseType(String title) { this.title = title; }
    public String toString() { return getClass().getSimpleName() + ": " + title; }
}

class ExamCourse extends CourseType {
    ExamCourse(String title) { super(title); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String title) { super(title); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String title) { super(title); }
}

class Course<T extends CourseType> {
    private java.util.List<T> courseList = new java.util.ArrayList<>();
    public void addCourse(T course) { courseList.add(course); }
    public java.util.List<T> getCourses() { return courseList; }
    public static void displayCourses(java.util.List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println(c);
        }
    }
}

public class UniversityCourses {
    public static void main(String[] args) {
        Course<ExamCourse> exams = new Course<>();
        exams.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignments = new Course<>();
        assignments.addCourse(new AssignmentCourse("Software Engineering"));

        Course<ResearchCourse> research = new Course<>();
        research.addCourse(new ResearchCourse("Quantum Computing"));

        Course.displayCourses(exams.getCourses());
        Course.displayCourses(assignments.getCourses());
        Course.displayCourses(research.getCourses());
    }
}
