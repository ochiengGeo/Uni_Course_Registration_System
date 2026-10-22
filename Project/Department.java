import java.util.List;
import java.util.ArrayList;

public class Department {
    private String dptName;
    Department (String name) {
        this.dptName = name;
    }
    int i = 1;
    private List<Student> deptStudents = new ArrayList<>();

    public void enrollToDpt (Student student) {
        deptStudents.add(student);
    }
    public void getDptStudents () {
        System.out.println("Students in the Department of " + dptName + " :\n");
        for (Student student : deptStudents) {
            System.out.println(i + ". " + student.getName() + " - " +student.getUserId() + " - " + student.getInstitutionalEmail());
            i++;
        }
        System.out.println("Total Number of students: " + deptStudents.size());
        System.out.println();
          
    }
}
