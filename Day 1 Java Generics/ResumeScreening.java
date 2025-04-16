abstract class JobRole {
    String candidateName;
    JobRole(String candidateName) { this.candidateName = candidateName; }
    public String toString() { return getClass().getSimpleName() + ": " + candidateName; }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String name) { super(name); }
}

class DataScientist extends JobRole {
    DataScientist(String name) { super(name); }
}

class ProductManager extends JobRole {
    ProductManager(String name) { super(name); }
}

class Resume<T extends JobRole> {
    private T role;
    Resume(T role) { this.role = role; }
    public T getRole() { return role; }
    public static void processResumes(java.util.List<? extends JobRole> resumes) {
        for (JobRole r : resumes) {
            System.out.println("Processing resume for: " + r);
        }
    }
}

public class ResumeScreening {
    public static void main(String[] args) {
        java.util.List<SoftwareEngineer> engineers = java.util.Arrays.asList(
                new SoftwareEngineer("Alice"), new SoftwareEngineer("Bob"));

        java.util.List<DataScientist> scientists = java.util.Arrays.asList(
                new DataScientist("Charlie"));

        Resume.processResumes(engineers);
        Resume.processResumes(scientists);
    }
}
