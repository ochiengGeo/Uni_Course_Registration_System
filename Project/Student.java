public class Student extends User {

    private String courseGPA;
    private Boolean courseCompletion;

    public Student(String userId, String name,
                   String institutionalEmail, String passwordHash) {
        super(userId, name, institutionalEmail, passwordHash);
    }
}
