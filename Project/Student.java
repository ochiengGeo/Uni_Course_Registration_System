public class Student extends User {
    private String courseGPA;
    private Boolean courseCompletion;
    
    Student (String name, String Id, String email) {
        setCredentials (name, Id, email);
    }
}
